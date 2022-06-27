package com.example.clinicmangmentsystem.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.clinicmangmentsystem.ApiClientapp;
import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.RejesterRequest;
import com.example.clinicmangmentsystem.RejesterResponse;

import org.json.JSONObject;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignuppatientActivity extends AppCompatActivity {
    CheckBox checkBoxA, checkBoxB;
    EditText fristusername,lastusername,password,email,phonenumber;
    Button next;
    boolean passwordvisable;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                //    "(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
//                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppatient);
        checkBoxA = (CheckBox) findViewById(R.id.checkBoxA);
        checkBoxB = (CheckBox) findViewById(R.id.checkBoxB);
        fristusername=findViewById(R.id.fristusername);
        password=findViewById(R.id.pasworduser);
        email=findViewById(R.id.emailpat);
        phonenumber=findViewById(R.id.phonenumber);
        next=findViewById(R.id.nextpatientbtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validateEmail() | !validateUsername() | !validatePassword()) {
                    return;
                }

                String input = "Email: " + email.getText().toString();
                input += "\n";
                input += "Username: " + fristusername.getText().toString();
                input += "\n";
                input += "Password: " + password.getText().toString();

                RejesterRequest rejesterRequest = new RejesterRequest();
                rejesterRequest.setEmail(email.getText().toString());
                rejesterRequest.setPassword(password.getText().toString());
                rejesterRequest.setMobile_number(phonenumber.getText().toString());
                rejesterRequest.setName(fristusername.getText().toString());
                rejesterRequest.setGender(checkBoxA.getText().toString());
                rejesterRequest.setPhoto(checkBoxA.getText().toString());

                registerpatient(rejesterRequest);
                savedata(rejesterRequest);
            }});

        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right =2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if (event.getRawX()>=password.getRight()-password.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=password.getSelectionEnd();
                        if (passwordvisable){
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);

                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordvisable=false;
                        }
                        else {

                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            //show password
                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordvisable=true;
                        }
                        password.setSelection(selection);
                        return true;



                    }




                }
                return false;
            }
        });


    }
    private void savedata(RejesterRequest rejesterRequest)
    {
        Call<RejesterResponse>call=ApiClientapp.getservice().registeruser(rejesterRequest);
        call.enqueue(new Callback<RejesterResponse>() {
            @Override
            public void onResponse(Call<RejesterResponse> call, Response<RejesterResponse> response) {
                if (response.isSuccessful()){
                    RejesterResponse rejesterResponse = response.body();
                    Intent ii = new Intent(SignuppatientActivity.this, MainActivity.class);
                    startActivity(ii);

                }
                else {
                    String message="email or password is not true";
                    Toast.makeText(SignuppatientActivity.this,message,Toast.LENGTH_LONG).show();;

                }
            }

            @Override
            public void onFailure(Call<RejesterResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(SignuppatientActivity.this,message,Toast.LENGTH_LONG).show();;

            }
        });

    }
    private boolean validateEmail() {
        String emailInput = email.getText().toString().trim();

        if (emailInput.isEmpty()) {
            email.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            email.setError("Please enter a valid email address");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

    private boolean validateUsername() {
        String usernameInput = fristusername.getText().toString().trim();

        if (usernameInput.isEmpty()) {
            fristusername.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15) {
            fristusername.setError("Username too long");
            return false;
        } else {
            fristusername.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = password.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            password.setError("Password too weak");
            return false;
        } else {
            password.setError(null);
            return true;
        }
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
