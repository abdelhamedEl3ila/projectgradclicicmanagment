package com.example.clinicmangmentsystem.patient;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.clinicmangmentsystem.ApiClientapp;
import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.adapter.SchduleAdapter;
import com.example.clinicmangmentsystem.adapter.SectionPagerAdapter;
import com.example.clinicmangmentsystem.model.Schdulepat;
import com.example.clinicmangmentsystem.model.Showbooking;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ActivitypatFragment extends Fragment {

    RecyclerView recyclerView;
    private List<Schdulepat> schdulepats = new ArrayList<>();
    SchduleAdapter adapter;
    Context context;
    String token;
    LinearLayout linearLayout;

    public static ActivitypatFragment getInstance() {
        return new ActivitypatFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_activitypat, container, false);
        recyclerView = v.findViewById(R.id.recschdulepat);
        linearLayout = v.findViewById(R.id.noactivity);
        SharedPreferences prfs = this.getActivity().getSharedPreferences("Token", Context.MODE_PRIVATE);
        token = prfs.getString("token", "");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new SchduleAdapter(getContext(), schdulepats);
        recyclerView.setAdapter(adapter);
        getallbook();

        return v;
    }

    private void getallbook() {
        Call<Showbooking> call = ApiClientapp.getservice().getallshdule("Bearer " + token);
        call.enqueue(new Callback<Showbooking>() {
            @Override
            public void onResponse(Call<Showbooking> call, Response<Showbooking> response) {
                if (response.isSuccessful() && response.body().getBookedAppointments() != null) {
                    schdulepats.addAll(response.body().getBookedAppointments());
                    adapter.notifyDataSetChanged();
                    linearLayout.setVisibility(View.INVISIBLE);

                } else {

                    String message = "error";
                    Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    ;

                }
            }

            @Override
            public void onFailure(Call<Showbooking> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_LONG).show();
                ;
            }
        });


    }
}