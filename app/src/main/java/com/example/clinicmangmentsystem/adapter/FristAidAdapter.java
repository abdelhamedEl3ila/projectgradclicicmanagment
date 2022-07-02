package com.example.clinicmangmentsystem.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
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
import com.example.clinicmangmentsystem.model.FristAid;
import com.example.clinicmangmentsystem.model.Search;

import java.util.List;

public class FristAidAdapter extends RecyclerView.Adapter<FristAidAdapter.ViewHolder> {
    private Dialog dialog;
    Context context;
    List<FristAid> list;

    public FristAidAdapter(Context context, List<FristAid> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public FristAidAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fristaidlayout,null, false);
        return new FristAidAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FristAidAdapter.ViewHolder holder, int position) {
        final FristAid fristAid = list.get(position);
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.fristaid_item);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(context.getDrawable(R.drawable.custom_dialog_background));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.setCancelable(true); //Optional
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog


        holder.textView.setText(fristAid.getFristaidtext());
        holder.fristaidicon.setImageDrawable(context.getDrawable(fristAid.getImageview()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public  class  ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        ImageView fristaidicon;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView=itemView.findViewById(R.id.fristaid);
            textView = itemView.findViewById(R.id.textfristaid);
            fristaidicon = itemView.findViewById(R.id.frisaidicon);

        }


    }
}
