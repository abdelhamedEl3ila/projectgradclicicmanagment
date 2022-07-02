package com.example.clinicmangmentsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.car.ui.IFocusArea;
import com.example.clinicmangmentsystem.model.Datum;
import com.example.clinicmangmentsystem.model.Getmedical;
import com.example.clinicmangmentsystem.model.MedicalResponse;

import com.example.clinicmangmentsystem.model.ModelMedical;
import com.example.clinicmangmentsystem.model.PostMedical;
import com.example.clinicmangmentsystem.patient.HomepatFragment;
import com.example.clinicmangmentsystem.patient.ProfilepatFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MedicalActivity extends AppCompatActivity  {
Spinner spinner1,spinner2;
String bloodtype , realtion ;
String bloodtypee , realtionn ;
EditText height ,weight, digness;
private List<Getmedical> data = new ArrayList<>();
TextView save;
ImageButton backbutton;
 private String heightpref;
 private String weightpref;
 private String bloodtypepref;
 private String relationpref;
 private String dignesspref;
    private boolean selectionControl = true;
   private String token;
    private int Patient_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        backbutton = findViewById(R.id.backbutton);

//        SharedPreferences preferences = getSharedPreferences("Medical", getApplicationContext().MODE_PRIVATE);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putString("height",height.getText().toString());
//
//        editor.commit();
//        getdata();
       getdatamedical();
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.medical_history,new HomepatFragment()).commit();
            }
        });
        SharedPreferences preferences1=getSharedPreferences("Token", getApplicationContext().MODE_PRIVATE);
        token=preferences1.getString("token",null);
        Patient_id=preferences1.getInt("Patient_id",0);
save= findViewById(R.id.savedata);
height= findViewById(R.id.editTextheight);
weight= findViewById(R.id.editTextweight);
digness= findViewById(R.id.digness);
        ArrayAdapter<CharSequence> adapter1=  ArrayAdapter.createFromResource(this,R.array.Relation, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parant, View view, int i, long l) {
                 bloodtype = parant.getItemAtPosition(i).toString();

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

ArrayAdapter<CharSequence> adapter=  ArrayAdapter.createFromResource(this,R.array.blood_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parant, View view, int i, long l) {
                 realtion = parant.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

save.setOnClickListener(new View.OnClickListener() {
    @Override
   public void onClick(View view) {
        PostMedical postMedical = new PostMedical();
        postMedical.setHeight(height.getText().toString());
        postMedical.setWeight(weight.getText().toString());
        postMedical.setDiseases(digness.getText().toString());
        postMedical.setBloodType(spinner1.getSelectedItem().toString());
        postMedical.setRelationshipState(spinner2.getSelectedItem().toString());
        postMedical.setPatient_id(Patient_id);
//        heightpref= height.getText().toString();
//        weightpref= weight.getText().toString();
//        bloodtypepref= spinner1.getSelectedItem().toString();
//        relationpref= spinner2.getSelectedItem().toString();
//        dignesspref= digness.getText().toString();
        //        editor.putString("weight", weightpref);
//        editor.putString("bloodtype",bloodtypepref);
//        editor.putString("relationship", relationpref);
//        editor.putString("digness", dignesspref);


        savedata(postMedical);
//        getdatamedical();
   }
});


    }



    private void savedata(PostMedical postMedical) {
        Call<MedicalResponse>call= ApiClientapp.getservice().storeallmedical("Bearer "+token,postMedical);
        call.enqueue(new Callback<MedicalResponse>() {
            @Override
            public void onResponse(Call<MedicalResponse> call, Response<MedicalResponse> response) {
                if (response.isSuccessful()){

                    String message = "Succsess";
                    Toast.makeText(MedicalActivity.this, message, Toast.LENGTH_LONG).show();

                }
                else {
                    String message="ERROR ";
                    Toast.makeText(MedicalActivity.this,message,Toast.LENGTH_LONG).show();;

                }
            }

            @Override
            public void onFailure(Call<MedicalResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(MedicalActivity.this,message,Toast.LENGTH_LONG).show();;

            }
        });


    }
    private void getdatamedical() {
        SharedPreferences preferences1=getSharedPreferences("Token", MODE_PRIVATE);
      String  token=preferences1.getString("token",null);
        Call<ModelMedical>call=ApiClientapp.getservice().getallmedical("Bearer "+token);
        call.enqueue(new Callback<ModelMedical>() {

            @Override
            public void onResponse(Call<ModelMedical> call, Response<ModelMedical> response) {
                if (response.isSuccessful()) {
                    data.clear();
                    data.addAll(response.body().getData());
                    Log.d("TAG",token);
                    filterselect(1);

                    for (int i = 0; i < data.size(); i++) {

                                height.setText(data.get(i).getHeight());
                                weight.setText(data.get(i).getWeight());
                                bloodtypee = data.get(i).getBloodType();
                                realtionn = data.get(i).getRelationshipState();
                                for(int j= 0; j < spinner1.getAdapter().getCount(); j++)
                                {
                                    if(spinner1.getAdapter().getItem(j).toString().contains(bloodtypee))
                                    {
                                        spinner1.setSelection(j);
                                    }
                                }
                                for(int j= 0; j < spinner2.getAdapter().getCount(); j++)
                                {
                                    if(spinner2.getAdapter().getItem(j).toString().contains(realtionn))
                                    {
                                        spinner2.setSelection(j);
                                    }
                                }
                                digness.setText( data.get(i).getDiseases());

                            }



                } else {
                    String message = "ERROR ";
                    Toast.makeText(MedicalActivity.this, message, Toast.LENGTH_LONG).show();
                }
                }
        @Override
        public void onFailure(Call<ModelMedical> call, Throwable t) {
            String message = t.getLocalizedMessage();
            Toast.makeText(MedicalActivity.this, message, Toast.LENGTH_LONG).show();

        }
    });
        }





    private void filterselect(int id){
        List<Getmedical> filter=new ArrayList<>();
        for(Getmedical item1:data){
        if(item1.getPatientID()==id){
        filter.add(item1);

        }

        }
        }
        }

