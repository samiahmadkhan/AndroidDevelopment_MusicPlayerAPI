package com.sami.testingmusicapi_deezer.Search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.sami.testingmusicapi_deezer.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_artist);
        RecyclerView recyclerView;
        String arr[]={"Text1","Text2","Text3","Text4"};

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        List<String> artist=new ArrayList<String>(Arrays.asList("Eminem","Billie Eilish","Justin Bieber","Dr. Dre"));
                List<String> images=new ArrayList<String>(Arrays.asList("https://e-cdns-images.dzcdn.net/images/artist/19cc38f9d69b352f718782e7a22f9c32/500x500-000000-80-0-0.jpg",
                "https://e-cdns-images.dzcdn.net/images/artist/06c8d6bea13f18e259d7a24c9aa9fdab/500x500-000000-80-0-0.jpg",
                "https://e-cdns-images.dzcdn.net/images/artist/22dd86b628a03d8dad3c7dfb33320a91/500x500-000000-80-0-0.jpg",
                "https://e-cdns-images.dzcdn.net/images/artist/4a059263726fe8976d604d32ff7f3900/500x500-000000-80-0-0.jpg"));


        Retrofit retrofit= new Retrofit.Builder().baseUrl("https://deezerdevs-deezer.p.rapidapi.com").
                addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterfaceArtist requestData=retrofit.create(ApiInterfaceArtist.class); //to create interface obj

            requestData.getArtistData(1).enqueue(new Callback<ArtistData>() {
                @Override
                public void onResponse(Call<ArtistData> call, Response<ArtistData> response) {
//                    images.add(response.body().getPicture_big());
                    CustomAdapter_ArtistList adapter=new CustomAdapter_ArtistList(images,artist);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<ArtistData> call, Throwable t) {
//                    Log.i("Failure","Failure ");
                }
            });

        System.out.println(images.size());
//
//            CustomAdapter_ArtistList customAdapter = new CustomAdapter_ArtistList(io);
//            recyclerView.setAdapter(customAdapter);





    }
}