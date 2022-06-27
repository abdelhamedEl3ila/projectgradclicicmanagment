package com.example.clinicmangmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clinicmangmentsystem.model.SelectDoctor;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectDoctorActivity extends AppCompatActivity {
EditText usernaem;
EditText phonenumberuser;
TextView name ,speciality ,feetxt ,loaction ;
TextView starttime,endtime,dayweek;
String token;
Button confirmselect;
ImageView docimage;
Context context;
     private  String day;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_doctor);
        name=findViewById(R.id.namedoc);
        speciality=findViewById(R.id.specialtyname);
        usernaem=findViewById(R.id.editTextusernaem);
        phonenumberuser=findViewById(R.id.editTextusermobile);
        feetxt=findViewById(R.id.feetxt);
        loaction=findViewById(R.id.Locationcover);
        dayweek=findViewById(R.id.dayselecttxt);
        starttime=findViewById(R.id.starttimetxt);
        endtime=findViewById(R.id.endtimetxt);
        docimage=findViewById(R.id.photodoc);
        confirmselect=findViewById(R.id.selectdoctorbtn);



        SharedPreferences prfs = getSharedPreferences("Token", Context.MODE_PRIVATE);
        token = prfs.getString("token", "");
        SharedPreferences sharedPreferences = getSharedPreferences("Profile", Context.MODE_PRIVATE);
        SharedPreferences preferences = getSharedPreferences("User", Context.MODE_PRIVATE);
        String username = preferences.getString("username", "");
        String phonenumber = preferences.getString("phonenumber", "");
       String Docname = sharedPreferences.getString("Docname", "");
        String  specailty = sharedPreferences.getString("specailty", "");
        String  price = sharedPreferences.getString("price", "");
        String photo = sharedPreferences.getString("photo", "");
        String location = sharedPreferences.getString("location", "");
        int id = sharedPreferences.getInt("id", 0);
        Intent intent = getIntent();
        String Satrttime = intent.getStringExtra("Satrttime");
        String Endtime = intent.getStringExtra("Endtime");
         day = intent.getStringExtra("day");

   Picasso.with(context).load(photo).into(docimage);
        name.setText(Docname);
        speciality.setText(specailty);
        usernaem.setText(username);
        phonenumberuser.setText(phonenumber);
        feetxt.setText(price);
        dayweek.setText(day);
        starttime.setText(Satrttime);
        endtime.setText(Endtime);
        loaction.setText(location);
        confirmselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<SelectDoctor> call= ApiClientapp.getservice().selectdoc("Bearer "+token,id,day);
                call.enqueue(new Callback<SelectDoctor>() {
                    @Override
                    public void onResponse(Call<SelectDoctor> call, Response<SelectDoctor> response) {
                        if (response.isSuccessful()){

                            String message="Confirm";
                            Toast.makeText(SelectDoctorActivity.this,message,Toast.LENGTH_LONG).show();;
                            Intent i = new Intent(context, AllschduleFragment.class);
                            startActivity(i);
                        }
                        else {
                            String message="error ";
                            Toast.makeText(SelectDoctorActivity.this,message,Toast.LENGTH_LONG).show();;

                        }
                    }

                    @Override
                    public void onFailure(Call<SelectDoctor> call, Throwable t) {
                        String message = t.getLocalizedMessage();
                        Toast.makeText(SelectDoctorActivity.this,message,Toast.LENGTH_LONG).show();;

                    }
                });
//                selectdoctor();

            }

            private void selectdoctor() {



            }
        });

    }
}