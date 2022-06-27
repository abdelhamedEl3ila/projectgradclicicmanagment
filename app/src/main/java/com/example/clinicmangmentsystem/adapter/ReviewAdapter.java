package com.example.clinicmangmentsystem.adapter;

import android.content.Context;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.model.ReviewModel;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

 Context context;
 List<ReviewModel>reviewModels;

    public ReviewAdapter(Context context, List<ReviewModel> reviewModels) {
        this.context = context;
        this.reviewModels = reviewModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reviewitem,null,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nameuserreveiewer.setText(reviewModels.get(position).getName());
        holder.commenttxt.setText(reviewModels.get(position).getContent());
        holder.rate.setRating(Float.parseFloat(reviewModels.get(position).getRate()));

    }

    @Override
    public int getItemCount() {
        return reviewModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameuserreveiewer ,commenttxt;
        RatingBar rate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameuserreveiewer = itemView.findViewById(R.id.namereview);
            commenttxt=itemView.findViewById(R.id.commenttxt);
            rate=itemView.findViewById(R.id.ratingBar);
            rate.setEnabled(false);


        }
    }
}
