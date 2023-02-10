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

public class ServiceDescriptionToilets extends AppCompatActivity {
    AutoCompleteTextView Toiletsdirection,Toiletsarea,Toiletshygiene,Toiletshandhygience;
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
        Toiletsarea = findViewById(R.id.Toiletsareamaintenedtxt);
        Toiletshygiene = findViewById(R.id.Toiletshygienetxt);
        Toiletshandhygience = findViewById(R.id.Toiletshandtxt);

        //family planning adapterlist
        Toiletsdirection.setAdapter(adapterDist);
        Toiletsarea.setAdapter(adapterDist);
        Toiletshygiene.setAdapter(adapterDist);
        Toiletshandhygience.setAdapter(adapterDist);

        myDb = new Databasehelper(this);

        saveNext = findViewById(R.id.serviceDescToilets);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xToiletsdirection = Toiletsdirection.getText().toString().trim();
                final String xToiletsarea = Toiletsarea.getText().toString().trim();
                 final String xToiletshygiene = Toiletshygiene.getText().toString().trim();
                final String xToiletshandhygience = Toiletshandhygience.getText().toString().trim();

                boolean var = myDb.registerToiletsServiceDescription(xyear,xdistrict,xhc,xToiletsdirection,xToiletsarea,xToiletshygiene,xToiletshandhygience);

                if (var) {
                    Toast.makeText(ServiceDescriptionToilets.this, "Data recorded", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getBaseContext(), Services.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(ServiceDescriptionToilets.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}