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

public class ServiceDescriptionMaternity extends AppCompatActivity {
    AutoCompleteTextView Maternitydirection,Maternityservice,Maternityresponsiblename,Maternitycurrentdata,Maternityresponsiblephoto,Maternityarea,Maternityrequestedlistofsupplies,Maternitycurrentlistofsupplies,Maternityhygiene,Maternityhandhygience;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description_maternity);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        Maternitydirection = findViewById(R.id.Maternitydirectiontxt);
        Maternityservice = findViewById(R.id.Maternityservicelabeltxt);
        Maternityresponsiblename = findViewById(R.id.Maternityresponsenametxt);
        Maternitycurrentdata = findViewById(R.id.Maternitycurrentdatatxt);
        Maternityresponsiblephoto = findViewById(R.id.Maternityresponsiblephototxt);
        Maternityarea = findViewById(R.id.Maternityareamaintenedtxt);
        Maternityrequestedlistofsupplies = findViewById(R.id.Maternitysuppliestxt);
        Maternitycurrentlistofsupplies = findViewById(R.id.Maternityexisingsuppliestxt);
        Maternityhygiene = findViewById(R.id.Maternityhygienetxt);
        Maternityhandhygience = findViewById(R.id.Maternityhandtxt);

        //family planning adapterlist
        Maternitydirection.setAdapter(adapterDist);
        Maternityservice.setAdapter(adapterDist);
        Maternityresponsiblename.setAdapter(adapterDist);
        Maternitycurrentdata.setAdapter(adapterDist);
        Maternityresponsiblephoto.setAdapter(adapterDist);
        Maternityarea.setAdapter(adapterDist);
        Maternityrequestedlistofsupplies.setAdapter(adapterDist);
        Maternitycurrentlistofsupplies.setAdapter(adapterDist);
        Maternityhygiene.setAdapter(adapterDist);
        Maternityhandhygience.setAdapter(adapterDist);

        myDb = new Databasehelper(this);

        saveNext = findViewById(R.id.serviceDescMaternity);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xMaternitydirection = Maternitydirection.getText().toString().trim();
                final String xMaternityservice = Maternityservice.getText().toString().trim();
                final String xMaternityresponsiblename = Maternityresponsiblename.getText().toString().trim();
                final String xMaternitycurrentdata = Maternitycurrentdata.getText().toString().trim();
                final String xMaternityresponsiblephoto = Maternityresponsiblephoto.getText().toString().trim();
                final String xMaternityarea = Maternityarea.getText().toString().trim();
                final String xMaternityrequestedlistofsupplies = Maternityrequestedlistofsupplies.getText().toString().trim();
                final String xMaternitycurrentlistofsupplies = Maternitycurrentlistofsupplies.getText().toString().trim();
                final String xMaternityhygiene = Maternityhygiene.getText().toString().trim();
                final String xMaternityhandhygience = Maternityhandhygience.getText().toString().trim();

                boolean var = myDb.registerMaternityServiceDescription(xyear,xdistrict,xhc,xMaternitydirection,xMaternityservice,xMaternityresponsiblename,xMaternitycurrentdata,xMaternityresponsiblephoto,xMaternityarea,xMaternityrequestedlistofsupplies,xMaternitycurrentlistofsupplies,xMaternityhygiene,xMaternityhandhygience);

                if (var) {
                    Intent intent = new Intent(getBaseContext(), ServiceDescriptionHospitalization.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(ServiceDescriptionMaternity.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}