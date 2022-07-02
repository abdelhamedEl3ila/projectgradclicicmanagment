package com.example.clinicmangmentsystem.adapter;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicmangmentsystem.ApiClientapp;
import com.example.clinicmangmentsystem.DoctorprofileActivity;
import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.SelectDoctorActivity;
import com.example.clinicmangmentsystem.model.Schdulepat;
import com.example.clinicmangmentsystem.model.SelectDoctor;
import com.example.clinicmangmentsystem.patient.LoginActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SchduleAdapter extends RecyclerView.Adapter<SchduleAdapter.ViewHolder> {
    Context context;
    List <Schdulepat>list;
    private Dialog dialog;
    int id;
    Dialog dialogcall ;
    private String phonenumber ;
    private  static int PERMISSION_CODE= 100;


    public SchduleAdapter(Context context, List<Schdulepat> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SchduleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schdulepat,null,true);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull SchduleAdapter.ViewHolder holder, int position) {


        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CODE);

        }


        dialogcall = new Dialog(context);
        dialogcall.setContentView(R.layout.calldilog);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialogcall.getWindow().setBackgroundDrawable(context.getDrawable(R.drawable.custom_dialog_background));
        }
        dialogcall.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogcall.setCancelable(true); //Optional
        dialogcall.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog
        Button call = dialogcall.findViewById(R.id.btn_call);
        Button Cancelcall = dialogcall.findViewById(R.id.btn_cancel);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneno = phonenumber;
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+phoneno));
                context.startActivity(i);
            }
        });
        Cancelcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogcall.dismiss();
            }
        });




        SharedPreferences prfs = context.getSharedPreferences("Token", Context.MODE_PRIVATE);
        String token = prfs.getString("token", "");
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_dialog_layout);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(context.getDrawable(R.drawable.custom_dialog_background));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false); //Optional
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog
        Button Okay = dialog.findViewById(R.id.btn_okay);
        Button Cancel = dialog.findViewById(R.id.btn_cancel);
        final Schdulepat schdulepat = list.get(position);
         id = schdulepat.getId();
        holder.docname.setText(schdulepat.getName());
        holder.resrv.setText(schdulepat.getDay());
        phonenumber=schdulepat.getMobile_number().toString();


           Okay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Call<SelectDoctor>call=ApiClientapp.getservice().cancelbook("Bearer "+token,id);
                    call.enqueue(new Callback<SelectDoctor>() {
                        @Override
                        public void onResponse(Call<SelectDoctor> call, Response<SelectDoctor> response) {

                            if (response.isSuccessful()) {

                                dialog.dismiss();
                                ;

                            } else {
                                String message = "error ";
                                Toast.makeText(context, message, Toast.LENGTH_LONG).show();


                            }
                        }


                        @Override
                        public void onFailure(Call<SelectDoctor> call, Throwable t) {
                            String message = t.getLocalizedMessage();
                            Toast.makeText(context,message,Toast.LENGTH_LONG).show();;

                        }
                    });
                    dialog.dismiss();
                }
            });


            Cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();
                }
                    });

        holder.cancelbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

         dialog.show();



            }
        });
holder.callclinic.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        dialogcall.show();
    }
});


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private void showcalldilog()
    {


    }
    public  class  ViewHolder extends  RecyclerView.ViewHolder
    {
        TextView docname,docspeci,resrv;
        ImageView imageView;
        Button cancelbook ,callclinic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            SharedPreferences prfs = context.getSharedPreferences("Token", Context.MODE_PRIVATE);
            String token = prfs.getString("token", "");

            docspeci=itemView.findViewById(R.id.specialtiesname);
            docname=itemView.findViewById(R.id.Doctorname);
            imageView=itemView.findViewById(R.id.imagedoc);
            resrv=itemView.findViewById(R.id.timeclinic);
            cancelbook=itemView.findViewById(R.id.cancelclinic);
            callclinic=itemView.findViewById(R.id.callclinic2);

        }


    }

}
