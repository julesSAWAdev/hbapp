package com.healthBuilders.surveyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class AdmittedPatientsAsthma extends AppCompatActivity {
    TextInputEditText patientid,month1,month2,month3,month4,month5,month6;
    Button save,close;
    String[] response = new String[]{ "Yes","No"};
    Calendar myCalendar;
    private ProgressDialog progressDialog;
    private Databasehelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_admitted_patients_asthma);

        Intent intent = getIntent();
        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");
        final String section = getIntent().getStringExtra("section");


        patientid = findViewById(R.id.patientid);
        month1 = findViewById(R.id.Month1);
        month2 = findViewById(R.id.Month2);
        month3 = findViewById(R.id.Month3);
        month4 = findViewById(R.id.Month4);
        month5 = findViewById(R.id.Month5);
        month6 = findViewById(R.id.Month6);

        save = findViewById(R.id.save);
        close = findViewById(R.id.close);

        myDb = new Databasehelper(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear = year;
                final String xdistrict = district;
                final String xhc = hc;
                final String xpatientid = patientid.getText().toString().trim();
                final String xmonth1 = month1.getText().toString().trim();
                final String xmonth2 = month2.getText().toString().trim();
                final String xmonth3 = month3.getText().toString().trim();
                final String xmonth4 = month4.getText().toString().trim();
                final String xmonth5 = month5.getText().toString().trim();
                final String xmonth6 = month6.getText().toString().trim();


                boolean var = myDb.registerAdmittedPatientsAsthma(xyear, xdistrict, xhc, xpatientid, xmonth1, xmonth2, xmonth3, xmonth4, xmonth5, xmonth6);
                if (var) {
                    Toast.makeText(AdmittedPatientsAsthma.this, "Item recorded", Toast.LENGTH_LONG).show();
                    patientid.setText("");
                    month1.setText("");
                    month2.setText("");
                    month3.setText("");
                    month4.setText("");
                    month5.setText("");
                    month6.setText("");
                } else {
                    Toast.makeText(AdmittedPatientsAsthma.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), commentSection1.class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);
                intent.putExtra("section", section);


                startActivity(intent);
            }
        });
    }
}