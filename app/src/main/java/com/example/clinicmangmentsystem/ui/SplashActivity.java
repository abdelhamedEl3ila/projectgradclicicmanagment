package com.example.clinicmangmentsystem.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.clinicmangmentsystem.R;

public class SplashActivity extends AppCompatActivity {
ImageView imageView;
LottieAnimationView lottieAnimationView;
 private  HandlerThread handler;
Runnable callback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView=findViewById(R.id.imageView);
        lottieAnimationView=findViewById(R.id.lottie);
        imageView.animate().translationX(-1000).setDuration(1000).setStartDelay(2000);
        lottieAnimationView.animate().translationX(-1500).setDuration(2000).setStartDelay(2000);
        final Intent go = new Intent(SplashActivity.this, SelectActivity.class);
        //make a thread to go to second activity...
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    SplashActivity.this.startActivity(go);
                    finish();
                }
            }
        };
        t.start();
    }



}
