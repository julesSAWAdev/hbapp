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

public class ServiceDescriptionToilets extends AppCompatActivity {
    AutoCompleteTextView Toiletsdirection,Toiletsservice,Toiletsresponsiblename,Toiletscurrentdata,Toiletsresponsiblephoto,Toiletsarea,Toiletsrequestedlistofsupplies,Toiletscurrentlistofsupplies,Toiletshygiene,Toiletshandhygience;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description_toilets);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        Toiletsdirection = findViewById(R.id.Toiletsdirectiontxt);
        Toiletsservice = findViewById(R.id.Toiletsservicelabeltxt);
        Toiletsresponsiblename = findViewById(R.id.Toiletsresponsenametxt);
        Toiletscurrentdata = findViewById(R.id.Toiletscurrentdatatxt);
        Toiletsresponsiblephoto = findViewById(R.id.Toiletsresponsiblephototxt);
        Toiletsarea = findViewById(R.id.Toiletsareamaintenedtxt);
        Toiletsrequestedlistofsupplies = findViewById(R.id.Toiletssuppliestxt);
        Toiletscurrentlistofsupplies = findViewById(R.id.Toiletsexisingsuppliestxt);
        Toiletshygiene = findViewById(R.id.Toiletshygienetxt);
        Toiletshandhygience = findViewById(R.id.Toiletshandtxt);

        //family planning adapterlist
        Toiletsdirection.setAdapter(adapterDist);
        Toiletsservice.setAdapter(adapterDist);
        Toiletsresponsiblename.setAdapter(adapterDist);
        Toiletscurrentdata.setAdapter(adapterDist);
        Toiletsresponsiblephoto.setAdapter(adapterDist);
        Toiletsarea.setAdapter(adapterDist);
        Toiletsrequestedlistofsupplies.setAdapter(adapterDist);
        Toiletscurrentlistofsupplies.setAdapter(adapterDist);
        Toiletshygiene.setAdapter(adapterDist);
        Toiletshandhygience.setAdapter(adapterDist);

        saveNext = findViewById(R.id.serviceDescToilets);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionNoticeboard.class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);

                startActivity(intent);
            }
        });
    }
}