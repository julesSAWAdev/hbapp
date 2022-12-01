package com.example.secondexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class ServiceDescriptionVaccination extends AppCompatActivity {

    AutoCompleteTextView vacdirection,vacservice,vacresponsiblename,vaccurrentdata,vacresponsiblephoto,vacarea,vacrequestedlistofsupplies,vaccurrentlistofsupplies,vachygiene,vachandhygience;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description_vaccination);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);


        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        //vaccination service hook
        vacdirection = findViewById(R.id.vacdirectiontxt);
        vacservice = findViewById(R.id.vacservicelabeltxt);
        vacresponsiblename = findViewById(R.id.vacresponsenametxt);
        vaccurrentdata = findViewById(R.id.vaccurrentdatatxt);
        vacresponsiblephoto = findViewById(R.id.vacresponsiblephototxt);
        vacarea = findViewById(R.id.vacareamaintenedtxt);
        vacrequestedlistofsupplies = findViewById(R.id.vacsuppliestxt);
        vaccurrentlistofsupplies = findViewById(R.id.vacexisingsuppliestxt);
        vachygiene = findViewById(R.id.vachygienetxt);
        vachandhygience = findViewById(R.id.vachandtxt);

        //vaccination adapter
        vacdirection.setAdapter(adapterDist);
        vacservice.setAdapter(adapterDist);
        vacresponsiblename.setAdapter(adapterDist);
        vaccurrentdata.setAdapter(adapterDist);
        vacresponsiblephoto.setAdapter(adapterDist);
        vacarea.setAdapter(adapterDist);
        vacrequestedlistofsupplies.setAdapter(adapterDist);
        vaccurrentlistofsupplies.setAdapter(adapterDist);
        vachygiene.setAdapter(adapterDist);
        vachandhygience.setAdapter(adapterDist);



        saveNext = findViewById(R.id.serviceDescVac);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionFamilyplanning.class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);

                startActivity(intent);
            }
        });


    }


}