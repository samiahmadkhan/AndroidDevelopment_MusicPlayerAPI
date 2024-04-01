package com.sami.testingmusicapi_deezer.Search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.sami.testingmusicapi_deezer.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchArtist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ImageView artistImage=findViewById(R.id.imageView3);
        ImageView imageView5=findViewById(R.id.imageView5);

        TextView artistName=findViewById(R.id.textView3);





        Retrofit retrofit= new Retrofit.Builder().baseUrl("https://deezerdevs-deezer.p.rapidapi.com").
                addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterface requestData=retrofit.create(ApiInterface.class); //to create interface obj

        Intent intent=getIntent();
        String artist=intent.getStringExtra("name").toString();

        requestData.getData(artist).enqueue(new Callback<MyData>() {
            @Override
            public void onResponse(Call<MyData> call, Response<MyData> response) {
                System.out.println("Samiiii res= "+response.body().getData().get(0).getPreview());
                 int dataSize=response.body().getData().size();
                List<DataItem> data=response.body().getData();
                Picasso.get().load(response.body().getData().get(3).getArtist().getPicture_big()).into(artistImage);
                Picasso.get().load(response.body().getData().get(3).getArtist().getPicture_big()).into(imageView5);

                artistName.setText(response.body().getData().get(3).getArtist().getName());

                CustomAdapter customAdapter = new CustomAdapter(data);
                recyclerView.setAdapter(customAdapter);

            }

            @Override
            public void onFailure(Call<MyData> call, Throwable t) {
                Log.d("TAG: onFailure", "OnFailure : "+ t.getMessage());
               // txt.setText(t.getMessage());

            }
        });

//        Intent playSong=new Intent(this,PlaySongActivity.class);
//        playSong.putExtra("songName","name");
//        playSong.putExtra("songImage","image");
//        playSong.putExtra("track","track");
//        startActivity(playSong);







    }
}