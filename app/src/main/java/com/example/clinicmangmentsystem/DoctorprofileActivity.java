package com.example.clinicmangmentsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clinicmangmentsystem.adapter.DoctorAdapter;
import com.example.clinicmangmentsystem.adapter.TimeAdapter;
import com.example.clinicmangmentsystem.model.Datum;
import com.example.clinicmangmentsystem.model.DoctorProd;
import com.example.clinicmangmentsystem.model.DoctorProf;
import com.example.clinicmangmentsystem.model.Doctortime;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorprofileActivity extends AppCompatActivity {
RecyclerView timerecyclerView;
TextView name ,price, specailty,timewait,location;
ImageView docprof;
    String token ;
private List<Doctortime>doctortimes= new ArrayList<>();
    private TimeAdapter timeAdapter ;
private Context context;
     ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorprofile);
        timerecyclerView=findViewById(R.id.recdoctortime);
        name=findViewById(R.id.namedocprofile);
        specailty=findViewById(R.id.specialtityname);
        docprof=findViewById(R.id.photodoc);
        timewait=findViewById(R.id.waittimetixt);
        price=findViewById(R.id.price);
        location=findViewById(R.id.adress);
        timerecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        timeAdapter = new  TimeAdapter(this,doctortimes);
        timerecyclerView.setAdapter(timeAdapter);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",2);
        SharedPreferences prfs = getSharedPreferences("Token", Context.MODE_PRIVATE);
         token = prfs.getString("token", "");

        progressDialog = new ProgressDialog(DoctorprofileActivity.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Thread time = new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(2200);
                    progressDialog.dismiss();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        time.start();
        Call<DoctorProf> call= ApiClientapp.getservice().getprofiledoc("Bearer "+token,id);

        call.enqueue(new Callback<DoctorProf>() {
            @Override
            public void onResponse(Call<DoctorProf> call, Response<DoctorProf> response) {
                if (response.isSuccessful() && response.body().getDoctor() != null) {
                    final DoctorProd a = response.body().getDoctor();
                    String imageUrl = a.getPhoto();
                 Picasso.with(context).load(imageUrl).into(docprof);
                    name.setText(response.body().getDoctor().getName());
                    specailty.setText(response.body().getDoctor().getSpeciality());
                    timewait.setText(response.body().getDoctor().getWaitTime());
                    price.setText(response.body().getDoctor().getExaminationPrice());
                    location.setText(response.body().getDoctor().getGovernorate());
                    doctortimes.addAll(response.body().getDoctorTime());
                    SharedPreferences preferences = getSharedPreferences("Profile", getApplicationContext().MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Docname",response.body().getDoctor().getName() );
                    editor.putString("specailty",response.body().getDoctor().getSpeciality() );
                    editor.putString("price", response.body().getDoctor().getExaminationPrice() );
//                    editor.putString("photo", imageUrl );
                    editor.putString("waittime", response.body().getDoctor().getWaitTime() );
                    editor.putString("location", response.body().getDoctor().getGovernorate() );
                    editor.putInt("id", response.body().getDoctor().getId() );
                    editor.commit();
                            timeAdapter.notifyDataSetChanged();


                }
            }

            @Override
            public void onFailure(Call<DoctorProf> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
            }
        });




    }
}