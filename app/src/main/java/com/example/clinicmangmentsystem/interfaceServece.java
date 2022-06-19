package com.example.clinicmangmentsystem;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface interfaceServece {

    @POST("api/auth/userLogin")
    Call<LoginResponse>loginuser(@Body LoginRequest loginRequest);
    @POST("api/auth/userRegister")
    Call<RejesterResponse> registeruser(@Body RejesterRequest rejesterRequest);



}
