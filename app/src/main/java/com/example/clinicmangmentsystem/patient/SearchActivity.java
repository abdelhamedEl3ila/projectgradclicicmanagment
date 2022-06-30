package com.example.clinicmangmentsystem.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.SearchView;

import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.adapter.SearchAdapter;
import com.example.clinicmangmentsystem.model.Search;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SearchAdapter searchAdapter;
    private ArrayList<Search> searches;
    SearchView searchView ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerView=findViewById(R.id.recsearch);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searches=new ArrayList<>();
        searchAdapter =new SearchAdapter(this,searches);
        recyclerView.setAdapter(searchAdapter);
        searches.add(new Search("Dentistry",R.drawable.ic_dentisticon));
        searches.add(new Search("Dentistry ",R.drawable.ic_dentisticon));
        searches.add(new Search("Dentistry",R.drawable.ic_dentisticon));
        searches.add(new Search("paediatricsicon",R.drawable.ic_paediatricsicon));
        searches.add(new Search("paediatricsicon",R.drawable.ic_paediatricsicon));
        searches.add(new Search("paediatricsicon",R.drawable.ic_paediatricsicon));
        searches.add(new Search("paediatricsicon",R.drawable.ic_paediatricsicon));








    }
}