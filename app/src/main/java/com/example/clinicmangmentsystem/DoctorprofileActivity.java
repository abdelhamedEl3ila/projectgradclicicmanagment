package com.example.clinicmangmentsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clinicmangmentsystem.adapter.ReviewAdapter;
import com.example.clinicmangmentsystem.adapter.TimeAdapter;
import com.example.clinicmangmentsystem.map.MapdocActivity;
import com.example.clinicmangmentsystem.model.DoctorProd;
import com.example.clinicmangmentsystem.model.DoctorProf;
import com.example.clinicmangmentsystem.model.Doctortime;
import com.example.clinicmangmentsystem.model.ReviewModel;
import com.example.clinicmangmentsystem.model.ShowAllReview;
import com.example.clinicmangmentsystem.patient.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorprofileActivity extends AppCompatActivity {
RecyclerView timerecyclerView;
TextView name ,price, specailty,timewait,location;
ImageView docprof ,mapdoc ,imagecall;
ImageView review,call , locationdoc;
ImageView clinic1,clinic2 ,clinic3 ,clinic4,clinic5,clinic6;
private String token ;
private List<Doctortime>doctortimes= new ArrayList<>();
private List<ReviewModel>reviewModels= new ArrayList<>();
private TimeAdapter timeAdapter ;
private ReviewAdapter reviewAdapter ;
private Context context;
private Dialog dialog;
private Dialog dialogcall;
private int doctorid;
ProgressDialog progressDialog;
private String Name;
private int id;
private  String postcom;
private  String Rating;
private  String latitude;
private  String phoennumber;
private  String longtude;
private RatingBar ratingBarprofile;
private  static int PERMISSION_CODE= 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorprofile);

        if (ContextCompat.checkSelfPermission(DoctorprofileActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(DoctorprofileActivity.this,new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CODE);

        }
        timerecyclerView=findViewById(R.id.recdoctortime);
        name=findViewById(R.id.namedocprofile);
        specailty=findViewById(R.id.specialtityname);
        docprof=findViewById(R.id.photodoc);
        timewait=findViewById(R.id.waittimetixt);
        price=findViewById(R.id.price);
        ratingBarprofile=findViewById(R.id.ratingBarprofile);
        clinic1=findViewById(R.id.recphotoclinic1);
        clinic2=findViewById(R.id.recphotoclinic2);
        clinic3=findViewById(R.id.recphotoclinic3);
        clinic4=findViewById(R.id.recphotoclinic4);
        clinic5=findViewById(R.id.recphotoclinic5);
        clinic6=findViewById(R.id.recphotoclinic6);
        review=findViewById(R.id.imagerevews);
        mapdoc=findViewById(R.id.imageView8);
        showcalldilog();
        mapdoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getmap();
            }
        });

        call=findViewById(R.id.imagecall);
        ratingBarprofile.setRating(5);
        location=findViewById(R.id.adress);
        SharedPreferences prefreance = getSharedPreferences("User", Context.MODE_PRIVATE);
        Name = prefreance.getString("username", "");
        timerecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        timeAdapter = new  TimeAdapter(this,doctortimes);
        timerecyclerView.setAdapter(timeAdapter);
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.review_layout);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true); //Optional
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog
        RecyclerView recyclerView1 = dialog.findViewById(R.id.recyclerreview);
        RatingBar Rate = dialog.findViewById(R.id.barrate);
        EditText post = dialog.findViewById(R.id.contenttxt);
        TextView name = dialog.findViewById(R.id.userreview);
        TextView postreview = dialog.findViewById(R.id.postreviewbtn);
        name.setText(Name);
        postcom=post.getText().toString();
        Rating= String.valueOf(Rate.getRating());
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        reviewAdapter = new ReviewAdapter(this,reviewModels);
        recyclerView1.setAdapter(reviewAdapter);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogcall.show();
            }
        });
        postreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReviewModel reviewModel = new ReviewModel();
                reviewModel.setContent(post.getText().toString());
                reviewModel.setRate(String.valueOf(Rate.getNumStars()));

                postreview(reviewModel);
            }
        });
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showreview();
                dialog.show();
            }
        });
        Intent intent = getIntent();
         id = intent.getIntExtra("id",0);
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
        getdoctorprofile();

    }

    private void getmap() {

        Intent i = new Intent(DoctorprofileActivity.this, MapdocActivity.class);
        startActivity(i);

    }

    private void postreview(ReviewModel reviewModel) {



        Call<ReviewModel>call= ApiClientapp.getservice().postreview("Bearer "+token,doctorid,reviewModel);

        call.enqueue(new Callback<ReviewModel>() {
            @Override
            public void onResponse(Call<ReviewModel> call, Response<ReviewModel> response) {
                if (response.isSuccessful())
                {
                    dialog.dismiss();
                }
                else {
                    String message ="error";
                    Toast.makeText(DoctorprofileActivity.this,message,Toast.LENGTH_LONG).show();;


                }

            }

            @Override
            public void onFailure(Call<ReviewModel> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(DoctorprofileActivity.this,message,Toast.LENGTH_LONG).show();;

            }
        });
    }

    private void getdoctorprofile() {




        Call<DoctorProf> call= ApiClientapp.getservice().getprofiledoc("Bearer "+token,id);

        call.enqueue(new Callback<DoctorProf>() {
            @Override
            public void onResponse(Call<DoctorProf> call, Response<DoctorProf> response) {
                if (response.isSuccessful() && response.body().getDoctor() != null) {


                    final DoctorProd a = response.body().getDoctor();
//                    String imageUrl = a.getPhoto();
//                    String clinicimage1 = a.getChinicPhoto1();
//                    String clinicimage12 = a.getChinicPhoto2();
//                    String clinicimage13 = a.getChinicPhoto3();
//                    String clinicimage14 = a.getChinicBill1();
//                    String clinicimage15 = a.getChinicBill2();
//                    String clinicimage16 = a.getChinicPhoto3();
//                    Picasso.with(context).load(imageUrl).into(docprof);
//                    Picasso.with(context).load(clinicimage1).into(clinic1);
//                    Picasso.with(context).load(clinicimage12).into(clinic2);
//                    Picasso.with(context).load(clinicimage13).into(clinic3);
//                    Picasso.with(context).load(clinicimage14).into(clinic4);
//                    Picasso.with(context).load(clinicimage15).into(clinic5);
//                    Picasso.with(context).load(clinicimage16).into(clinic6);
                    name.setText(response.body().getDoctor().getName());
                    specailty.setText(response.body().getDoctor().getSpeciality());
                    timewait.setText(response.body().getDoctor().getWaitTime());
                    price.setText(response.body().getDoctor().getExaminationPrice());
                    location.setText(response.body().getDoctor().getGovernorate());
                    doctorid=response.body().getDoctor().getId();
                    latitude=response.body().getDoctor().getLatitude();
                    longtude=response.body().getDoctor().getLongitude();
                    phoennumber=response.body().getDoctor().getMobileNumber();
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
                    editor.putString("latitude", response.body().getDoctor().getLatitude() );
                    editor.putString("longtude", response.body().getDoctor().getLongitude());
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

    private void showreview() {
        Call<ShowAllReview>call = ApiClientapp.getservice().getallreview("Bearer "+token,doctorid);
        call.enqueue(new Callback<ShowAllReview>() {
            @Override
            public void onResponse(Call<ShowAllReview> call, Response<ShowAllReview> response) {
                if (response.isSuccessful()&& response.body() !=null)
                {
               reviewModels.clear();
                    reviewModels.addAll(response.body().getReviews());
                    reviewAdapter.notifyDataSetChanged();

                }
                else {

                    String message="error";
                    Toast.makeText(DoctorprofileActivity.this,message,Toast.LENGTH_LONG).show();;

                }
            }

            @Override
            public void onFailure(Call<ShowAllReview> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(DoctorprofileActivity.this,message,Toast.LENGTH_LONG).show();;


            }
        });

    }
    private void showcalldilog()
    {

        dialogcall = new Dialog(this);
        dialogcall.setContentView(R.layout.calldilog);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialogcall.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
        }
        dialogcall.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogcall.setCancelable(true); //Optional
        dialogcall.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog
        Button call = dialogcall.findViewById(R.id.btn_call);
        Button Cancel = dialogcall.findViewById(R.id.btn_cancel);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneno = phoennumber;
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+phoneno));
                startActivity(i);
            }
        });
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogcall.dismiss();
            }
        });



    }
}