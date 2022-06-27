package com.example.clinicmangmentsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.car.ui.IFocusArea;
import com.example.clinicmangmentsystem.model.Getmedical;
import com.example.clinicmangmentsystem.model.MedicalResponse;

import com.example.clinicmangmentsystem.model.PostMedical;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MedicalActivity extends AppCompatActivity  {
EditText spinner1,spinner2;
String bloodtype , realtion ;
EditText height ,weight, digness;
Button save;
    String token;
    private ArrayList<Getmedical> getmedicals = new ArrayList<>();
    private int Patient_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        SharedPreferences preferences=getSharedPreferences("Token", getApplicationContext().MODE_PRIVATE);
        token=preferences.getString("token",null);
Patient_id=preferences.getInt("Patient_id",0);
save= findViewById(R.id.savedata);
height= findViewById(R.id.editTextheight);
weight= findViewById(R.id.editTextweight);
digness= findViewById(R.id.digness);

//        String []value ={"A","b","O","AB"};
//        ArrayList<String>arrayList=new ArrayList<>(Arrays.asList(value));
//        ArrayAdapter<String>Arrayadapter= new ArrayAdapter<>(this,R.layout.spinner,arrayList);
//        spinner1.setAdapter(Arrayadapter);
//        String []value1 ={"Single","Married"};
//        ArrayList<String>arrayList1=new ArrayList<>(Arrays.asList(value1));
//        ArrayAdapter<String>Arrayadapte1= new ArrayAdapter<>(this,R.layout.spinner,arrayList1);
//        spinner2.setAdapter(Arrayadapte1);
//        bloodtype= spinner1.getSelectedItem().toString();
//        realtion= spinner2.getSelectedItem().toString();

save.setOnClickListener(new View.OnClickListener() {
    @Override
   public void onClick(View view) {
        PostMedical postMedical = new PostMedical();
        postMedical.setHeight(height.getText().toString());
        postMedical.setWeight(weight.getText().toString());
        postMedical.setDiseases(digness.getText().toString());
        postMedical.setBloodType(spinner1.getText().toString());
        postMedical.setRelationshipState(spinner2.getText().toString());
        postMedical.setPatient_id(Patient_id);
        savedata(postMedical);

        getdatamedical();

   }
});


    }



    private void savedata(PostMedical postMedical) {
        Call<MedicalResponse>call= ApiClientapp.getservice().storeallmedical("Bearer "+token,postMedical);
        call.enqueue(new Callback<MedicalResponse>() {
            @Override
            public void onResponse(Call<MedicalResponse> call, Response<MedicalResponse> response) {
                if (response.isSuccessful()){
                    MedicalResponse medicalResponse  =response.body();
                    height.setText(response.body().getHeight());
                    weight.setText(response.body().getWeight());
                    digness.setText(response.body().getDiseases());
                    spinner1.setText(response.body().getBloodType());
                    spinner2.setText(response.body().getRelationshipState());

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

        Call<Getmedical> call= ApiClientapp.getservice().getallmedical("Bearer "+token,Patient_id);
        call.enqueue(new Callback<Getmedical>() {
            @Override
            public void onResponse(Call<Getmedical> call, Response<Getmedical> response) {
                if (response.isSuccessful())
                {
                    height.setText((int) response.body().getHeight());
                    weight.setText((int) response.body().getWeight());
                    spinner1.setText( response.body().getBloodType());
                    spinner2.setText( response.body().getRelationshipState());
                    digness.setText(response.body().getDiseases());
                }
                else {
                    String message="ERROR ";
                    Toast.makeText(MedicalActivity.this,message,Toast.LENGTH_LONG).show();;



                }
            }

            @Override
            public void onFailure(Call<Getmedical> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(MedicalActivity.this,message,Toast.LENGTH_LONG).show();;

            }
        });
    }

}