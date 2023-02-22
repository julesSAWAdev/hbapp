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

import java.util.Calendar;

public class generalInformaion2 extends AppCompatActivity {
    AutoCompleteTextView  meetmonth,qifocalperson,qifocalpersonletter,ipcfocalperson,ipcfocalpersonletter,custofocalperson,custofocalpersonletter;
    Button save;
    String[] response = new String[]{ "Yes","No"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_general_informaion2);


        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        meetmonth = findViewById(R.id.meetMonth);
        qifocalperson = findViewById(R.id.qiFocalPerson);
        qifocalpersonletter = findViewById(R.id.qiFocalPersonLetter);
        ipcfocalperson = findViewById(R.id.ipcFocalPerson);
        ipcfocalpersonletter = findViewById(R.id.ipcFocalPersonLetter);
        custofocalperson = findViewById(R.id.custoFocalPerson);
        custofocalpersonletter = findViewById(R.id.custoFocalPersonLetter);
        save = findViewById(R.id.save1);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);


        meetmonth.setAdapter(adapterDist);
        qifocalperson.setAdapter(adapterDist);
        qifocalpersonletter.setAdapter(adapterDist);
        ipcfocalperson.setAdapter(adapterDist);
        ipcfocalpersonletter.setAdapter(adapterDist);
        custofocalperson.setAdapter(adapterDist);
        custofocalpersonletter.setAdapter(adapterDist);

        myDb = new Databasehelper(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear = year;
                final String xdistrict = district;
                final String xhc = hc;
                final String xmeetmonth = meetmonth.getText().toString().trim();
                final String xqifocalperson = qifocalperson.getText().toString().trim();
                final String xqifocalpersonletter = qifocalpersonletter.getText().toString().trim();
                final String xipcfocalperson = ipcfocalperson.getText().toString().trim();
                final String xipcfocalpersonletter = ipcfocalpersonletter.getText().toString().trim();
                final String xcustofocalperson = custofocalperson.getText().toString().trim();
                final String xcustofocalpersonletter = custofocalpersonletter.getText().toString().trim();


                boolean var = myDb.registerGeneralinformation2(xyear, xdistrict, xhc, xmeetmonth,xqifocalperson,xqifocalpersonletter,xipcfocalperson,xipcfocalpersonletter,xcustofocalperson,xcustofocalpersonletter);
                if (var) {
                    Toast.makeText(generalInformaion2.this, "Item recorded", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getBaseContext(), SurveySection.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(generalInformaion2.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });



    }
}