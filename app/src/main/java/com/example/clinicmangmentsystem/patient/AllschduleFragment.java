package com.example.clinicmangmentsystem.patient;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.adapter.SchduleAdapter;
import com.example.clinicmangmentsystem.model.Schdulepat;

import java.util.ArrayList;

public class AllschduleFragment extends Fragment {
RecyclerView recyclerView;
private  ArrayList<Schdulepat> schdulepats;
SchduleAdapter adapter;



    public AllschduleFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_allschdule, container, false);
        recyclerView=v.findViewById(R.id.recschdulepat);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        schdulepats= new ArrayList<>();
         schdulepats.add(new Schdulepat("Ahmed mohmaed",R.drawable.healthcare_workers_medicine_covid_19_pandemic_self_quarantine_concept_smiling_attractive_doctor_scrubs_glasses_stethoscope_neck_cross_arms_chest_ready_help_patients_2,"Eyes","15 may 2022"));
          schdulepats.add(new Schdulepat("MIDO",R.drawable.healthcare_workers_medicine_covid_19_pandemic_self_quarantine_concept_smiling_attractive_doctor_scrubs_glasses_stethoscope_neck_cross_arms_chest_ready_help_patients_2,"midp","15may2015"));
       adapter= new SchduleAdapter(getContext(),schdulepats);
       recyclerView.setAdapter(adapter);
       return v;


    }


}