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

public class ServiceDescriptionPharmacy extends AppCompatActivity {
    AutoCompleteTextView pharmacydirection,pharmacyservice,pharmacyresponsiblename,pharmacycurrentdata,pharmacyresponsiblephoto,pharmacyarea,pharmacyrequestedlistofsupplies,pharmacycurrentlistofsupplies,pharmacyhygiene,pharmacyhandhygience;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description_pharmacy);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");
        final String section = getIntent().getStringExtra("section");


        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        pharmacydirection = findViewById(R.id.pharmacydirectiontxt);
        pharmacyservice = findViewById(R.id.pharmacyservicelabeltxt);
        pharmacyresponsiblename = findViewById(R.id.pharmacyresponsenametxt);
        pharmacycurrentdata = findViewById(R.id.pharmacycurrentdatatxt);
        pharmacyresponsiblephoto = findViewById(R.id.pharmacyresponsiblephototxt);
        pharmacyarea = findViewById(R.id.pharmacyareamaintenedtxt);
        pharmacyrequestedlistofsupplies = findViewById(R.id.pharmacysuppliestxt);
        pharmacycurrentlistofsupplies = findViewById(R.id.pharmacyexisingsuppliestxt);
        pharmacyhygiene = findViewById(R.id.pharmacyhygienetxt);
        pharmacyhandhygience = findViewById(R.id.pharmacyhandtxt);

        //family planning adapterlist
        pharmacydirection.setAdapter(adapterDist);
        pharmacyservice.setAdapter(adapterDist);
        pharmacyresponsiblename.setAdapter(adapterDist);
        pharmacycurrentdata.setAdapter(adapterDist);
        pharmacyresponsiblephoto.setAdapter(adapterDist);
        pharmacyarea.setAdapter(adapterDist);
        pharmacyrequestedlistofsupplies.setAdapter(adapterDist);
        pharmacycurrentlistofsupplies.setAdapter(adapterDist);
        pharmacyhygiene.setAdapter(adapterDist);
        pharmacyhandhygience.setAdapter(adapterDist);

        myDb = new Databasehelper(this);

        saveNext = findViewById(R.id.serviceDescPharma);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xpharmacydirection = pharmacydirection.getText().toString().trim();
                final String xpharmacyservice = pharmacyservice.getText().toString().trim();
                final String xpharmacyresponsiblename = pharmacyresponsiblename.getText().toString().trim();
                final String xpharmacycurrentdata = pharmacycurrentdata.getText().toString().trim();
                final String xpharmacyresponsiblephoto = pharmacyresponsiblephoto.getText().toString().trim();
                final String xpharmacyarea = pharmacyarea.getText().toString().trim();
                final String xpharmacyrequestedlistofsupplies = pharmacyrequestedlistofsupplies.getText().toString().trim();
                final String xpharmacycurrentlistofsupplies = pharmacycurrentlistofsupplies.getText().toString().trim();
                final String xpharmacyhygiene = pharmacyhygiene.getText().toString().trim();
                final String xpharmacyhandhygience = pharmacyhandhygience.getText().toString().trim();

                boolean var = myDb.registerPharmacyServiceDescription(xyear,xdistrict,xhc,xpharmacydirection,xpharmacyservice,xpharmacyresponsiblename,xpharmacycurrentdata,xpharmacyresponsiblephoto,xpharmacyarea,xpharmacyrequestedlistofsupplies,xpharmacycurrentlistofsupplies,xpharmacyhygiene,xpharmacyhandhygience);
                if (var) {
                    Intent intent = new Intent(getBaseContext(), Services.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);
                    intent.putExtra("section", section);

                    startActivity(intent);
                    finish();
                } else{
                    Toast.makeText(ServiceDescriptionPharmacy.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

}