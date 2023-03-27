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

public class tratmentguidelinesAnc extends AppCompatActivity {
    AutoCompleteTextView nationalanc,patienthistory,bpcheck,urinecheck,hemoglobincheck,rprcheck,ultracheck;
    TextInputEditText patientid;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button save,close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tratmentguidelines_anc);


        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");
        final String section = getIntent().getStringExtra("section");


        myDb = new Databasehelper(this);

        //hooks
        patientid=findViewById(R.id.patientId);
        nationalanc = findViewById(R.id.nationalAnc);
        patienthistory = findViewById(R.id.patientHistory);
        bpcheck = findViewById(R.id.bpCheck);
        urinecheck = findViewById(R.id.urinecheck);
        hemoglobincheck = findViewById(R.id.hemoglobinCheck);
        rprcheck = findViewById(R.id.rprCheck);
        ultracheck = findViewById(R.id.ultraCheck);
        save = findViewById(R.id.Save);
        close = findViewById(R.id.Close);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        //set adapters
        nationalanc.setAdapter(adapterDist);
        patienthistory.setAdapter(adapterDist);
        bpcheck.setAdapter(adapterDist);
        urinecheck.setAdapter(adapterDist);
        hemoglobincheck.setAdapter(adapterDist);
        rprcheck.setAdapter(adapterDist);
        ultracheck.setAdapter(adapterDist);


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getBaseContext(), treatmentguidelinesOverall.class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);
                intent.putExtra("section", section);


                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xpatientid = patientid.getText().toString().trim();
                final String xnationalanc = nationalanc.getText().toString().trim();
                final String xpatienthistory = patienthistory.getText().toString().trim();
                final String xbpcheck = bpcheck.getText().toString().trim();
                final String xurinecheck = urinecheck.getText().toString().trim();
                final String xhemoglobincheck = hemoglobincheck.getText().toString().trim();
                final String xrprcheck = rprcheck.getText().toString().trim();
                final String xultracheck = ultracheck.getText().toString().trim();



                boolean var = myDb.registerAnc(xyear,xdistrict,xhc,xnationalanc,xpatientid,xpatienthistory,xbpcheck,xurinecheck,xhemoglobincheck,xrprcheck,xultracheck);
                if (var) {
                    Toast.makeText(tratmentguidelinesAnc.this, "Item recorded", Toast.LENGTH_LONG).show();
                    patientid.setText("");
                    nationalanc.setText("");
                    patienthistory.setText("");
                    bpcheck.setText("");
                    urinecheck.setText("");
                    hemoglobincheck.setText("");
                    rprcheck.setText("");
                    ultracheck.setText("");
                }else{
                    Toast.makeText(tratmentguidelinesAnc.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}