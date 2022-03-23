package com.example.clinicmangmentsystem.doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.patient.SignuppatientActivity;

public class LoginActivity extends AppCompatActivity {
EditText password;
boolean passwordvisable;
TextView createaccdoctxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        password=findViewById(R.id.editTextTextPassword);
        createaccdoctxt=findViewById(R.id.createaccdoc);
        createaccdoctxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });
        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                 final int Right =2;
                 if(event.getAction()==MotionEvent.ACTION_UP){
                     if (event.getRawX()>=password.getRight()-password.getCompoundDrawables()[Right].getBounds().width()){
                     int selection=password.getSelectionEnd();
                     if (passwordvisable){
                         //set drwableimage
                         password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                         //hide password
                         password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                         passwordvisable=false;
                     }
                     else {
                         //set drwableimage
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
}