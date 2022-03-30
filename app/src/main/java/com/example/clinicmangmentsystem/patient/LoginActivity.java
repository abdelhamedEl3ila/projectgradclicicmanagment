package com.example.clinicmangmentsystem.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.clinicmangmentsystem.MainActivity;
import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.SelectActivity;
import com.example.clinicmangmentsystem.doctor.SignupActivity;

public class LoginActivity extends AppCompatActivity {
TextView createacctxt;
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
        passwordpat=findViewById(R.id.editTextTextPasswordpatient);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(

                        android.R.color.transparent
                );
                Thread time = new Thread()
                {
                    @Override
                    public void run() {
                        try {
                            sleep(3500);
                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(i);
                            progressDialog.dismiss();
                            finish();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                };
                time.start();

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


}