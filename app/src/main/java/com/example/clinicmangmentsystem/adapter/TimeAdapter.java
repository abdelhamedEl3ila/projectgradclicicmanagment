package com.example.clinicmangmentsystem.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.SelectDoctorActivity;
import com.example.clinicmangmentsystem.doctor.DetailsActivity;
import com.example.clinicmangmentsystem.model.Articles;
import com.example.clinicmangmentsystem.model.Doctortime;

import java.util.List;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.ViewHolder> {
Context context;
List<Doctortime> doctortimes ;

    public TimeAdapter(Context context, List<Doctortime> doctortimes) {
        this.context = context;
        this.doctortimes = doctortimes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.timelayout,null,false);
        return new TimeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Doctortime a = doctortimes.get(position);
        holder.day.setText(a.getName());
        holder.time.setText(a.getStart());
//        holder.book.setText(a.getEnd());
        holder.bookday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), SelectDoctorActivity.class);

                i.putExtra("Satrttime",a.getStart());
                i.putExtra("Endtime",a.getEnd());
                i.putExtra("day",a.getName());
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return doctortimes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView day ,time,book;
        CardView  bookday;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            day=itemView.findViewById(R.id.daytxt);
            time=itemView.findViewById(R.id.daytime);
            book=itemView.findViewById(R.id.bookdoctorbtn);
            bookday=itemView.findViewById(R.id.bookcardview);


        }
    }
}
