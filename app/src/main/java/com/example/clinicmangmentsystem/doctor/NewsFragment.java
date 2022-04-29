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
    Button btnSearch, btnAboutUs;
    Dialog dialog;
    final String API_KEY = "0a6e422a132845debb314c9db4ac7020";
    NewsAdapter adapter;
    List<Articles> articles = new ArrayList<>();
    private Context mContext;
    final String country = "eg";
    String category = "health";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_news, container, false);
        swipeRefreshLayout = v.findViewById(R.id.swipeRefresh);
        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dialog = new Dialog(getContext());
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                retrieveJson("",country,category,API_KEY);
            }
        });
        retrieveJson("",country,category,API_KEY);

        return v;


    }

    public void retrieveJson(String query, String country, String category, String apiKey) {

        swipeRefreshLayout.setRefreshing(true);
        Call<Headlines> call;
        call = ApiClient.getInstance().getApi().getHeadlines(country, category, apiKey);
        call.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, Response<Headlines> response) {
                if (response.isSuccessful() && response.body().getArticles() != null) {
                    swipeRefreshLayout.setRefreshing(false);
                    articles.clear();
                    articles = response.body().getArticles();
                    adapter = new NewsAdapter(getContext(), articles);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Headlines> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}
