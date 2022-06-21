package com.example.clinicmangmentsystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.model.DoctorModel;
import com.example.clinicmangmentsystem.model.Schdulepat;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder>
{
    Context context;
    List<DoctorModel> modelList;



    public DoctorAdapter(Context context, List<DoctorModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }


    @NonNull
    @Override
    public DoctorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.searchitem,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorAdapter.ViewHolder holder, int position) {
        final DoctorModel doctorModel = modelList.get(position);
        holder.docname.setText(modelList.get(position).getName());
        holder.specalityname.setText(modelList.get(position).getEmail());
        holder.location.setText(modelList.get(position).getAdress());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView docname,specalityname,location,price,timewait,timeclinic;
        ImageView imagedoc,imagespeclaity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            docname = itemView.findViewById(R.id.Doctorname);
            specalityname = itemView.findViewById(R.id.specialtiesname);
            location = itemView.findViewById(R.id.locationtxt);
            price = itemView.findViewById(R.id.pricetxt);
            timewait = itemView.findViewById(R.id.waitingtimetxt);
            timeclinic = itemView.findViewById(R.id.timeclinic);
            imagedoc = itemView.findViewById(R.id.imagedoc);
            imagespeclaity = itemView.findViewById(R.id.specialtyicon);


        }

    }


}
