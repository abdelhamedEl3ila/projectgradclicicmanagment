package com.example.clinicmangmentsystem.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.Editable;
import android.widget.Toast;

import com.example.clinicmangmentsystem.ApiClientapp;
import com.example.clinicmangmentsystem.LoginRequest;
import com.example.clinicmangmentsystem.LoginResponse;
import com.example.clinicmangmentsystem.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
TextView createacctxt;
EditText username;

EditText passwordpat;

    boolean passwordvisable;
   ProgressDialog progressDialog;
Button login ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        createacctxt = findViewById(R.id.createaccpat);
        login=findViewById(R.id.loginaspatientbtn);
        username = findViewById(R.id.editTextTextEmailAddress);
        passwordpat= findViewById(R.id.editTextTextPasswordpatient);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (TextUtils.isEmpty(username.getText().toString()))

                {
                    username.setError("Please enter username");

                    return;


                }
                if (TextUtils.isEmpty(passwordpat.getText().toString()))
                {
                    passwordpat.setError("please enter your password");
                    return;



                }
                else{

                    LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setEmail(username.getText().toString());
                    loginRequest.setPassword(passwordpat.getText().toString());
                    loginuser(loginRequest);


                }


            }
        });
        createacctxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignuppatientActivity.class);
                startActivity(i);
            }
        });




        passwordpat.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right =2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if (event.getRawX()>=passwordpat.getRight()-passwordpat.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=passwordpat.getSelectionEnd();
                        if (passwordvisable){
                            //set drwableimage
                            passwordpat.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            //hide password
                            passwordpat.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordvisable=false;
                        }
                        else {
                            //set drwableimage
                            passwordpat.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            //show password
                            passwordpat.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordvisable=true;
                        }
                        passwordpat.setSelection(selection);
                        return true;



                    }




                }
                return false;
            }
        });


    }
    public   void  loginuser(LoginRequest loginRequest)
    {
        Call<LoginResponse> loginResponseCall = ApiClientapp.getservice().loginuser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful())
                {


//                    progressDialog = new ProgressDialog(LoginActivity.this);
//                    progressDialog.show();
//                    progressDialog.setContentView(R.layout.progress_dialog);
//                    progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//                    Thread time = new Thread()
//                    {
//                        @Override
//                        public void run() {
//                            try {
//                                sleep(2000);
//
//                                progressDialog.dismiss();
//                                finish();
//                            }catch (InterruptedException e){
//                                e.printStackTrace();
//                            }
//                        }
//                    };
//                    time.start();

                    LoginResponse loginResponse = response.body();
                    startActivity(new Intent(LoginActivity.this,MainActivity.class).putExtra("data",loginResponse));
                    finish();



                }
                else {

                    String message="ana error occurred please try again ..";
                    Toast.makeText(LoginActivity.this,message,Toast.LENGTH_LONG).show();;



                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(LoginActivity.this,message,Toast.LENGTH_LONG).show();;

            }
        });



    }


}