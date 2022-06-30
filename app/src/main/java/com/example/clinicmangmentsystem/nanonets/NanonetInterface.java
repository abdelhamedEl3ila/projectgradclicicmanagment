package com.example.clinicmangmentsystem.nanonets;

import com.example.clinicmangmentsystem.model.Headlines;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NanonetInterface {

    @GET("e9003661-31c9-489f-a53e-05e486faf28f/LabelFile")
    Call<Headlines> getHeadlines(
            @Query("apiKey") String apiKey,
            @Query("file") String file
    );
}
