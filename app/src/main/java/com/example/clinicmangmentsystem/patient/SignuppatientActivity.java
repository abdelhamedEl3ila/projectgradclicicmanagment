package com.example.clinicmangmentsystem.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.clinicmangmentsystem.ApiClientapp;
import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.RejesterRequest;
import com.example.clinicmangmentsystem.RejesterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignuppatientActivity extends AppCompatActivity {
    CheckBox checkBoxA, checkBoxB;
    EditText fristusername,lastusername,password,email,phonenumber;
    Button next;
    SharedPreferences preferences ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppatient);
        checkBoxA = (CheckBox) findViewById(R.id.checkBoxA);
        checkBoxB = (CheckBox) findViewById(R.id.checkBoxB);
        fristusername=findViewById(R.id.fristusername);
        lastusername=findViewById(R.id.lastusername);
        password=findViewById(R.id.pasworduser);
        email=findViewById(R.id.emailpat);
        phonenumber=findViewById(R.id.phonenumuser);
        next=findViewById(R.id.nextpatientbtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(fristusername.getText().toString()) || TextUtils.isEmpty(password.getText().toString()) || TextUtils.isEmpty(phonenumber.getText().toString())){



            }
                RejesterRequest rejesterRequest = new RejesterRequest();
                rejesterRequest.setEmail(email.getText().toString());
                rejesterRequest.setPassword(password.getText().toString());
                rejesterRequest.setMobile_number(phonenumber.getText().toString());
                rejesterRequest.setName(fristusername.getText().toString());
                registerpatient(rejesterRequest);
                Intent intent = new Intent(SignuppatientActivity.this,LoginActivity.class);
                startActivity(intent);
            }





        });




    }

    public void onCheckboxClicked(View view) {
        switch (view.getId()) {

            case R.id.checkBoxA:

                checkBoxB.setChecked(false);


                break;

            case R.id.checkBoxB:

                checkBoxA.setChecked(false);

                break;
        }
    }
    public void registerpatient (RejesterRequest rejesterRequest)
    {
        Call<RejesterResponse>rejesterResponseCall = ApiClientapp.getservice().registeruser(rejesterRequest);
        rejesterResponseCall.enqueue(new Callback<RejesterResponse>() {
            @Override
            public void onResponse(Call<RejesterResponse> call, Response<RejesterResponse> response) {

                if (response.isSuccessful())
                {
                    startActivity(new Intent(SignuppatientActivity.this,LoginActivity.class));
                    finish();

                }else {
                    String message = "an error occured please try again";
                    Toast.makeText(SignuppatientActivity.this,message,Toast.LENGTH_LONG);


                }


            }


            @Override
            public void onFailure(Call<RejesterResponse> call, Throwable t) {

                String message = t.getLocalizedMessage();
                Toast.makeText(SignuppatientActivity.this,message,Toast.LENGTH_LONG);

            }
        });


    }




    }
