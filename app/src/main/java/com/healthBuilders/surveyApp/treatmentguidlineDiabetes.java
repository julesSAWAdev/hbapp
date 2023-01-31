package com.healthBuilders.surveyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class treatmentguidlineDiabetes extends AppCompatActivity {
    AutoCompleteTextView weightcheck,currentprotocal,bpcheck,eyecheck,procheck,crecheck,footcheck;
    TextInputEditText patientid;
    Button save,close;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_treatmentguidline_diabetes);


        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        myDb = new Databasehelper(this);

        //hooks
        patientid=findViewById(R.id.patientId);
        weightcheck = findViewById(R.id.weightCheck);
        currentprotocal = findViewById(R.id.currentProtocol);
        bpcheck = findViewById(R.id.bpCheck);
        eyecheck = findViewById(R.id.eyeCheck);
        procheck = findViewById(R.id.proCheck);
        crecheck = findViewById(R.id.creCheck);
        footcheck = findViewById(R.id.footCheck);
        save = findViewById(R.id.Save);
        close = findViewById(R.id.Close);

        //adapter
        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        //set adapters
        weightcheck.setAdapter(adapterDist);
        currentprotocal.setAdapter(adapterDist);
        bpcheck.setAdapter(adapterDist);
        eyecheck.setAdapter(adapterDist);
        procheck.setAdapter(adapterDist);
        crecheck.setAdapter(adapterDist);
        footcheck.setAdapter(adapterDist);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getBaseContext(), treatmentguidlineAsthma.class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);

                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xpatientid= patientid.getText().toString().trim();
                final String xweightcheck= weightcheck.getText().toString().trim();
                final String xcurrentprotocal= currentprotocal.getText().toString().trim();
                final String xbpcheck= bpcheck.getText().toString().trim();
                final String xeyecheck= eyecheck.getText().toString().trim();
                final String xprocheck= procheck.getText().toString().trim();
                final String xcrecheck= crecheck.getText().toString().trim();
                final String xfootcheck= footcheck.getText().toString().trim();


                boolean var = myDb.registerTGdiabetes(xyear,xdistrict,xhc,xpatientid,xweightcheck,xcurrentprotocal,xbpcheck,xeyecheck,xprocheck,xcrecheck,xfootcheck);
                if (var) {
                    Toast.makeText(treatmentguidlineDiabetes.this, "Item recorded", Toast.LENGTH_LONG).show();
                    patientid.setText("");
                    weightcheck.setText("");
                    currentprotocal.setText("");
                    bpcheck.setText("");
                    eyecheck.setText("");
                    procheck.setText("");
                    crecheck.setText("");
                    footcheck.setText("");
                }else{
                    Toast.makeText(treatmentguidlineDiabetes.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}