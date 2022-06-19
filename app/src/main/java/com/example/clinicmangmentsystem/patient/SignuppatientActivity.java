package com.example.clinicmangmentsystem.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
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

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignuppatientActivity extends AppCompatActivity {
    CheckBox checkBoxA, checkBoxB;
    EditText fristusername,lastusername,password,email,phonenumber;
    Button next;
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
        phonenumber=findViewById(R.id.phonenumuser);
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

                Toast.makeText(SignuppatientActivity.this, input, Toast.LENGTH_SHORT).show();
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
