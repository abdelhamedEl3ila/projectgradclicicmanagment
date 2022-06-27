package com.example.clinicmangmentsystem.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicmangmentsystem.DetalisSearchActivity;
import com.example.clinicmangmentsystem.DoctorprofileActivity;
import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.doctor.DetailsActivity;
import com.example.clinicmangmentsystem.model.Datum;
import com.example.clinicmangmentsystem.model.DoctorModel;
import com.example.clinicmangmentsystem.model.Search;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Callback;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder>
{
    Context context;
     List<Datum> data;

    public DoctorAdapter(Context context, List<Datum> data) {
        this.context = context;
        this.data = data;
    }



    @NonNull
    @Override
    public DoctorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.searchitem,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorAdapter.ViewHolder holder, int position) {


         final Datum a = data.get(position);
         String imageUrl = a.getPhoto();
         String url = a.getPhoto();
         final Datum doctorModel = data.get(position);
        Picasso.with(context).load(imageUrl).into(holder.imagedoc);
        holder.docname.setText(data.get(position).getName());
        holder.specalityname.setText(data.get(position).getSpeciality());
        holder.timewait.setText( data.get(position).getWaitTime());
        holder.price.setText( data.get(position).getExaminationPrice());
        holder.location.setText(data.get(position).getGovernorate());
        holder.timeclinic.setText( data.get(position).getWaitTime());
        holder.Doctorview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DoctorprofileActivity.class);
                i.putExtra("id",a.getId());

                view.getContext().startActivity(i);
            }
        });


    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView docname,specalityname,location,price,timewait,timeclinic;
        ImageView imagedoc,imagespeclaity;
        ConstraintLayout Doctorview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            docname = itemView.findViewById(R.id.Doctorname);
            imagedoc=itemView.findViewById(R.id.imagedoc);
            specalityname = itemView.findViewById(R.id.specialtiesname);
            location = itemView.findViewById(R.id.locationtxt);
            price = itemView.findViewById(R.id.pricetxt);
            timewait = itemView.findViewById(R.id.waitingtimetxt);
            timeclinic = itemView.findViewById(R.id.timeclinic);
            imagespeclaity = itemView.findViewById(R.id.specialtyicon);
            Doctorview=itemView.findViewById(R.id.cardviewdoctor);


        }

    }


}
