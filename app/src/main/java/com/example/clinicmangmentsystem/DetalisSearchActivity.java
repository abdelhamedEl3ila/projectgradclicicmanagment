package com.example.clinicmangmentsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.clinicmangmentsystem.adapter.DoctorAdapter;
import com.example.clinicmangmentsystem.adapter.NewsAdapter;
import com.example.clinicmangmentsystem.adapter.SearchAdapter;
import com.example.clinicmangmentsystem.model.Datum;
import com.example.clinicmangmentsystem.model.DoctorModel;
import com.example.clinicmangmentsystem.model.Login;
import com.example.clinicmangmentsystem.model.Search;
import com.example.clinicmangmentsystem.patient.LoginActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalisSearchActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Datum> data = new ArrayList<>();
    private DoctorAdapter doctorAdapter;
    private String token;
    private String dignossname = null;
    ProgressDialog progressDialog;
    private String currentSearchText = "";
    SearchView svSearch;
    private String specialityname = null;
    private String governorate= null;
    private List<Datum>selectedFilters= new ArrayList <>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalis_search);
        recyclerView = findViewById(R.id.Docdetailsrec);
        SharedPreferences preferences =getSharedPreferences("governorate", MODE_PRIVATE);
        governorate= preferences.getString("cairo",null);
        Intent i = getIntent();
        specialityname = i.getStringExtra("specialityname");
        dignossname = i.getStringExtra("dignossname");
        svSearch = findViewById(R.id.searchdoc);
        svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }


        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        doctorAdapter = new DoctorAdapter(this, data);
        recyclerView.setAdapter(doctorAdapter);
        SharedPreferences prfs = getSharedPreferences("Token", Context.MODE_PRIVATE);
        token = prfs.getString("token", "");
        progressdialog();
        getalldoctor();


    }

    void progressdialog() {
        progressDialog = new ProgressDialog(DetalisSearchActivity.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Thread time = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    progressDialog.dismiss();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        time.start();
    }

    void getalldoctor() {
        Call<DoctorModel> call;
        call = ApiClientapp.getservice().getallDoctor("Bearer "+ token);

        call.enqueue(new Callback<DoctorModel>() {
            @Override
            public void onResponse(Call<DoctorModel> call, Response<DoctorModel> response) {
                if (response.isSuccessful() && response.body().getData() != null && dignossname == null&&specialityname == null) {
                    data.clear();
                    data.addAll(response.body().getData());
                    doctorAdapter.notifyDataSetChanged();
                }
                 else if  (response.isSuccessful() && response.body().getData() != null && dignossname != null) {
                      data.clear();
                      data.addAll(response.body().getData());
                      doctorAdapter.notifyDataSetChanged();
                      filerselectgovern(governorate,dignossname);

                  }
              else   if  (response.isSuccessful() && response.body().getData() != null && specialityname != null) {
                    data.clear();
                    data.addAll(response.body().getData());
                    doctorAdapter.notifyDataSetChanged();
                    filterselect(specialityname);
                }


            else {

                    String message = "error";
                    Toast.makeText(DetalisSearchActivity.this, message, Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<DoctorModel> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(DetalisSearchActivity.this, message, Toast.LENGTH_LONG).show();
                ;


            }
        });

    }

    private void filter(String newText) {
        List<Datum> filteredlist = new ArrayList<>();
        for (Datum item : data) {
            if (item.getName().toLowerCase().contains(newText.toLowerCase())) {

                filteredlist.add(item);
            } else if (item.getSpeciality().toLowerCase().contains(newText.toLowerCase())) {

                filteredlist.add(item);
            }
        }
        doctorAdapter.filterlist(filteredlist);
    }

    private void filterselect(String newText) {
        List<Datum> filter = new ArrayList<>();

        for (Datum item1 : data) {
            if (item1.getSpeciality().toLowerCase().contains(newText.toLowerCase())) {
                filter.add(item1);
            }
        }
        doctorAdapter.filterlist(filter);
    }

    private void filerselectgovern(String governrate , String spicility) {
        List<Datum> filermultilist =new ArrayList<>();

        for (Datum item : data) {
            if (item.getGovernorate().toLowerCase().contains(governrate.toLowerCase())&& item.getSpeciality().toLowerCase().contains(spicility.toLowerCase()))
            {
                filermultilist.add(item);
            }

        }
        doctorAdapter.filterlist(filermultilist);
    }

}

