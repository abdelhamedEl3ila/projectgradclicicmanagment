package com.example.clinicmangmentsystem.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.clinicmangmentsystem.R;

public class SignuppatientActivity extends AppCompatActivity {
    CheckBox checkBoxA, checkBoxB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppatient);
        checkBoxA = (CheckBox) findViewById(R.id.checkBoxA);
        checkBoxB = (CheckBox) findViewById(R.id.checkBoxB);
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
}