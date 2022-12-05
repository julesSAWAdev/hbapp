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

public class ServiceDescriptionHospitalization extends AppCompatActivity {
    AutoCompleteTextView Hospitalizationdirection,Hospitalizationservice,Hospitalizationresponsiblename,Hospitalizationcurrentdata,Hospitalizationresponsiblephoto,Hospitalizationarea,Hospitalizationrequestedlistofsupplies,Hospitalizationcurrentlistofsupplies,Hospitalizationhygiene,Hospitalizationhandhygience;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description_hospitalization);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        Hospitalizationdirection = findViewById(R.id.Hospitalizationdirectiontxt);
        Hospitalizationservice = findViewById(R.id.Hospitalizationservicelabeltxt);
        Hospitalizationresponsiblename = findViewById(R.id.Hospitalizationresponsenametxt);
        Hospitalizationcurrentdata = findViewById(R.id.Hospitalizationcurrentdatatxt);
        Hospitalizationresponsiblephoto = findViewById(R.id.Hospitalizationresponsiblephototxt);
        Hospitalizationarea = findViewById(R.id.Hospitalizationareamaintenedtxt);
        Hospitalizationrequestedlistofsupplies = findViewById(R.id.Hospitalizationsuppliestxt);
        Hospitalizationcurrentlistofsupplies = findViewById(R.id.Hospitalizationexisingsuppliestxt);
        Hospitalizationhygiene = findViewById(R.id.Hospitalizationhygienetxt);
        Hospitalizationhandhygience = findViewById(R.id.Hospitalizationhandtxt);

        //family planning adapterlist
        Hospitalizationdirection.setAdapter(adapterDist);
        Hospitalizationservice.setAdapter(adapterDist);
        Hospitalizationresponsiblename.setAdapter(adapterDist);
        Hospitalizationcurrentdata.setAdapter(adapterDist);
        Hospitalizationresponsiblephoto.setAdapter(adapterDist);
        Hospitalizationarea.setAdapter(adapterDist);
        Hospitalizationrequestedlistofsupplies.setAdapter(adapterDist);
        Hospitalizationcurrentlistofsupplies.setAdapter(adapterDist);
        Hospitalizationhygiene.setAdapter(adapterDist);
        Hospitalizationhandhygience.setAdapter(adapterDist);

        myDb = new Databasehelper(this);

        saveNext = findViewById(R.id.serviceDescHospitalization);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xHospitalizationdirection = Hospitalizationdirection.getText().toString().trim();
                final String xHospitalizationservice = Hospitalizationservice.getText().toString().trim();
                final String xHospitalizationresponsiblename = Hospitalizationresponsiblename.getText().toString().trim();
                final String xHospitalizationcurrentdata = Hospitalizationcurrentdata.getText().toString().trim();
                final String xHospitalizationresponsiblephoto = Hospitalizationresponsiblephoto.getText().toString().trim();
                final String xHospitalizationarea = Hospitalizationarea.getText().toString().trim();
                final String xHospitalizationrequestedlistofsupplies = Hospitalizationrequestedlistofsupplies.getText().toString().trim();
                final String xHospitalizationcurrentlistofsupplies = Hospitalizationcurrentlistofsupplies.getText().toString().trim();
                final String xHospitalizationhygiene = Hospitalizationhygiene.getText().toString().trim();
                final String xHospitalizationhandhygience = Hospitalizationhandhygience.getText().toString().trim();

                boolean var = myDb.registerHospitalizationServiceDescription(xyear,xdistrict,xhc,xHospitalizationdirection,xHospitalizationservice,xHospitalizationresponsiblename,xHospitalizationcurrentdata,xHospitalizationresponsiblephoto,xHospitalizationarea,xHospitalizationrequestedlistofsupplies,xHospitalizationcurrentlistofsupplies,xHospitalizationhygiene,xHospitalizationhandhygience);
                if (var) {

                    Intent intent = new Intent(getBaseContext(), ServiceDescriptionToilets.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(ServiceDescriptionHospitalization.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}