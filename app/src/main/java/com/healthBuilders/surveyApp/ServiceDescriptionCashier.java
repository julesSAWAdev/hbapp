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

public class ServiceDescriptionCashier extends AppCompatActivity {
    AutoCompleteTextView cashierdirection,cashierservice,cashierresponsiblename,cashiercurrentdata,cashierresponsiblephoto,cashierarea,cashierrequestedlistofsupplies,cashiercurrentlistofsupplies,cashierhygiene,cashierhandhygience;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description_cashier);


        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        cashierdirection = findViewById(R.id.cashierdirectiontxt);
        cashierservice = findViewById(R.id.cashierservicelabeltxt);
        cashierresponsiblename = findViewById(R.id.cashierresponsenametxt);
        cashiercurrentdata = findViewById(R.id.cashiercurrentdatatxt);
        cashierresponsiblephoto = findViewById(R.id.cashierresponsiblephototxt);
        cashierarea = findViewById(R.id.cashierareamaintenedtxt);
        cashierrequestedlistofsupplies = findViewById(R.id.cashiersuppliestxt);
        cashiercurrentlistofsupplies = findViewById(R.id.cashierexisingsuppliestxt);
        cashierhygiene = findViewById(R.id.cashierhygienetxt);
        cashierhandhygience = findViewById(R.id.cashierhandtxt);

        //family planning adapterlist
        cashierdirection.setAdapter(adapterDist);
        cashierservice.setAdapter(adapterDist);
        cashierresponsiblename.setAdapter(adapterDist);
        cashiercurrentdata.setAdapter(adapterDist);
        cashierresponsiblephoto.setAdapter(adapterDist);
        cashierarea.setAdapter(adapterDist);
        cashierrequestedlistofsupplies.setAdapter(adapterDist);
        cashiercurrentlistofsupplies.setAdapter(adapterDist);
        cashierhygiene.setAdapter(adapterDist);
        cashierhandhygience.setAdapter(adapterDist);

        saveNext = findViewById(R.id.serviceDesccashier);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionAccounting.class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);

                startActivity(intent);
            }
        });

    }
}