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

import com.example.clinicmangmentsystem.model.Articles;
import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.doctor.DetailsActivity;
import com.squareup.picasso.Picasso;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    Context context;
    List<Articles> articles;


    public NewsAdapter(Context context, List<Articles> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_item,null,false);
        return new ViewHolder(view);
    }

    @NonNull

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Articles a = articles.get(position);

        String imageUrl = a.getUrlToImage();
        String url = a.getUrl();
        Picasso.with(context).load(imageUrl).into(holder.imageView);
        holder.tvTitle.setText(a.getTitle());
        holder.tvSource.setText(a.getSource().getName());
        holder.tvDate.setText("\u2022"+dateTime(a.getPublishedAt()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DetailsActivity.class);
                i.putExtra("title",a.getTitle());
                i.putExtra("source",a.getSource().getName());
                i.putExtra("time",dateTime(a.getPublishedAt()));
                i.putExtra("desc",a.getDescription());
                i.putExtra("imageUrl",a.getUrlToImage());
                i.putExtra("url",a.getUrl());
                v.getContext().startActivity(i);
            }
        });

    }


    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvSource,tvDate;
        ImageView imageView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvSource = itemView.findViewById(R.id.tvSource);
            tvDate = itemView.findViewById(R.id.tvDate);
            imageView = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.cardviewnews);

        }

    }

    public String dateTime(String t){
        PrettyTime prettyTime = new PrettyTime(new Locale(getCountry()));
        String time = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:",Locale.ENGLISH);
            Date date = simpleDateFormat.parse(t);
            time = prettyTime.format(date);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return time;

    }

    public String getCountry(){
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country.toLowerCase();
    }
}
