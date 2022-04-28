package com.example.clinicmangmentsystem.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.patient.ActivitypatFragment;
import com.example.clinicmangmentsystem.patient.HomepatFragment;
import com.example.clinicmangmentsystem.patient.ProfilepatFragment;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation=findViewById(R.id.bottomnavpat);
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.calender));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_baseline_person_24));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment  fragment = null;
                switch (item.getId()){


                    case 1:
                        fragment=new HomepatFragment();
                        break;
                    case 2:
                        fragment=new ActivitypatFragment();
                        break;
                    case 3:
                        fragment=new ProfilepatFragment();
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
                .replace(R.id.framlayoutpat,fragment)
                .commit();
    }


}