package com.example.clinicmangmentsystem.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.adapter.FristAidAdapter;
import com.example.clinicmangmentsystem.adapter.SearchAdapter;
import com.example.clinicmangmentsystem.model.FristAid;
import com.example.clinicmangmentsystem.model.Search;

import java.util.ArrayList;
import java.util.List;

public class FristAidActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FristAidAdapter fristAidAdapter;
    private List<FristAid> fristAids = new ArrayList<>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist_aid);
        recyclerView=findViewById(R.id.recfristaid);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fristAidAdapter =new FristAidAdapter(this,fristAids);
        recyclerView.setAdapter(fristAidAdapter);
        fristAids.add(new FristAid("Artificial Respiration",R.mipmap.artifical_foreground));
        fristAids.add(new FristAid("CPR (cardiac massage)",R.mipmap.cpr_foreground));
        fristAids.add(new FristAid("Heart Attack",R.mipmap.heart_attack_foreground));
        fristAids.add(new FristAid("Artificial Respiration",R.mipmap.artifical_foreground));
        fristAids.add(new FristAid("CPR (cardiac massage)",R.mipmap.cpr_foreground));
        fristAids.add(new FristAid("Heart Attack",R.mipmap.heart_attack_foreground));
        fristAids.add(new FristAid("Artificial Respiration",R.mipmap.artifical_foreground));
        fristAids.add(new FristAid("CPR (cardiac massage)",R.mipmap.cpr_foreground));
        fristAids.add(new FristAid("Heart Attack",R.mipmap.heart_attack_foreground));
        fristAids.add(new FristAid("Artificial Respiration",R.mipmap.artifical_foreground));
        fristAids.add(new FristAid("CPR (cardiac massage)",R.mipmap.cpr_foreground));
        fristAids.add(new FristAid("Heart Attack",R.mipmap.heart_attack_foreground));
        fristAids.add(new FristAid("Artificial Respiration",R.mipmap.artifical_foreground));
        fristAids.add(new FristAid("CPR (cardiac massage)",R.mipmap.cpr_foreground));
        fristAids.add(new FristAid("Heart Attack",R.mipmap.heart_attack_foreground));
    }
}