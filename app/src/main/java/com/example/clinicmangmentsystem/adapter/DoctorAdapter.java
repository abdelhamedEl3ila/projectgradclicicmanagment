package com.example.clinicmangmentsystem.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Callback;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder>
{
     Context context;
     List<Datum> data;
     List<Datum> moviesListAll;
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
//         String imageUrl = a.getPhoto();
//         String url = a.getPhoto();
//         final Datum doctorModel = data.get(position);
//        Picasso.with(context).load(imageUrl).into(holder.imagedoc);
        holder.docname.setText(data.get(position).getName());
        holder.specalityname.setText(data.get(position).getSpeciality());
        holder.timewait.setText( data.get(position).getWaitTime());
        holder.price.setText( data.get(position).getExaminationPrice());
        holder.location.setText(data.get(position).getGovernorate());
        holder.Bookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DoctorprofileActivity.class);
                i.putExtra("id",a.getId());
                view.getContext().startActivity(i);
            }
        });
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

public void filterlist(List<Datum> filterlist){
data=filterlist;
notifyDataSetChanged();

}


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView docname,specalityname,location,price,timewait;
        ImageView imagedoc,imagespeclaity;
        ConstraintLayout Doctorview;
        Button Bookbtn;
        RatingBar ratingBarsearch;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            docname = itemView.findViewById(R.id.Doctorname);
//            imagedoc=itemView.findViewById(R.id.imagedoc);
            specalityname = itemView.findViewById(R.id.specialtiesname);
            location = itemView.findViewById(R.id.locationtxt);
            price = itemView.findViewById(R.id.pricetxt);
            timewait = itemView.findViewById(R.id.waitingtimetxt);
            imagespeclaity = itemView.findViewById(R.id.specialtyicon);
            Doctorview=itemView.findViewById(R.id.cardviewdoctor);
            Bookbtn=itemView.findViewById(R.id.reservationbtn);
            ratingBarsearch=itemView.findViewById(R.id.ratingBarsearch);
            ratingBarsearch.setRating(5);



        }

    }


}
