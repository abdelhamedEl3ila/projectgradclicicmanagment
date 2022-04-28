package com.example.clinicmangmentsystem.doctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.patient.ActivitypatFragment;
import com.example.clinicmangmentsystem.patient.HomepatFragment;
import com.example.clinicmangmentsystem.patient.ProfilepatFragment;

public class DoctorActivity extends AppCompatActivity {
    MeowBottomNavigation bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        bottomNavigation=findViewById(R.id.bottomnavdoc);
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_baseline_feed_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.calender));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_baseline_person_24));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;
                switch (item.getId()){


                    case 1:
                        fragment=new NewsFragment();
                        break;
                    case 2:
                        fragment=new ScheduldocFragment();
                        break;
                    case 3:
                        fragment=new profiledocFragment();
                        break;

                }
                loadfragmentpat(fragment);


            }
        });

        //set notification count

        bottomNavigation.show(2,true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

            }
        });
        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

            }
        });


    }
    private void loadfragmentpat(Fragment fragment) {
        //replace
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framlayoutdoc,fragment)
                .commit();
    }

    }
