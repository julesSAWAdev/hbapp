package com.healthBuilders.surveyApp;

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
import android.widget.Toast;

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


        myDb = new Databasehelper(this);

        saveNext = findViewById(R.id.serviceDescVac);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xvacdirection = vacdirection.getText().toString().trim();
                final String xvacservice = vacservice.getText().toString().trim();
                final String xvacresponsiblename = vacresponsiblename.getText().toString().trim();
                final String xvaccurrentdata = vaccurrentdata.getText().toString().trim();
                final String xvacresponsiblephoto = vacresponsiblephoto.getText().toString().trim();
                final String xvacarea = vacarea.getText().toString().trim();
                final String xvacrequestedlistofsupplies = vacrequestedlistofsupplies.getText().toString().trim();
                final String xvaccurrentlistofsupplies = vaccurrentlistofsupplies.getText().toString().trim();
                final String xvachygiene = vachygiene.getText().toString().trim();
                final String xvachandhygience = vachandhygience.getText().toString().trim();

                boolean var = myDb.registerVacServiceDescription(xyear,xdistrict,xhc,xvacdirection,xvacservice,xvacresponsiblename,xvaccurrentdata,xvacresponsiblephoto,xvacarea,xvacrequestedlistofsupplies,xvaccurrentlistofsupplies,xvachygiene,xvachandhygience);
                if (var) {

                    Intent intent = new Intent(getBaseContext(), ServiceDescriptionFamilyplanning.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(ServiceDescriptionVaccination.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }


}