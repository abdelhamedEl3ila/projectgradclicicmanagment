package com.example.clinicmangmentsystem.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.clinicmangmentsystem.R;

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

    public void click(View view) {

        String fristusernamevalue = fristusername.getText().toString();
        String lastusernamevalue = lastusername.getText().toString();
        String passwordvalue = password.getText().toString();
        String emailvalue = email.getText().toString();
        String phonenumbervalue = phonenumber.getText().toString();
        String male = checkBoxA.getText().toString();
        String female = checkBoxB.getText().toString();
        SharedPreferences.Editor editor =preferences.edit();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        if (fristusernamevalue.length()>2)
        {
            editor.putString("fristname",fristusernamevalue);
            editor.putString("lastname",lastusernamevalue);
            editor.putString("password",passwordvalue);
            editor.putString("eamil",emailvalue);
            editor.putString("male",male);
            editor.putString("female",female);
            editor.putString("phonenumber",phonenumbervalue);
            editor.commit();

        }
//        else {
//            Toast.makeText(SignuppatientActivity.this,"Please Enter FristName",Toast.LENGTH_LONG).show();
//
//        }
//        if (lastusernamevalue.length()>2)
//        {
//
//            editor.putString("lastname",lastusernamevalue);
//            editor.commit();
//
//
//
//        }
//        else {
//            Toast.makeText(SignuppatientActivity.this,"Please Enter LastName",Toast.LENGTH_LONG).show();
//
//        }
//        if (emailvalue.length()>1)
//        {
//
//            editor.putString("eamil",emailvalue);
//
//
//
//
//        }
//        else {
//            Toast.makeText(SignuppatientActivity.this,"Please Enter eamil",Toast.LENGTH_LONG).show();
//
//        }
//        if (passwordvalue.length()>1)
//        {
//
//            editor.putString("password",passwordvalue);
//            editor.commit();
//
//
//
//        }
//        else {
//            Toast.makeText(SignuppatientActivity.this,"Please Enter password",Toast.LENGTH_LONG).show();
//
//        }
//        if (male.length()>1)
//        {
//
//            editor.putString("male",male);
//            editor.commit();
//
//
//
//        }
//        else {
//            Toast.makeText(SignuppatientActivity.this,"Please Enter gender",Toast.LENGTH_LONG).show();
//
//        }
//        if (female.length()>1)
//        {
//
//            editor.putString("female",female);
//            editor.commit();
//
//
//
//        }
//        else {
//            Toast.makeText(SignuppatientActivity.this,"Please Enter gender",Toast.LENGTH_LONG).show();
//
//        }
//        if (phonenumbervalue.length()>11)
//        {
//
//            editor.putString("phonenumber",phonenumbervalue);
//            editor.commit();
//
//
//
//        }
//        else {
//            Toast.makeText(SignuppatientActivity.this,"Please Enter phonenumber",Toast.LENGTH_LONG).show();
//
//        }




    }
}