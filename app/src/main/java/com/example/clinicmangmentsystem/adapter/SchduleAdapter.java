package com.example.clinicmangmentsystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.model.Schdulepat;

import java.util.List;

public class SchduleAdapter extends RecyclerView.Adapter<SchduleAdapter.ViewHolder> {
    Context context;
    List <Schdulepat>list;

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
        final Schdulepat schdulepat = list.get(position);
        holder.docname.setText(schdulepat.getNameDoctor());
        holder.docspeci.setText(schdulepat.getSpecialties());
        holder.resrv.setText(schdulepat.getReservation());
        holder.imageView.setImageDrawable(context.getDrawable(schdulepat.getImageView()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public  class  ViewHolder extends  RecyclerView.ViewHolder
    {
        TextView docname,docspeci,resrv;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            docspeci=itemView.findViewById(R.id.specialtiestxt);
            docname=itemView.findViewById(R.id.namedoctxxt);
            imageView=itemView.findViewById(R.id.imagedoc);
            resrv=itemView.findViewById(R.id.txttimeclinic);



        }


    }

}
