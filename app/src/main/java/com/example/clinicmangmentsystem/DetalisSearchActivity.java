package com.example.clinicmangmentsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.clinicmangmentsystem.adapter.DoctorAdapter;
import com.example.clinicmangmentsystem.model.DoctorModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalisSearchActivity extends AppCompatActivity {
RecyclerView recyclerView ;
    private List<DoctorModel> doctorModels;
    private DoctorAdapter doctorAdapter ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalis_search);
        recyclerView=findViewById(R.id.Docdetailsrec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        doctorAdapter = new DoctorAdapter(this,doctorModels);
        recyclerView.setAdapter(doctorAdapter);
        interfaceServece interfacee = ApiClientapp.getretrofit()
                .create(interfaceServece.class);
        Call<List<DoctorModel>>call=interfacee.getallDoctor();
        call.enqueue(new Callback<List<DoctorModel>>() {
            @Override
            public void onResponse(Call<List<DoctorModel>> call, Response<List<DoctorModel>> response) {
                if (!response.isSuccessful())
                {

                    return;

                }
                doctorModels=response.body();
            }

            @Override
            public void onFailure(Call<List<DoctorModel>> call, Throwable t) {
                Log.d("TAG","ON Failure"+t.getLocalizedMessage()+"");
            }
        });

    }
}