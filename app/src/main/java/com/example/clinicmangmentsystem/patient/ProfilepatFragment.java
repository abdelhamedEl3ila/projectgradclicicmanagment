package com.example.clinicmangmentsystem.patient;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clinicmangmentsystem.ApiClientapp;
import com.example.clinicmangmentsystem.LoginResponse;
import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.adapter.NewsAdapter;
import com.example.clinicmangmentsystem.model.Editresponse;
import com.example.clinicmangmentsystem.model.Profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfilepatFragment extends Fragment {

TextView showprofile , fullusername;
LinearLayout linprofile;
EditText username,email,phonenumber;
Button editprofile,saveedit;
String token ;
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
email=v.findViewById(R.id.emailedit);
phonenumber=v.findViewById(R.id.mobileedit);
username=v.findViewById(R.id.fulluser);
editprofile=v.findViewById(R.id.editprofile);
saveedit=v.findViewById(R.id.saveediyprofile);
        SharedPreferences preferences=this.getActivity().getSharedPreferences("Token", this.getActivity().getApplicationContext().MODE_PRIVATE);

        token=preferences.getString("token",null);
editprofile.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        username.setEnabled(true);
        email.setEnabled(true);
        phonenumber.setEnabled(true);
    }
});
        showprofile=v.findViewById(R.id.editprofiletxt);
        Call<Editresponse> call= ApiClientapp.getservice().getuserprofile("Bearer "+token);
        call.enqueue(new Callback<Editresponse>() {
            @Override
            public void onResponse(Call<Editresponse> call, Response<Editresponse> response) {

                if (response.isSuccessful() && response.body().getUser() != null) {

                    username.setText(response.body().getUser().getMobile_number());
                  fullusername.setText(response.body().getUser().getName());
                phonenumber.setText(response.body().getUser().getGender());
                email.setText(response.body().getUser().getEmail());

                    SharedPreferences preferences = getContext().getSharedPreferences("User",getContext(). getApplicationContext().MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username",response.body().getUser().getName());
                    editor.putString("phonenumber", response.body().getUser().getMobile_number());
                    editor.commit();

                }
            }

            @Override
            public void onFailure(Call<Editresponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();

            }
        });

    return v;
    }
}