package com.example.clinicmangmentsystem;

import com.example.clinicmangmentsystem.model.DoctorModel;
import com.example.clinicmangmentsystem.model.DoctorProf;
import com.example.clinicmangmentsystem.model.Editresponse;
import com.example.clinicmangmentsystem.model.Login;
import com.example.clinicmangmentsystem.model.MedicalResponse;
import com.example.clinicmangmentsystem.model.ModelMedical;
import com.example.clinicmangmentsystem.model.PostMedical;
import com.example.clinicmangmentsystem.model.ReviewModel;
import com.example.clinicmangmentsystem.model.SelectDoctor;
import com.example.clinicmangmentsystem.model.ShowAllReview;
import com.example.clinicmangmentsystem.model.Showbooking;
import com.example.clinicmangmentsystem.model.UpdeteUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface interfaceServece {
    @POST("api/auth/userLogin")
    Call<Login> loginuser(@Body LoginRequest loginRequest);
    @POST("api/auth/userRegister")
    Call<RejesterResponse> registeruser(@Body RejesterRequest rejesterRequest);
    @GET("api/auth/showDoctors")
    Call<DoctorModel> getallDoctor(
            @Header( "Authorization" ) String token
    );


    @POST("api/auth/addMedicalHistory")
    Call<MedicalResponse> storeallmedical(
            @Header( "Authorization" ) String token,
            @Body PostMedical postMedical
         );
    @GET("api/auth/getMedicalHistory")
    Call<ModelMedical> getallmedical(
            @Header( "Authorization" ) String token
    );

    @GET("api/auth/userProfile")
    Call<Editresponse> getuserprofile(
            @Header( "Authorization" ) String token
            );

    @POST("api/auth/profile/{id}")
    Call<DoctorProf> getprofiledoc(
            @Header( "Authorization" ) String type,
      @Path("id") int id

    );
    @POST("api/auth/select/{id}")
    Call<SelectDoctor> selectdoc(
            @Header("Authorization") String token,
            @Path("id") int id,
            @Query("day") String day);


    @GET("api/auth/bookedAppointments")
    Call<Showbooking> getallshdule(
            @Header( "Authorization" ) String token
    );

    @POST("api/auth/cancelAppointment/{id}")
    Call<SelectDoctor> cancelbook(
            @Header("Authorization") String token,
            @Path("id") int id

    );
    @GET("api/auth/showReviews/{id}")
    Call<ShowAllReview> getallreview(
            @Header( "Authorization" ) String token,
            @Path("id") int id
    );

    @POST("api/auth/createReview/{id}")
    Call<ReviewModel> postreview(
            @Header( "Authorization" ) String token,
            @Path("id") int id,
           @Body ReviewModel reviewModel
    );
    @POST("api/auth/user/updateProfile/{id}")
    Call<Editresponse> postupdate(
            @Header( "Authorization" ) String token,
            @Path("id") long id,
            @Body UpdeteUser updateuser
    );
    @POST("api/auth/userlogout")
    Call<User> logout(
            @Header( "Authorization" ) String token

    );
}
