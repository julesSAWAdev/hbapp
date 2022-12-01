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

public class ServiceDescriptionLaboratory extends AppCompatActivity {
    AutoCompleteTextView laboratorydirection,laboratoryservice,laboratoryresponsiblename,laboratorycurrentdata,laboratoryresponsiblephoto,laboratoryarea,laboratoryrequestedlistofsupplies,laboratorycurrentlistofsupplies,laboratoryhygiene,laboratoryhandhygience;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description_laboratory);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        laboratorydirection = findViewById(R.id.laboratorydirectiontxt);
        laboratoryservice = findViewById(R.id.laboratoryservicelabeltxt);
        laboratoryresponsiblename = findViewById(R.id.laboratoryresponsenametxt);
        laboratorycurrentdata = findViewById(R.id.laboratorycurrentdatatxt);
        laboratoryresponsiblephoto = findViewById(R.id.laboratoryresponsiblephototxt);
        laboratoryarea = findViewById(R.id.laboratoryareamaintenedtxt);
        laboratoryrequestedlistofsupplies = findViewById(R.id.laboratorysuppliestxt);
        laboratorycurrentlistofsupplies = findViewById(R.id.laboratoryexisingsuppliestxt);
        laboratoryhygiene = findViewById(R.id.laboratoryhygienetxt);
        laboratoryhandhygience = findViewById(R.id.laboratoryhandtxt);

        //family planning adapterlist
        laboratorydirection.setAdapter(adapterDist);
        laboratoryservice.setAdapter(adapterDist);
        laboratoryresponsiblename.setAdapter(adapterDist);
        laboratorycurrentdata.setAdapter(adapterDist);
        laboratoryresponsiblephoto.setAdapter(adapterDist);
        laboratoryarea.setAdapter(adapterDist);
        laboratoryrequestedlistofsupplies.setAdapter(adapterDist);
        laboratorycurrentlistofsupplies.setAdapter(adapterDist);
        laboratoryhygiene.setAdapter(adapterDist);
        laboratoryhandhygience.setAdapter(adapterDist);

        saveNext = findViewById(R.id.serviceDesclaboratory);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionTitulaire.class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);

                startActivity(intent);
            }
        });
    }
}