package com.sami.testingmusicapi_deezer.Search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.sami.testingmusicapi_deezer.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    static ArrayList<String> n = new ArrayList<String>();

    static ArrayList<String> i = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_artist);
        RecyclerView recyclerView;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        getTopArrtistName(new DataCallback() {
            @Override
            public void onDataLoaded(ArrayList<String> names) {
                // Use the loaded data here
                n.addAll(names);
                getTopArtist_Images(n, new ImageCallback() {
                    @Override
                    public void onImagesLoaded(ArrayList<String> images) {
                        i.addAll(images);
                        CustomAdapter_ArtistList adapter = new CustomAdapter_ArtistList(i, n);
                        recyclerView.setAdapter(adapter);
                    }
                });


                // Create and set adapter after data is loaded

            }
        });
    }
    public interface DataCallback {
        void onDataLoaded(ArrayList<String> names);
    }
    public interface ImageCallback {
        void onImagesLoaded(ArrayList<String> images);
    }
    public void getTopArrtistName(DataCallback callback) {

        String url = "https://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=bec94c7fd459c5843c74b65fc5bc2697&format=json";

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        // on below line making string request to generate access token.
        JsonObjectRequest JsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONArray obj = null;
                ArrayList<String> names = new ArrayList<String>();
                ArrayList<String> images = new ArrayList<String>();

                try {
                    obj = response.getJSONObject("artists").getJSONArray("artist");
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                for (int i = 0; i < obj.length(); i++) {
                    try {
                        names.add(obj.getJSONObject(i).getString("name").toString());
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
                callback.onDataLoaded(names);
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Log.d("Response obj name: ", "response error samii");
                ;
            }
        }) ;
        queue.add(JsonObjectRequest);


    }

    public ArrayList<String> getTopArtist_Images(ArrayList<String> names,ImageCallback callback){
        ArrayList<String> imagess=new ArrayList<String>();
        AtomicInteger count = new AtomicInteger(names.size());
        for(String artist:names){
            Retrofit retrofit= new Retrofit.Builder().baseUrl("https://deezerdevs-deezer.p.rapidapi.com").
                    addConverterFactory(GsonConverterFactory.create()).build();
            ApiInterface requestData=retrofit.create(ApiInterface.class); //to create interface obj

            requestData.getData(artist).enqueue(new Callback<MyData>() {
                @Override
                public void onResponse(Call<MyData> call, retrofit2.Response<MyData> response) {
                    if (response.body().getData().size() >= 4) {
                        imagess.add(response.body().getData().get(3).getArtist().getPicture_big().toString());
                    }
                    if (count.decrementAndGet() == 0) {
                        callback.onImagesLoaded(imagess);
                    }

                }
                @Override
                public void onFailure(Call<MyData> call, Throwable t) {
                    Log.d("TAG: onFailure", "OnFailure : "+ t.getMessage());
                    // txt.setText(t.getMessage());
                    if (count.decrementAndGet() == 0) {
                        callback.onImagesLoaded(imagess);
                    }

                }
            });
        }
        return imagess;

    }
}