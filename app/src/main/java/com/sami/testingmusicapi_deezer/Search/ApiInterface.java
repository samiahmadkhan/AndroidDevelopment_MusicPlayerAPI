package com.sami.testingmusicapi_deezer.Search;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {
    @Headers({"X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com",
              "X-RapidAPI-Key: 3820374146mshbe31b8f7d4f0bf7p1f854djsn9b48214599ee"})
    @GET("/search")
    Call<MyData> getData(@Query("q") String q);

}
