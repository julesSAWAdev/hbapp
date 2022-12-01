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

public class ServiceDescriptionTitulaire extends AppCompatActivity {
    AutoCompleteTextView titulairedirection,titulaireservice,titulaireresponsiblename,titulairecurrentdata,titulaireresponsiblephoto,titulairearea,titulairerequestedlistofsupplies,titulairecurrentlistofsupplies,titulairehygiene,titulairehandhygience;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description_titulaire);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        titulairedirection = findViewById(R.id.titulairedirectiontxt);
        titulaireservice = findViewById(R.id.titulaireservicelabeltxt);
        titulaireresponsiblename = findViewById(R.id.titulaireresponsenametxt);
        titulairecurrentdata = findViewById(R.id.titulairecurrentdatatxt);
        titulaireresponsiblephoto = findViewById(R.id.titulaireresponsiblephototxt);
        titulairearea = findViewById(R.id.titulaireareamaintenedtxt);
        titulairerequestedlistofsupplies = findViewById(R.id.titulairesuppliestxt);
        titulairecurrentlistofsupplies = findViewById(R.id.titulaireexisingsuppliestxt);
        titulairehygiene = findViewById(R.id.titulairehygienetxt);
        titulairehandhygience = findViewById(R.id.titulairehandtxt);

        //family planning adapterlist
        titulairedirection.setAdapter(adapterDist);
        titulaireservice.setAdapter(adapterDist);
        titulaireresponsiblename.setAdapter(adapterDist);
        titulairecurrentdata.setAdapter(adapterDist);
        titulaireresponsiblephoto.setAdapter(adapterDist);
        titulairearea.setAdapter(adapterDist);
        titulairerequestedlistofsupplies.setAdapter(adapterDist);
        titulairecurrentlistofsupplies.setAdapter(adapterDist);
        titulairehygiene.setAdapter(adapterDist);
        titulairehandhygience.setAdapter(adapterDist);

        saveNext = findViewById(R.id.serviceDesctitulaire);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionDataManager.class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);

                startActivity(intent);
            }
        });
    }
}