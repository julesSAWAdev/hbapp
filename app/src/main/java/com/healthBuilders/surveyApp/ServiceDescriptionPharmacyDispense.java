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

public class ServiceDescriptionPharmacyDispense extends AppCompatActivity {
    AutoCompleteTextView pharmacyDispdirection,pharmacyDispservice,pharmacyDispresponsiblename,pharmacyDispcurrentdata,pharmacyDispresponsiblephoto,pharmacyDisparea,pharmacyDisprequestedlistofsupplies,pharmacyDispcurrentlistofsupplies,pharmacyDisphygiene,pharmacyDisphandhygience;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description_pharmacy_dispense);

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");
        final String section = getIntent().getStringExtra("section");


        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        pharmacyDispdirection = findViewById(R.id.pharmacyDispdirectiontxt);
        pharmacyDispservice = findViewById(R.id.pharmacyDispservicelabeltxt);
        pharmacyDispresponsiblename = findViewById(R.id.pharmacyDispresponsenametxt);
        pharmacyDispcurrentdata = findViewById(R.id.pharmacyDispcurrentdatatxt);
        pharmacyDispresponsiblephoto = findViewById(R.id.pharmacyDispresponsiblephototxt);
        pharmacyDisparea = findViewById(R.id.pharmacyDispareamaintenedtxt);
        pharmacyDisprequestedlistofsupplies = findViewById(R.id.pharmacyDispsuppliestxt);
        pharmacyDispcurrentlistofsupplies = findViewById(R.id.pharmacyDispexisingsuppliestxt);
        pharmacyDisphygiene = findViewById(R.id.pharmacyDisphygienetxt);
        pharmacyDisphandhygience = findViewById(R.id.pharmacyDisphandtxt);

        //family planning adapterlist
        pharmacyDispdirection.setAdapter(adapterDist);
        pharmacyDispservice.setAdapter(adapterDist);
        pharmacyDispresponsiblename.setAdapter(adapterDist);
        pharmacyDispcurrentdata.setAdapter(adapterDist);
        pharmacyDispresponsiblephoto.setAdapter(adapterDist);
        pharmacyDisparea.setAdapter(adapterDist);
        pharmacyDisprequestedlistofsupplies.setAdapter(adapterDist);
        pharmacyDispcurrentlistofsupplies.setAdapter(adapterDist);
        pharmacyDisphygiene.setAdapter(adapterDist);
        pharmacyDisphandhygience.setAdapter(adapterDist);

        myDb = new Databasehelper(this);

        saveNext = findViewById(R.id.serviceDescPharmadisp);


        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xpharmacyDispdirection = pharmacyDispdirection.getText().toString().trim();
                final String xpharmacyDispservice = pharmacyDispservice.getText().toString().trim();
                final String xpharmacyDispresponsiblename = pharmacyDispresponsiblename.getText().toString().trim();
                final String xpharmacyDispcurrentdata = pharmacyDispcurrentdata.getText().toString().trim();
                final String xpharmacyDispresponsiblephoto = pharmacyDispresponsiblephoto.getText().toString().trim();
                final String xpharmacyDisparea = pharmacyDisparea.getText().toString().trim();
                final String xpharmacyDisprequestedlistofsupplies = pharmacyDisprequestedlistofsupplies.getText().toString().trim();
                final String xpharmacyDispcurrentlistofsupplies = pharmacyDispcurrentlistofsupplies.getText().toString().trim();
                final String xpharmacyDisphygiene = pharmacyDisphygiene.getText().toString().trim();
                final String xpharmacyDisphandhygience = pharmacyDisphandhygience.getText().toString().trim();

                boolean var = myDb.registerPharmacyDispenseServiceDescription(xyear,xdistrict,xhc,xpharmacyDispdirection,xpharmacyDispservice,xpharmacyDispresponsiblename,xpharmacyDispcurrentdata,xpharmacyDispresponsiblephoto,xpharmacyDisparea,xpharmacyDisprequestedlistofsupplies,xpharmacyDispcurrentlistofsupplies,xpharmacyDisphygiene,xpharmacyDisphandhygience);

                if(var) {
                    Intent intent = new Intent(getBaseContext(), Services.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);
                    intent.putExtra("section", section);


                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(ServiceDescriptionPharmacyDispense.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}