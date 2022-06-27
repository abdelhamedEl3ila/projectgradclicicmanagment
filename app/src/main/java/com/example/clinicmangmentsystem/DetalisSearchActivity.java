package com.example.clinicmangmentsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.clinicmangmentsystem.adapter.DoctorAdapter;
import com.example.clinicmangmentsystem.adapter.NewsAdapter;
import com.example.clinicmangmentsystem.adapter.SearchAdapter;
import com.example.clinicmangmentsystem.model.Datum;
import com.example.clinicmangmentsystem.model.DoctorModel;
import com.example.clinicmangmentsystem.model.Login;
import com.example.clinicmangmentsystem.model.Search;
import com.example.clinicmangmentsystem.patient.LoginActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalisSearchActivity extends AppCompatActivity {
RecyclerView recyclerView ;
    private List<Datum> data=new ArrayList<>();
    private DoctorAdapter doctorAdapter ;
    private String token;
     ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalis_search);
        recyclerView=findViewById(R.id.Docdetailsrec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        doctorAdapter = new DoctorAdapter(this,data);
        recyclerView.setAdapter(doctorAdapter);
        SharedPreferences prfs = getSharedPreferences("Token", Context.MODE_PRIVATE);
         token = prfs.getString("token", "");
          progressDialog = new ProgressDialog(DetalisSearchActivity.this);
          progressDialog.show();
          progressDialog.setContentView(R.layout.progress_dialog);
          progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Thread time = new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    progressDialog.dismiss();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        time.start();
        Call<DoctorModel> call;
        call=ApiClientapp.getservice().getallDoctor("Bearer "+token);

        call.enqueue(new Callback<DoctorModel>() {
            @Override
            public void onResponse(Call<DoctorModel> call, Response<DoctorModel> response) {
                if (response.isSuccessful() && response.body().getData() != null) {
                    data.addAll(response.body().getData());

                    doctorAdapter.notifyDataSetChanged();

                }
                else {

                    String message="error";
                    Toast.makeText(DetalisSearchActivity.this,message,Toast.LENGTH_LONG).show();;

                }
            }

            @Override
            public void onFailure(Call<DoctorModel> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(DetalisSearchActivity.this,message,Toast.LENGTH_LONG).show();;


            }});


    }
}