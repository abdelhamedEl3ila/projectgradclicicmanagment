package com.example.clinicmangmentsystem.doctor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clinicmangmentsystem.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignupActivity extends AppCompatActivity {
    private CircleImageView ProfileImage;
    FloatingActionButton fab;
    private static final int PICK_TMAGE = 1;
    Uri imageUri;
    AutoCompleteTextView autoCompleteTextView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ProfileImage = findViewById(R.id.selectdocphoto);
        final String[]  Spacility = new String[] {
                "Belgium", "France", "Italy", "Germany", "Spain"
        };


    }



}
