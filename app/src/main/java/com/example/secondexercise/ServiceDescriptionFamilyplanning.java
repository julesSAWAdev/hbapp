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

public class ServiceDescriptionFamilyplanning extends AppCompatActivity {
    AutoCompleteTextView     fpdirection,fpservice,fpresponsiblename,fpcurrentdata,fpresponsiblephoto,fparea,fprequestedlistofsupplies,fpcurrentlistofsupplies,fphygiene,fphandhygience;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description_familyplanning);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);
        //family planning service hook

        fpdirection = findViewById(R.id.fpdirectiontxt);
        fpservice = findViewById(R.id.fpservicelabeltxt);
        fpresponsiblename = findViewById(R.id.fpresponsenametxt);
        fpcurrentdata = findViewById(R.id.fpcurrentdatatxt);
        fpresponsiblephoto = findViewById(R.id.fpresponsiblephototxt);
        fparea = findViewById(R.id.fpareamaintenedtxt);
        fprequestedlistofsupplies = findViewById(R.id.fpsuppliestxt);
        fpcurrentlistofsupplies = findViewById(R.id.fpexisingsuppliestxt);
        fphygiene = findViewById(R.id.fphygienetxt);
        fphandhygience = findViewById(R.id.fphandtxt);

        //family planning adapterlist
        fpdirection.setAdapter(adapterDist);
        fpservice.setAdapter(adapterDist);
        fpresponsiblename.setAdapter(adapterDist);
        fpcurrentdata.setAdapter(adapterDist);
        fpresponsiblephoto.setAdapter(adapterDist);
        fparea.setAdapter(adapterDist);
        fprequestedlistofsupplies.setAdapter(adapterDist);
        fpcurrentlistofsupplies.setAdapter(adapterDist);
        fphygiene.setAdapter(adapterDist);
        fphandhygience.setAdapter(adapterDist);

        saveNext = findViewById(R.id.serviceDescFp);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionPharmacy.class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);

                startActivity(intent);
            }
        });

    }
}