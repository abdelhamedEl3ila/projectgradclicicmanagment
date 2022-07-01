package com.example.clinicmangmentsystem.nanonets;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NanonetsClient {
    private static final String BASE_URL = "https://app.nanonets.com/api/v2/OCR/Model/";
    private static NanonetsClient apiClient;
    private static Retrofit retrofit;

    private NanonetsClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static synchronized NanonetsClient getInstance(){
        if (apiClient == null){
            apiClient = new NanonetsClient();
        }
        return apiClient;
    }


    public NanonetInterface getApi(){
        return retrofit.create(NanonetInterface.class);
    }

}
