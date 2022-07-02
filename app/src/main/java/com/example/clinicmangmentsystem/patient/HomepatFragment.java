package com.example.clinicmangmentsystem.patient;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.example.clinicmangmentsystem.DetalisSearchActivity;
import com.example.clinicmangmentsystem.MedicalActivity;
import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.adapter.SpecialtyAdapter;
import com.example.clinicmangmentsystem.map.MapsActivity;
import com.example.clinicmangmentsystem.model.Specilaty;

import java.util.ArrayList;
import java.util.List;


public class HomepatFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match

SearchView searchView ;
LinearLayout searchbar;
Button clinicvisitbtn;
Button Medical_HIstoryview;
Button calldoc;
Button fristaidbtn;
Button viewclinicnear;
ConstraintLayout viewmap;
   private RecyclerView recyclerView;
 private   SpecialtyAdapter specialtyAdapter;
    private List<Specilaty> specilaties = new ArrayList<>();

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
        Medical_HIstoryview= v.findViewById(R.id.viewMedicalHistory);
        clinicvisitbtn= v.findViewById(R.id.btnclinicvisit);
        calldoc= v.findViewById(R.id.btncaldoc);
        viewclinicnear= v.findViewById(R.id.viewclinicnear);
        searchView= v.findViewById(R.id.searchspecilaty);
        fristaidbtn= v.findViewById(R.id.fristaidbtn);

        recyclerView=v.findViewById(R.id.recyclerviewspecialtity);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext(),LinearLayoutManager.HORIZONTAL,true));
        specialtyAdapter =new SpecialtyAdapter(v.getContext(),specilaties);
        recyclerView.setAdapter(specialtyAdapter);
searchView.setEnabled(false);
//        specilaties.add(new Specilaty(R.drawable.ic_stethoscope_doctor_svgrepo_com,"Other"));
        specilaties.add(new Specilaty(R.drawable.ic_dentist_svgrepo_com__1_,"Dentistry"));
        specilaties.add(new Specilaty(R.drawable.ic_baby_svgrepo_com,"NewBorn"));
        specilaties.add(new Specilaty(R.drawable.ic_syringe_svgrepo_com,"Anesthesiologists"));
        specilaties.add(new Specilaty(R.drawable.ic_mother_svgrepo_com,"Gynecologists"));
        specilaties.add(new Specilaty(R.drawable.ic_emergency_kit_svgrepo_com,"Emergency physicians"));
        specilaties.add(new Specilaty(R.drawable.ic_family_svgrepo_com,"Family physicians"));
        specilaties.add(new Specilaty(R.drawable.ic_i_pediatrics_svgrepo_com,"Paediatrics"));
        specilaties.add(new Specilaty(R.drawable.ic_radiology_svgrepo_com,"Radiologists"));
        specilaties.add(new Specilaty(R.drawable.ic_neurology_svgrepo_com,"Neurologists"));
        specilaties.add(new Specilaty(R.drawable.ic_stethoscope_doctor_svgrepo_com,"Osteopathy"));



        fristaidbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(v.getContext(),FristAidActivity.class);
                v.getContext().startActivity(i);
            }
        });
searchView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i = new Intent(v.getContext(),SearchActivity.class);
        v.getContext().startActivity(i);
    }
});
        viewclinicnear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(v.getContext(), MapsActivity.class);
                v.getContext().startActivity(in);
            }
        });
        calldoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(in);
            }
        });
        Medical_HIstoryview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(v.getContext(), MedicalActivity.class);
                v.getContext().startActivity(in);
            }
        });
        clinicvisitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), DetalisSearchActivity.class);
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