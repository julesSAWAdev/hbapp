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

public class outpatientPnemonia extends AppCompatActivity {
    AutoCompleteTextView assesment,classification,correcttreatment,patienteducated,followup;
    TextInputEditText patientid;
    Button save,close;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_outpatient_pnemonia);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");
        final String section = getIntent().getStringExtra("section");


        myDb = new Databasehelper(this);

        //hooks
        patientid=findViewById(R.id.patientId);
        assesment=findViewById(R.id.Assesment);
        classification=findViewById(R.id.Classification);
        correcttreatment=findViewById(R.id.correctTreatment);
        patienteducated=findViewById(R.id.patientEducated);
        followup=findViewById(R.id.followUP);
        save=findViewById(R.id.Savebtn);
        close=findViewById(R.id.Closebtn);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        //set adapters
        assesment.setAdapter(adapterDist);
        classification.setAdapter(adapterDist);
        correcttreatment.setAdapter(adapterDist);
        patienteducated.setAdapter(adapterDist);
        followup.setAdapter(adapterDist);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xpatientid = patientid.getText().toString().trim();
                final String xassesment = assesment.getText().toString().trim();
                final String xclassification = classification.getText().toString().trim();
                final String xcorrecttreatment = correcttreatment.getText().toString().trim();
                final String xpatienteducated = patienteducated.getText().toString().trim();
                final String xfollowup = followup.getText().toString().trim();



                boolean var = myDb.registerOutPnemonia(xyear,xdistrict,xhc,xpatientid,xassesment,xclassification,xcorrecttreatment,xpatienteducated,xfollowup);
                if (var) {
                    Toast.makeText(outpatientPnemonia.this, "Item recorded", Toast.LENGTH_LONG).show();
                    patientid.setText("");
                    assesment.setText("");
                    classification.setText("");
                    correcttreatment.setText("");
                    patienteducated.setText("");
                    followup.setText("");
                }else{
                    Toast.makeText(outpatientPnemonia.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), outpatientDiarhea .class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);
                intent.putExtra("section", section);


                startActivity(intent);
            }
        });
    }
}