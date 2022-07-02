package com.example.clinicmangmentsystem.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicmangmentsystem.DetalisSearchActivity;
import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.doctor.DetailsActivity;
import com.example.clinicmangmentsystem.model.Articles;
import com.example.clinicmangmentsystem.model.Specilaty;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SpecialtyAdapter extends RecyclerView.Adapter<SpecialtyAdapter.ViewHolder> {
    Context context;
    List<Specilaty>specilatyList;
    public SpecialtyAdapter(Context context, List<Specilaty> specilatyList) {
        this.context = context;
        this.specilatyList = specilatyList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.specialty_layout,null,false);
        return new SpecialtyAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Specilaty a = specilatyList.get(position);
        holder.speciality.setText(a.getSpecialtyName());
        holder.imageView.setImageDrawable(context.getDrawable(a.getImageView()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DetalisSearchActivity.class);
                i.putExtra("specialityname",a.getSpecialtyName());
                v.getContext().startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return specilatyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView speciality;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.digoness);
            speciality=itemView.findViewById(R.id.dignessname);



        }
    }
}
