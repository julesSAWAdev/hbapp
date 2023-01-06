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

public class ServiceDescriptionConsultation extends AppCompatActivity {
    AutoCompleteTextView Consultationdirection,Consultationservice,Consultationresponsiblename,Consultationcurrentdata,Consultationresponsiblephoto,Consultationarea,Consultationrequestedlistofsupplies,Consultationcurrentlistofsupplies,Consultationhygiene,Consultationhandhygience;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description_consultation);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        Consultationdirection = findViewById(R.id.Consultationdirectiontxt);
        Consultationservice = findViewById(R.id.Consultationservicelabeltxt);
        Consultationresponsiblename = findViewById(R.id.Consultationresponsenametxt);
        Consultationcurrentdata = findViewById(R.id.Consultationcurrentdatatxt);
        Consultationresponsiblephoto = findViewById(R.id.Consultationresponsiblephototxt);
        Consultationarea = findViewById(R.id.Consultationareamaintenedtxt);
        Consultationrequestedlistofsupplies = findViewById(R.id.Consultationsuppliestxt);
        Consultationcurrentlistofsupplies = findViewById(R.id.Consultationexisingsuppliestxt);
        Consultationhygiene = findViewById(R.id.Consultationhygienetxt);
        Consultationhandhygience = findViewById(R.id.Consultationhandtxt);

        //family planning adapterlist
        Consultationdirection.setAdapter(adapterDist);
        Consultationservice.setAdapter(adapterDist);
        Consultationresponsiblename.setAdapter(adapterDist);
        Consultationcurrentdata.setAdapter(adapterDist);
        Consultationresponsiblephoto.setAdapter(adapterDist);
        Consultationarea.setAdapter(adapterDist);
        Consultationrequestedlistofsupplies.setAdapter(adapterDist);
        Consultationcurrentlistofsupplies.setAdapter(adapterDist);
        Consultationhygiene.setAdapter(adapterDist);
        Consultationhandhygience.setAdapter(adapterDist);

        myDb = new Databasehelper(this);

        saveNext = findViewById(R.id.serviceDescConsultation);


        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xConsultationdirection = Consultationdirection.getText().toString().trim();
                final String xConsultationservice = Consultationservice.getText().toString().trim();
                final String xConsultationresponsiblename = Consultationresponsiblename.getText().toString().trim();
                final String xConsultationcurrentdata = Consultationcurrentdata.getText().toString().trim();
                final String xConsultationresponsiblephoto = Consultationresponsiblephoto.getText().toString().trim();
                final String xConsultationarea = Consultationarea.getText().toString().trim();
                final String xConsultationrequestedlistofsupplies = Consultationrequestedlistofsupplies.getText().toString().trim();
                final String xConsultationcurrentlistofsupplies = Consultationcurrentlistofsupplies.getText().toString().trim();
                final String xConsultationhygiene = Consultationhygiene.getText().toString().trim();
                final String xConsultationhandhygience = Consultationhandhygience.getText().toString().trim();

                boolean var = myDb.registerConsultationServiceDescription(xyear,xdistrict,xhc,xConsultationdirection,xConsultationservice,xConsultationresponsiblename,xConsultationcurrentdata,xConsultationresponsiblephoto,xConsultationarea,xConsultationrequestedlistofsupplies,xConsultationcurrentlistofsupplies,xConsultationhygiene,xConsultationhandhygience);

                if(var) {
                    Intent intent = new Intent(getBaseContext(), Services.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(ServiceDescriptionConsultation.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}