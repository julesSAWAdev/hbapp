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

public class ServiceDescriptionAccounting extends AppCompatActivity {
    AutoCompleteTextView accountingdirection,accountingservice,accountingresponsiblename,accountingcurrentdata,accountingresponsiblephoto,accountingarea,accountingrequestedlistofsupplies,accountingcurrentlistofsupplies,accountinghygiene,accountinghandhygience;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description_accounting);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);


        accountingdirection = findViewById(R.id.accountingdirectiontxt);
        accountingservice = findViewById(R.id.accountingservicelabeltxt);
        accountingresponsiblename = findViewById(R.id.accountingresponsenametxt);
        accountingcurrentdata = findViewById(R.id.accountingcurrentdatatxt);
        accountingresponsiblephoto = findViewById(R.id.accountingresponsiblephototxt);
        accountingarea = findViewById(R.id.accountingareamaintenedtxt);
        accountingrequestedlistofsupplies = findViewById(R.id.accountingsuppliestxt);
        accountingcurrentlistofsupplies = findViewById(R.id.accountingexisingsuppliestxt);
        accountinghygiene = findViewById(R.id.accountinghygienetxt);
        accountinghandhygience = findViewById(R.id.accountinghandtxt);

        //family planning adapterlist
        accountingdirection.setAdapter(adapterDist);
        accountingservice.setAdapter(adapterDist);
        accountingresponsiblename.setAdapter(adapterDist);
        accountingcurrentdata.setAdapter(adapterDist);
        accountingresponsiblephoto.setAdapter(adapterDist);
        accountingarea.setAdapter(adapterDist);
        accountingrequestedlistofsupplies.setAdapter(adapterDist);
        accountingcurrentlistofsupplies.setAdapter(adapterDist);
        accountinghygiene.setAdapter(adapterDist);
        accountinghandhygience.setAdapter(adapterDist);

        saveNext = findViewById(R.id.serviceDescaccounting);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ServiceDescriptionLaboratory.class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);

                startActivity(intent);
            }
        });
    }
}