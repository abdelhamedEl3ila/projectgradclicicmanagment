package com.example.clinicmangmentsystem.adapter;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.model.Governorate;
import com.example.clinicmangmentsystem.patient.SearchActivity;

import java.util.List;
public class GovernorateAdapter extends RecyclerView.Adapter<GovernorateAdapter.ViewHolder> {
    Context context;
    List<Governorate> governorateList;

    public GovernorateAdapter(Context context, List<Governorate> governorateList) {
        this.context = context;
        this.governorateList = governorateList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.governoraterecyler,parent,false);
        return new GovernorateAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Governorate a = governorateList.get(position);
        holder.governrate.setText(a.getGovernorate());
        holder.searchcardviewgover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences =context. getSharedPreferences("governorate", context.getApplicationContext().MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("cairo",a.getGovernorate());
                editor.commit();
                Intent i = new Intent(context, SearchActivity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return governorateList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView governrate;
        CardView searchcardviewgover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            governrate=itemView.findViewById(R.id.governtxt);
            searchcardviewgover=itemView.findViewById(R.id.searchcardviewgover);



        }
    }
}
