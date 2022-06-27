package com.example.clinicmangmentsystem.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clinicmangmentsystem.ApiClientapp;
import com.example.clinicmangmentsystem.LoginRequest;
import com.example.clinicmangmentsystem.LoginResponse;
import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.model.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
TextView createacctxt;
EditText username;
EditText passwordpat;
CheckBox saveLoginCheckBox;

boolean passwordvisable;
private SharedPreferences loginPreferences;
private SharedPreferences.Editor loginPrefsEditor;
private Boolean saveLogin;
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
        saveLoginCheckBox = (CheckBox)findViewById(R.id.saveLoginCheckBox);

        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            username.setText(loginPreferences.getString("username", ""));
            passwordpat.setText(loginPreferences.getString("password", ""));
            saveLoginCheckBox.setChecked(true);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                Thread time = new Thread()
                {
                    @Override
                    public void run() {
                        try {
                            sleep(2200);
                            progressDialog.dismiss();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                };
                time.start();

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
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(username.getWindowToken(), 0);

                  String  usernametxt = username.getText().toString();
                 String   passwordtxt = passwordpat.getText().toString();

                    if (saveLoginCheckBox.isChecked()) {
                        loginPrefsEditor.putBoolean("saveLogin", true);
                        loginPrefsEditor.putString("username", usernametxt);
                        loginPrefsEditor.putString("password", passwordtxt);
                        loginPrefsEditor.commit();
                    } else {
                        loginPrefsEditor.clear();
                        loginPrefsEditor.commit();
                    }
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
                            passwordpat.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);

                            passwordpat.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordvisable=false;
                        }
                        else {

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

        Call<Login> loginResponseCall = ApiClientapp.getservice().loginuser(loginRequest);

        loginResponseCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                  if (response.isSuccessful()) {

                    Login  login = response.body();
     String token=response.body().getAccess_token();
     int Patient_id=response.body().getUser().getId();
        SharedPreferences preferences = getSharedPreferences("Token", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("token",token);
        editor.putInt("Patient_id", Patient_id);
        editor.commit();


        Intent ii = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(ii);

            }
                  else {

                      String message="email or password is not true";
                      Toast.makeText(LoginActivity.this,message,Toast.LENGTH_LONG).show();;

                  }
        }

                                      @Override
                                      public void onFailure(Call<Login> call, Throwable t) {
                                          String message = t.getLocalizedMessage();
                                          Toast.makeText(LoginActivity.this,message,Toast.LENGTH_LONG).show();;


                                      }});



    }


}