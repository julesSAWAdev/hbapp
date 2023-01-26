package com.healthBuilders.surveyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class healthEducation extends AppCompatActivity {
    AutoCompleteTextView rmsessions,rmbeneficiones,rmscreened,idsessions,idbeneficiones,idscreened,
            ncsessions,ncbeneficiones,ncscreened;
    Button saveNext;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_health_education);


        Intent intent = getIntent();
        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        rmsessions=findViewById(R.id.rmncEdSessions);
        rmbeneficiones=findViewById(R.id.rmncEdBeneficiones);
        rmscreened=findViewById(R.id.rmncEdScreened);

        idsessions=findViewById(R.id.idEdSessions);
        idbeneficiones=findViewById(R.id.idEdBeneficiones);
        idscreened=findViewById(R.id.idEdScreened);

        ncsessions=findViewById(R.id.ncdEdSessions);
        ncbeneficiones=findViewById(R.id.ncdEdBeneficiones);
        ncscreened=findViewById(R.id.ncdEdScreened);



        saveNext=findViewById(R.id.nextPage2);

        //adapter
        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        //set adapters
        rmsessions.setAdapter(adapterDist);
        rmbeneficiones.setAdapter(adapterDist);
        rmscreened.setAdapter(adapterDist);

        idsessions.setAdapter(adapterDist);
        idbeneficiones.setAdapter(adapterDist);
        idscreened.setAdapter(adapterDist);


        ncsessions.setAdapter(adapterDist);
        ncbeneficiones.setAdapter(adapterDist);
        ncscreened.setAdapter(adapterDist);


        myDb = new Databasehelper(this);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xrmsessions=rmsessions.getText().toString().trim();
                final String xrmbeneficiones=rmbeneficiones.getText().toString().trim();
                final String xrmscreened=rmscreened.getText().toString().trim();
                final String xidsessions=idsessions.getText().toString().trim();
                final String xidbeneficiones=idbeneficiones.getText().toString().trim();
                final String xidscreened=idscreened.getText().toString().trim();
                final String xncsessions=ncsessions.getText().toString().trim();
                final String xncbeneficiones=ncbeneficiones.getText().toString().trim();
                final String xncscreened=ncscreened.getText().toString().trim();

                boolean var = myDb.registerHealthEducation(xyear,xdistrict,xhc,xrmsessions,xrmbeneficiones,xrmscreened,xidsessions,xidbeneficiones,xidscreened,xncsessions,xncbeneficiones,xncscreened);
                if (var) {
                    Intent intent = new Intent(getBaseContext(), SurveySection.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                    startActivity(intent);
                }else{
                    Toast.makeText(healthEducation.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}