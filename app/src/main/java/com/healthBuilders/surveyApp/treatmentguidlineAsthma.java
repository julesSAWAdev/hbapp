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

public class treatmentguidlineAsthma extends AppCompatActivity {
    AutoCompleteTextView bpcheck,apptreatment,severeclass;
    TextInputEditText patientid;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button save,close;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_treatmentguidline_asthma);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        myDb = new Databasehelper(this);

        //hooks
        patientid=findViewById(R.id.patientId);
        bpcheck = findViewById(R.id.bpCheck);
        apptreatment = findViewById(R.id.appTreatment);
        severeclass = findViewById(R.id.severeClass);
        save = findViewById(R.id.Save);
        close = findViewById(R.id.Close);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        //set adapters
        bpcheck.setAdapter(adapterDist);
        apptreatment.setAdapter(adapterDist);
        severeclass.setAdapter(adapterDist);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getBaseContext(), tratmentguidelinesAnc.class);
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
                final String xbpcheck= bpcheck.getText().toString().trim();
                final String xapptreatment= apptreatment.getText().toString().trim();
                final String xsevereclass= severeclass.getText().toString().trim();



                boolean var = myDb.registerAsthma(xyear,xdistrict,xhc,xpatientid,xbpcheck,xapptreatment,xsevereclass);
                if (var) {
                    Toast.makeText(treatmentguidlineAsthma.this, "Item recorded", Toast.LENGTH_LONG).show();
                    patientid.setText("");
                    bpcheck.setText("");
                    apptreatment.setText("");
                    severeclass.setText("");
                }else{
                    Toast.makeText(treatmentguidlineAsthma.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });


    }
}