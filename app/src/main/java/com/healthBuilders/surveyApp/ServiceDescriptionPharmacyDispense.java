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

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);

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

        saveNext = findViewById(R.id.serviceDescPharmadisp);


        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionNcd.class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);

                startActivity(intent);
            }
        });


    }
}