package com.example.clinicmangmentsystem.patient;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clinicmangmentsystem.R;


public class HomepatFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match


    public HomepatFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_homepat, container, false);
       return v;

    }
}