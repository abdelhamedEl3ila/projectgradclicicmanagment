package com.example.clinicmangmentsystem.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.clinicmangmentsystem.R;
import com.example.clinicmangmentsystem.adapter.GovernorateAdapter;
import com.example.clinicmangmentsystem.adapter.ReviewAdapter;
import com.example.clinicmangmentsystem.adapter.SearchAdapter;
import com.example.clinicmangmentsystem.model.Governorate;
import com.example.clinicmangmentsystem.model.Search;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SearchAdapter searchAdapter;
    private ArrayList<Search> searches;
    private SearchView searchView ;
    private Dialog dialog;
    private GovernorateAdapter governorateAdapter;
    private List<Governorate> governoratelist=new ArrayList<>();
    private String governorate;
    private TextView enterGovernorate , Selected;
    private ImageView backmain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerView=findViewById(R.id.recsearch);
        enterGovernorate =findViewById(R.id.enterGovernorate);
        Selected =findViewById(R.id.gocertselected);
        recyclerView=findViewById(R.id.recsearch);
        backmain=findViewById(R.id.backmain);
        backmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.searchactivity,new HomepatFragment()).commit();
            }
        });
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.governrate_layout);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.setCancelable(true); //Optional
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog
        RecyclerView recyclerView1 = dialog.findViewById(R.id.recyclergovernorate);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        governorateAdapter = new GovernorateAdapter(this,governoratelist);
        recyclerView1.setAdapter(governorateAdapter);
        governoratelist.add(new Governorate("Cairo"));
        governoratelist.add(new Governorate("Qalyubia "));
        governoratelist.add(new Governorate("Alexandria"));
        governoratelist.add(new Governorate("Asyut"));
        governoratelist.add(new Governorate("Aswan"));
        governoratelist.add(new Governorate("Beheira"));
        governoratelist.add(new Governorate("Luxor"));
        governoratelist.add(new Governorate("Fayoom"));
        governoratelist.add(new Governorate("Tanta"));
        governoratelist.add(new Governorate("Hurgada"));
        governoratelist.add(new Governorate("Dakahlia"));
        governoratelist.add(new Governorate("Gharbia"));
        governoratelist.add(new Governorate("Port Said"));
        governoratelist.add(new Governorate("Other"));
        SharedPreferences preferences =getSharedPreferences("governorate", getApplicationContext().MODE_PRIVATE);
       governorate= preferences.getString("cairo",null);
        Selected.setText(governorate);
        enterGovernorate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searches=new ArrayList<>();
        searchAdapter =new SearchAdapter(this,searches);
        recyclerView.setAdapter(searchAdapter);
        searches.add(new Search("Dentistry",R.drawable.ic_dentisticon));
        searches.add(new Search("New Born ",R.drawable.ic_dentisticon));
        searches.add(new Search("Dentistry",R.drawable.ic_dentisticon));
        searches.add(new Search("Osteopathy",R.drawable.ic_paediatricsicon));
        searches.add(new Search("Paediatrics",R.drawable.ic_paediatricsicon));
        searches.add(new Search("Anesthesiologists",R.drawable.ic_paediatricsicon));
        searches.add(new Search("Neurologists",R.drawable.ic_paediatricsicon));
        searches.add(new Search("Gynecologists",R.drawable.ic_paediatricsicon));
        searches.add(new Search("Obstetricians",R.drawable.ic_paediatricsicon));
        searches.add(new Search("Emergency physicians",R.drawable.ic_paediatricsicon));
        searches.add(new Search("Internists",R.drawable.ic_paediatricsicon));
        searches.add(new Search("Family physicians",R.drawable.ic_paediatricsicon));
        searches.add(new Search("Radiologists",R.drawable.ic_paediatricsicon));
//        searches.add(new Search("Other",R.drawable.ic_paediatricsicon));


    }
}