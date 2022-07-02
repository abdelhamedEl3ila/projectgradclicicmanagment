package com.example.clinicmangmentsystem.patient;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.car.ui.IFocusArea;
import com.example.clinicmangmentsystem.ApiClientapp;
import com.example.clinicmangmentsystem.DetalisSearchActivity;
import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.User;
import com.example.clinicmangmentsystem.model.Editresponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfilepatFragment extends Fragment {
    private Dialog dialogcall;
TextView passwordshow , fullusername;
Button openprofile;
      private  Button Logout;


Context context;
    private String token;

    public ProfilepatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_profilepat, container, false);
        openprofile=v.findViewById(R.id.profile);
        fullusername=v.findViewById(R.id.usernametxtview1);
        passwordshow=v.findViewById(R.id.phonenumusertxtview1);
        SharedPreferences preferences=v.getContext().getSharedPreferences("Token", v.getContext().MODE_PRIVATE);
        token=preferences.getString("token",null);
        getdataprofile();

        Logout=v.findViewById(R.id.logoutbtn);

        dialogcall = new Dialog(v.getContext());
        dialogcall.setContentView(R.layout.logoutdiolg);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialogcall.getWindow().setBackgroundDrawable(v.getContext().getDrawable(R.drawable.custom_dialog_background));
        }
        dialogcall.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogcall.setCancelable(true); //Optional
        dialogcall.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog
        Button call = dialogcall.findViewById(R.id.btn_logout);
        Button Cancel = dialogcall.findViewById(R.id.btn_cancellogout);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<User> call1 = ApiClientapp.getservice().logout("Bearer "+token);
                call1.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful())
                        {
                            Intent in = new Intent(v.getContext(), LoginActivity.class);
                            v.getContext().startActivity(in);

                        }
                        else {
                            String message ="error";
                            Toast.makeText(v.getContext(),message,Toast.LENGTH_SHORT).show();

                        }
                    }
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        String message = t.getLocalizedMessage();
                        Toast.makeText(v.getContext(),message,Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogcall.dismiss();
            }
        });
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogcall.show();

            }
        });
        openprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfilePatientActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return v;
    }






    private void getdataprofile() {
        Call<Editresponse> call= ApiClientapp.getservice().getuserprofile("Bearer "+token);
        call.enqueue(new Callback<Editresponse>() {
            @Override
            public void onResponse(Call<Editresponse> call, Response<Editresponse> response) {

                if (response.isSuccessful() && response.body().getUser() != null) {

                    fullusername.setText(response.body().getUser().getName());
                    passwordshow.setText(response.body().getUser().getMobile_number());


                }
            }

            @Override
            public void onFailure(Call<Editresponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(context.getApplicationContext(),message,Toast.LENGTH_SHORT).show();

            }
        });
    }
    }

