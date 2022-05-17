package com.example.clinicmangmentsystem.patient;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.clinicmangmentsystem.R;


public class ProfilepatFragment extends Fragment {

TextView showprofile , fullusername;
private  static final String FILE_NAME ="MySharedPref";
LinearLayout linprofile;

    public ProfilepatFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_profilepat, container, false);
linprofile=v.findViewById(R.id.line1);
fullusername= v.findViewById(R.id.usernametxtview1);





        showprofile=v.findViewById(R.id.editprofiletxt);


        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        String username =sharedPreferences.getString("fristname","");






        fullusername.setText(username);
        showprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(linprofile.getVisibility()==View.VISIBLE)
                {
                    linprofile.setVisibility(View.GONE);

                }
                else {

                    linprofile.setVisibility(View.VISIBLE);


                }
            }
        });

    return v;
    }
}