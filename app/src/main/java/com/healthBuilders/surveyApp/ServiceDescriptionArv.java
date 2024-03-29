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

public class ServiceDescriptionArv extends AppCompatActivity {
    AutoCompleteTextView Arvdirection,Arvservice,Arvresponsiblename,Arvcurrentdata,Arvresponsiblephoto,Arvarea,Arvrequestedlistofsupplies,Arvcurrentlistofsupplies,Arvhygiene,Arvhandhygience;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description_arv);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");
        final String section = getIntent().getStringExtra("section");


        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        Arvdirection = findViewById(R.id.Arvdirectiontxt);
        Arvservice = findViewById(R.id.Arvservicelabeltxt);
        Arvresponsiblename = findViewById(R.id.Arvresponsenametxt);
        Arvcurrentdata = findViewById(R.id.Arvcurrentdatatxt);
        Arvresponsiblephoto = findViewById(R.id.Arvresponsiblephototxt);
        Arvarea = findViewById(R.id.Arvareamaintenedtxt);
        Arvrequestedlistofsupplies = findViewById(R.id.Arvsuppliestxt);
        Arvcurrentlistofsupplies = findViewById(R.id.Arvexisingsuppliestxt);
        Arvhygiene = findViewById(R.id.Arvhygienetxt);
        Arvhandhygience = findViewById(R.id.Arvhandtxt);

        //family planning adapterlist
        Arvdirection.setAdapter(adapterDist);
        Arvservice.setAdapter(adapterDist);
        Arvresponsiblename.setAdapter(adapterDist);
        Arvcurrentdata.setAdapter(adapterDist);
        Arvresponsiblephoto.setAdapter(adapterDist);
        Arvarea.setAdapter(adapterDist);
        Arvrequestedlistofsupplies.setAdapter(adapterDist);
        Arvcurrentlistofsupplies.setAdapter(adapterDist);
        Arvhygiene.setAdapter(adapterDist);
        Arvhandhygience.setAdapter(adapterDist);

        myDb = new Databasehelper(this);

        saveNext = findViewById(R.id.serviceDescArv);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xArvdirection = Arvdirection.getText().toString().trim();
                final String xArvservice = Arvservice.getText().toString().trim();
                final String xArvresponsiblename = Arvresponsiblename.getText().toString().trim();
                final String xArvcurrentdata = Arvcurrentdata.getText().toString().trim();
                final String xArvresponsiblephoto = Arvresponsiblephoto.getText().toString().trim();
                final String xArvarea = Arvarea.getText().toString().trim();
                final String xArvrequestedlistofsupplies = Arvrequestedlistofsupplies.getText().toString().trim();
                final String xArvcurrentlistofsupplies = Arvcurrentlistofsupplies.getText().toString().trim();
                final String xArvhygiene = Arvhygiene.getText().toString().trim();
                final String xArvhandhygience = Arvhandhygience.getText().toString().trim();

                boolean var = myDb.registerArvServiceDescription(xyear,xdistrict,xhc,xArvdirection,xArvservice,xArvresponsiblename,xArvcurrentdata,xArvresponsiblephoto,xArvarea,xArvrequestedlistofsupplies,xArvcurrentlistofsupplies,xArvhygiene,xArvhandhygience);

                if (var) {
                    Intent intent = new Intent(getBaseContext(), Services.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);
                    intent.putExtra("section", section);


                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(ServiceDescriptionArv.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}