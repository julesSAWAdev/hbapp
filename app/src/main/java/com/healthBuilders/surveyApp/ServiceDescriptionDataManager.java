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

        saveNext = findViewById(R.id.serviceDescDataManager);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionArv.class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);

                startActivity(intent);
            }
        });
    }
}