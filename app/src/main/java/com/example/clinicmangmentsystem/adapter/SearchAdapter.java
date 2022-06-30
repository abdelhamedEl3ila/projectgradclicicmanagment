package com.example.clinicmangmentsystem.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicmangmentsystem.DetalisSearchActivity;
import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.model.Search;
import com.example.clinicmangmentsystem.model.Specilaty;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    Context context;
    List<Search> list;

    public SearchAdapter(Context context, List<Search> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        final Search search = list.get(position);

        holder.speclitesname.setText(search.getNamespecialty());
        holder.speaclityicon.setImageDrawable(context.getDrawable(search.getImagespecialty()));
        holder.searchcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DetalisSearchActivity.class);
                i.putExtra("dignossname",search.getNamespecialty());
                v.getContext().startActivity(i);


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public  class  ViewHolder extends RecyclerView.ViewHolder
    {
        TextView speclitesname;
        ImageView speaclityicon;
        CardView searchcard;
        public ViewHolder(@NonNull View itemView) {
        super(itemView);

        searchcard=itemView.findViewById(R.id.searchcardview);
        speclitesname = itemView.findViewById(R.id.specialtytxt);
        speaclityicon = itemView.findViewById(R.id.specialtyicon);

    }


    }

}
