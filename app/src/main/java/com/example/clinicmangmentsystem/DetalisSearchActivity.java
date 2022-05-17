package com.example.clinicmangmentsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.clinicmangmentsystem.adapter.DoctorAdapter;
import com.example.clinicmangmentsystem.model.DoctorModel;

import java.util.ArrayList;

public class DetalisSearchActivity extends AppCompatActivity {
RecyclerView recyclerView ;
    private ArrayList<DoctorModel> doctorModels;
    private DoctorAdapter doctorAdapter ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalis_search);
        recyclerView=findViewById(R.id.Docdetailsrec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent i = getIntent();
        String specalityname = i.getStringExtra("specltityname");
        String specalityicon = i.getStringExtra("specialtyimage");
        doctorModels= new ArrayList<>();
        doctorAdapter = new DoctorAdapter(this,doctorModels);
        recyclerView.setAdapter(doctorAdapter);
       doctorModels.add(new DoctorModel("specalityname",R.drawable.ic_paediatricsicon,"mido","abaaas elaqad","250",R.drawable.ic_doctor_svgrepo_com,"30min","avalible at 4pm",3));
       doctorModels.add(new DoctorModel(specalityname,R.drawable.ic_paediatricsicon,"mido","abaaas elaqad","250",R.drawable.ic_doctor_svgrepo_com,"30min","avalible at 4pm",3));
       doctorModels.add(new DoctorModel(specalityname,R.drawable.ic_paediatricsicon,"mido","abaaas elaqad","250",R.drawable.ic_doctor_svgrepo_com,"30min","avalible at 4pm",3));



    }
}