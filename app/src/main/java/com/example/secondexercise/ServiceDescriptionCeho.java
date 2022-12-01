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

public class ServiceDescriptionCeho extends AppCompatActivity {
    AutoCompleteTextView cehodirection,cehoservice,cehoresponsiblename,cehocurrentdata,cehoresponsiblephoto,cehoarea,cehorequestedlistofsupplies,cehocurrentlistofsupplies,cehohygiene,cehohandhygience;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveNext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_descriptyion_ceho);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);


        cehodirection = findViewById(R.id.cehodirectiontxt);
        cehoservice = findViewById(R.id.cehoservicelabeltxt);
        cehoresponsiblename = findViewById(R.id.cehoresponsenametxt);
        cehocurrentdata = findViewById(R.id.cehocurrentdatatxt);
        cehoresponsiblephoto = findViewById(R.id.cehoresponsiblephototxt);
        cehoarea = findViewById(R.id.cehoareamaintenedtxt);
        cehorequestedlistofsupplies = findViewById(R.id.cehosuppliestxt);
        cehocurrentlistofsupplies = findViewById(R.id.cehoexisingsuppliestxt);
        cehohygiene = findViewById(R.id.cehohygienetxt);
        cehohandhygience = findViewById(R.id.cehohandtxt);

        //family planning adapterlist
        cehodirection.setAdapter(adapterDist);
        cehoservice.setAdapter(adapterDist);
        cehoresponsiblename.setAdapter(adapterDist);
        cehocurrentdata.setAdapter(adapterDist);
        cehoresponsiblephoto.setAdapter(adapterDist);
        cehoarea.setAdapter(adapterDist);
        cehorequestedlistofsupplies.setAdapter(adapterDist);
        cehocurrentlistofsupplies.setAdapter(adapterDist);
        cehohygiene.setAdapter(adapterDist);
        cehohandhygience.setAdapter(adapterDist);

        saveNext = findViewById(R.id.serviceDescceho);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent = new Intent(getBaseContext(), ServiceDescriptionPharmacyDispense.class);
                //intent.putExtra("year_id", year);
                //intent.putExtra("district", district);
                //intent.putExtra("hc", hc);

                //startActivity(intent);
            }
        });

    }
}