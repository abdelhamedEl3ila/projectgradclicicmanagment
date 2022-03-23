package com.example.clinicmangmentsystem.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.clinicmangmentsystem.MainActivity;
import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.SelectActivity;

public class LoginActivity extends AppCompatActivity {
TextView createacctxt;
Button login ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        createacctxt = findViewById(R.id.createaccpat);
        login=findViewById(R.id.loginaspatientbtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        createacctxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignuppatientActivity.class);
                startActivity(i);
            }
        });

    }
}