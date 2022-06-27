package com.example.clinicmangmentsystem;

import android.content.SharedPreferences;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientapp {



    public  static Retrofit getretrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://still-forest-54586.herokuapp.com/")

                .client(okHttpClient)

                .build();

        return  retrofit;

    }

    public static  interfaceServece getservice()
    {
        interfaceServece interfaceServece= getretrofit().create(com.example.clinicmangmentsystem.interfaceServece.class);
        return interfaceServece;

    }


}
