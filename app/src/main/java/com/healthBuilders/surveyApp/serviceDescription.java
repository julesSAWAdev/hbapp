package com.healthBuilders.surveyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

public class serviceDescription extends AppCompatActivity {
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    AutoCompleteTextView ancdirection,ancservice,ancresponsiblename,anccurrentdata,ancresponsiblephoto,ancarea,ancrequestedlistofsupplies,anccurrentlistofsupplies,anchygiene,anchandhygience;
    Button saveNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        //anc service hook
        ancdirection = findViewById(R.id.ancdirectiontxt);
        ancservice = findViewById(R.id.ancservicelabeltxt);
        ancresponsiblename = findViewById(R.id.ancresponsenametxt);
        anccurrentdata = findViewById(R.id.anccurrentdatatxt);
        ancresponsiblephoto = findViewById(R.id.ancresponsiblephototxt);
        ancarea = findViewById(R.id.ancareamaintenedtxt);
        ancrequestedlistofsupplies = findViewById(R.id.ancsuppliestxt);
        anccurrentlistofsupplies = findViewById(R.id.ancexisingsuppliestxt);
        anchygiene = findViewById(R.id.anchygienetxt);
        anchandhygience = findViewById(R.id.anchandtxt);

        //set adapter
        ancdirection.setAdapter(adapterDist);
        ancservice.setAdapter(adapterDist);
        ancresponsiblename.setAdapter(adapterDist);
        anccurrentdata.setAdapter(adapterDist);
        ancresponsiblephoto.setAdapter(adapterDist);
        ancarea.setAdapter(adapterDist);
        ancrequestedlistofsupplies.setAdapter(adapterDist);
        anccurrentlistofsupplies.setAdapter(adapterDist);
        anchygiene.setAdapter(adapterDist);
        anchandhygience.setAdapter(adapterDist);

        myDb = new Databasehelper(this);
        saveNext = findViewById(R.id.serviceDesc);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xancdirection = ancdirection.getText().toString().trim();
                final String xancservice = ancservice.getText().toString().trim();
                final String xancresponsiblename = ancresponsiblename.getText().toString().trim();
                final String xanccurrentdata = anccurrentdata.getText().toString().trim();
                final String xancresponsiblephoto = ancresponsiblephoto.getText().toString().trim();
                final String xancarea = ancarea.getText().toString().trim();
                final String xancrequestedlistofsupplies = ancrequestedlistofsupplies.getText().toString().trim();
                final String xanccurrentlistofsupplies = anccurrentlistofsupplies.getText().toString().trim();
                final String xanchygiene = anchygiene.getText().toString().trim();
                final String xanchandhygience = anchandhygience.getText().toString().trim();




                boolean var = myDb.registerAncServiceDescription(xyear,xdistrict,xhc,xancdirection,xancservice,xancresponsiblename,xanccurrentdata,xancresponsiblephoto,xancarea,xancrequestedlistofsupplies,xanccurrentlistofsupplies,xanchygiene,xanchandhygience);
                if (var){
                    Toast.makeText(serviceDescription.this,"Data added successfuly",Toast.LENGTH_SHORT);
                    Intent intent = new Intent(getBaseContext(), ServiceDescriptionVaccination.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(serviceDescription.this, "An error occured", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }


}