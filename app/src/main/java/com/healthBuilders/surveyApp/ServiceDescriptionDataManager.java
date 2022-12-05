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

public class ServiceDescriptionDataManager extends AppCompatActivity {
    AutoCompleteTextView DataManagerdirection,DataManagerservice,DataManagerresponsiblename,DataManagercurrentdata,DataManagerresponsiblephoto,DataManagerarea,DataManagerrequestedlistofsupplies,DataManagercurrentlistofsupplies,DataManagerhygiene,DataManagerhandhygience;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description_data_manager);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        DataManagerdirection = findViewById(R.id.DataManagerdirectiontxt);
        DataManagerservice = findViewById(R.id.DataManagerservicelabeltxt);
        DataManagerresponsiblename = findViewById(R.id.DataManagerresponsenametxt);
        DataManagercurrentdata = findViewById(R.id.DataManagercurrentdatatxt);
        DataManagerresponsiblephoto = findViewById(R.id.DataManagerresponsiblephototxt);
        DataManagerarea = findViewById(R.id.DataManagerareamaintenedtxt);
        DataManagerrequestedlistofsupplies = findViewById(R.id.DataManagersuppliestxt);
        DataManagercurrentlistofsupplies = findViewById(R.id.DataManagerexisingsuppliestxt);
        DataManagerhygiene = findViewById(R.id.DataManagerhygienetxt);
        DataManagerhandhygience = findViewById(R.id.DataManagerhandtxt);

        //family planning adapterlist
        DataManagerdirection.setAdapter(adapterDist);
        DataManagerservice.setAdapter(adapterDist);
        DataManagerresponsiblename.setAdapter(adapterDist);
        DataManagercurrentdata.setAdapter(adapterDist);
        DataManagerresponsiblephoto.setAdapter(adapterDist);
        DataManagerarea.setAdapter(adapterDist);
        DataManagerrequestedlistofsupplies.setAdapter(adapterDist);
        DataManagercurrentlistofsupplies.setAdapter(adapterDist);
        DataManagerhygiene.setAdapter(adapterDist);
        DataManagerhandhygience.setAdapter(adapterDist);

        myDb = new Databasehelper(this);

        saveNext = findViewById(R.id.serviceDescDataManager);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xDataManagerdirection = DataManagerdirection.getText().toString().trim();
                final String xDataManagerservice = DataManagerservice.getText().toString().trim();
                final String xDataManagerresponsiblename = DataManagerresponsiblename.getText().toString().trim();
                final String xDataManagercurrentdata = DataManagercurrentdata.getText().toString().trim();
                final String xDataManagerresponsiblephoto = DataManagerresponsiblephoto.getText().toString().trim();
                final String xDataManagerarea = DataManagerarea.getText().toString().trim();
                final String xDataManagerrequestedlistofsupplies = DataManagerrequestedlistofsupplies.getText().toString().trim();
                final String xDataManagercurrentlistofsupplies = DataManagercurrentlistofsupplies.getText().toString().trim();
                final String xDataManagerhygiene = DataManagerhygiene.getText().toString().trim();
                final String xDataManagerhandhygience = DataManagerhandhygience.getText().toString().trim();

                boolean var = myDb.registerDataManagerServiceDescription(xyear,xdistrict,xhc,xDataManagerdirection,xDataManagerservice,xDataManagerresponsiblename,xDataManagercurrentdata,xDataManagerresponsiblephoto,xDataManagerarea,xDataManagerrequestedlistofsupplies,xDataManagercurrentlistofsupplies,xDataManagerhygiene,xDataManagerhandhygience);
                if (var) {
                    Intent intent = new Intent(getBaseContext(), ServiceDescriptionArv.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(ServiceDescriptionDataManager.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}