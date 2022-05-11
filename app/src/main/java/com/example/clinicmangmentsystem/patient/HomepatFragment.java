package com.example.clinicmangmentsystem.patient;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.example.clinicmangmentsystem.R;


public class HomepatFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match

SearchView searchView ;
LinearLayout searchbar;
Button clinicvisitbtn;

    public HomepatFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_homepat, container, false);
        searchView=v.findViewById(R.id.searchView);
        searchbar=v.findViewById(R.id.searchbar);
        clinicvisitbtn= v.findViewById(R.id.btnclinicvisit);
        clinicvisitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), SearchActivity.class);
                v.getContext().startActivity(in);
            }
        });



        searchbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),SearchActivity.class);
                v.getContext().startActivity(i);
            }
        });

       return v;

    }

}