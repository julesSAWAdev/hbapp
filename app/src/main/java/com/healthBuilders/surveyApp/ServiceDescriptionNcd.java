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

public class ServiceDescriptionNcd extends AppCompatActivity {
    AutoCompleteTextView ncddirection,ncdservice,ncdresponsiblename,ncdcurrentdata,ncdresponsiblephoto,ncdarea,ncdrequestedlistofsupplies,ncdcurrentlistofsupplies,ncdhygiene,ncdhandhygience;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description_ncd);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);
        ncddirection = findViewById(R.id.ncddirectiontxt);
        ncdservice = findViewById(R.id.ncdservicelabeltxt);
        ncdresponsiblename = findViewById(R.id.ncdresponsenametxt);
        ncdcurrentdata = findViewById(R.id.ncdcurrentdatatxt);
        ncdresponsiblephoto = findViewById(R.id.ncdresponsiblephototxt);
        ncdarea = findViewById(R.id.ncdareamaintenedtxt);
        ncdrequestedlistofsupplies = findViewById(R.id.ncdsuppliestxt);
        ncdcurrentlistofsupplies = findViewById(R.id.ncdexisingsuppliestxt);
        ncdhygiene = findViewById(R.id.ncdhygienetxt);
        ncdhandhygience = findViewById(R.id.ncdhandtxt);

        //family planning adapterlist
        ncddirection.setAdapter(adapterDist);
        ncdservice.setAdapter(adapterDist);
        ncdresponsiblename.setAdapter(adapterDist);
        ncdcurrentdata.setAdapter(adapterDist);
        ncdresponsiblephoto.setAdapter(adapterDist);
        ncdarea.setAdapter(adapterDist);
        ncdrequestedlistofsupplies.setAdapter(adapterDist);
        ncdcurrentlistofsupplies.setAdapter(adapterDist);
        ncdhygiene.setAdapter(adapterDist);
        ncdhandhygience.setAdapter(adapterDist);
        myDb = new Databasehelper(this);

        saveNext = findViewById(R.id.serviceDescNCD);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xncddirection = ncddirection.getText().toString().trim();
                final String xncdservice = ncdservice.getText().toString().trim();
                final String xncdresponsiblename = ncdresponsiblename.getText().toString().trim();
                final String xncdcurrentdata = ncdcurrentdata.getText().toString().trim();
                final String xncdresponsiblephoto = ncdresponsiblephoto.getText().toString().trim();
                final String xncdarea = ncdarea.getText().toString().trim();
                final String xncdrequestedlistofsupplies = ncdrequestedlistofsupplies.getText().toString().trim();
                final String xncdcurrentlistofsupplies = ncdcurrentlistofsupplies.getText().toString().trim();
                final String xncdhygiene = ncdhygiene.getText().toString().trim();
                final String xncdhandhygience = ncdhandhygience.getText().toString().trim();

                boolean var = myDb.registerNcdServiceDescription(xyear,xdistrict,xhc,xncddirection,xncdservice,xncdresponsiblename,xncdcurrentdata,xncdresponsiblephoto,xncdarea,xncdrequestedlistofsupplies,xncdcurrentlistofsupplies,xncdhygiene,xncdhandhygience);
                if (var) {

                    Intent intent = new Intent(getBaseContext(), Services.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(ServiceDescriptionNcd.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }

        });
    }
}