package com.example.clinicmangmentsystem.doctor;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clinicmangmentsystem.ApiClient;
import com.example.clinicmangmentsystem.Articles;
import com.example.clinicmangmentsystem.Headlines;
import com.example.clinicmangmentsystem.NewsAdapter;
import com.example.clinicmangmentsystem.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends Fragment {

    public NewsFragment() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    EditText etQuery;
    Button btnSearch,btnAboutUs;
    Dialog dialog;
    final String API_KEY = "0a6e422a132845debb314c9db4ac7020";
    NewsAdapter adapter;
    List<Articles> articles = new ArrayList<>();
    private Context mContext;
    final String country = getCountry();
     String category;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_news, container, false);
        swipeRefreshLayout = v.findViewById(R.id.swipeRefresh);
        recyclerView =v. findViewById(R.id.recyclerView);

        etQuery = v.findViewById(R.id.etQuery);
        btnSearch =v. findViewById(R.id.btnSearch);
        btnAboutUs = v.findViewById(R.id.aboutUs);
        dialog = new Dialog(getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter= new NewsAdapter(getContext(),articles);
        recyclerView.setAdapter(adapter);
        findNews();



        return  v;


    }

    private void findNews() {

        ApiClient.getapiinterface().getCategoryNews(country,category,API_KEY).enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, Response<Headlines> response) {
                if (response.isSuccessful())
                {
                    articles.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<Headlines> call, Throwable t) {


            }
        });




    }


    public String getCountry(){
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country.toLowerCase();
    }

    public void showDialog(){
        Button btnClose;
        dialog.setContentView(R.layout.about_us_pop_up);
        dialog.show();
        btnClose = dialog.findViewById(R.id.close);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    }
