package com.example.clinicmangmentsystem.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.clinicmangmentsystem.ApiClientapp;
import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.RejesterRequest;
import com.example.clinicmangmentsystem.model.Editresponse;
import com.example.clinicmangmentsystem.model.UpdeteUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilePatientActivity extends AppCompatActivity {
   private EditText username;
    private  EditText email;
    private EditText phonenumber;
    private EditText password;
    private Button editprofile,saveedit;
    private String usernameupdated;
    private String passwordupdated;
    private String mobilenumberupdated;
    private  String token ;
    private  String getpassword ;
    private ImageButton back ;
    private long userid ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_patient);
        email=(EditText)findViewById(R.id.emailedit);
        phonenumber=(EditText)findViewById(R.id.mobileedit);
        username=(EditText)findViewById(R.id.fulluser);
        password=(EditText)findViewById(R.id.passwordedit);
        usernameupdated=username.getText().toString();
        passwordupdated=password.getText().toString();
        mobilenumberupdated=phonenumber.getText().toString();
        editprofile=findViewById(R.id.editprofile);
        saveedit=findViewById(R.id.saveediyprofile);
        back=findViewById(R.id.backbtnprofile);







        SharedPreferences preferences=getSharedPreferences("Token", MODE_PRIVATE);
        token=preferences.getString("token",null);
        SharedPreferences pref=getSharedPreferences("loginPrefs", MODE_PRIVATE);
        getpassword=pref.getString("password",null);
        back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.profilepatient,new ProfilepatFragment()).commit();
    }
});
        saveedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UpdeteUser updateuser = new UpdeteUser();
                updateuser.setName(username.getText().toString());
                updateuser.setPassword(password.getText().toString());
                updateuser.setMobile_number(phonenumber.getText().toString());
                updateuser.setPhoto("null");
               updatedata(updateuser);
            }
        });
        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        username.setEnabled(true);
        phonenumber.setEnabled(true);
        password.setEnabled(true);
            }
        });

        Call<Editresponse> call= ApiClientapp.getservice().getuserprofile("Bearer "+token);
        call.enqueue(new Callback<Editresponse>() {
            @Override
            public void onResponse(Call<Editresponse> call, Response<Editresponse> response) {

                if (response.isSuccessful() && response.body().getUser() != null) {
                    userid= response.body().getUser().getId();
                    username.setText(response.body().getUser().getName());
                    phonenumber.setText(response.body().getUser().getMobile_number());
                    email.setText(response.body().getUser().getEmail());
                    password.setText(getpassword);
                    SharedPreferences preferences = getSharedPreferences("User",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username",response.body().getUser().getName());
                    editor.putString("phonenumber", response.body().getUser().getMobile_number());
                    editor.commit();


                }
            }

            @Override
            public void onFailure(Call<Editresponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(ProfilePatientActivity.this,message,Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void updatedata( UpdeteUser updeteUser) {
        Call<Editresponse>call= ApiClientapp.getservice().postupdate("Bearer "+token,userid,updeteUser);
        call.enqueue(new Callback<Editresponse>() {
            @Override
            public void onResponse(Call<Editresponse> call, Response<Editresponse> response) {
                if (response.isSuccessful())
                {
                    String message="Updated";
                    Toast.makeText(ProfilePatientActivity.this,message,Toast.LENGTH_LONG).show();

                }
                else {

                    String message ="error";
                    Toast.makeText(ProfilePatientActivity.this,message,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Editresponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(ProfilePatientActivity.this,message,Toast.LENGTH_SHORT).show();

            }
        });



    }
    private void getuser()
    {


    }

}