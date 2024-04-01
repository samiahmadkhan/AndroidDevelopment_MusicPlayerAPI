package com.sami.testingmusicapi_deezer.Search;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterfaceArtist {
    @Headers({"X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com",
            "X-RapidAPI-Key: 3820374146mshbe31b8f7d4f0bf7p1f854djsn9b48214599ee"})
    @GET("/artist/{id}")
    Call<ArtistData> getArtistData(@Path("id") int id);
}
