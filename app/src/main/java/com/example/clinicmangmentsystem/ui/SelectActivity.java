package com.example.clinicmangmentsystem.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.patient.LoginActivity;

public class SelectActivity extends AppCompatActivity {
Button selectdoc ,selectpat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        selectdoc=findViewById(R.id.selectdoctor);
        selectpat=findViewById(R.id.patient);

        selectpat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
        selectdoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectActivity.this, com.example.clinicmangmentsystem.doctor.LoginActivity.class);
                startActivity(i);
            }
        });

    }
}