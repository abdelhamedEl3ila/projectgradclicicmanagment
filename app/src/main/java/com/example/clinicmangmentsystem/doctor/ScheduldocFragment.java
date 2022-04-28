package com.example.clinicmangmentsystem.doctor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clinicmangmentsystem.R;


public class ScheduldocFragment extends Fragment {



    public ScheduldocFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_scheduldoc, container, false);
        return  v;
     }
}