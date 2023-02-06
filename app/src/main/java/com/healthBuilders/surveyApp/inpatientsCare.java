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

public class inpatientsCare extends AppCompatActivity {
    TextInputEditText patinetid;
    AutoCompleteTextView assessmentchecklist,biographicaldata,relevanthistory,chiefcomplaint,rapidsurvey,vitalsigns,
    examsytem,diagnosis,nursingplan,soapnote,treatmanetplan,complete;
    Button save,close;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_inpatients_care);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        myDb = new Databasehelper(this);

        patinetid=findViewById(R.id.patientId);
        assessmentchecklist=findViewById(R.id.assessmentChecklist);
        biographicaldata=findViewById(R.id.biographicalData);
        relevanthistory=findViewById(R.id.relevanHistory);
        chiefcomplaint=findViewById(R.id.chiefComplaints);
        rapidsurvey=findViewById(R.id.rapidSurvey);
        vitalsigns=findViewById(R.id.vitalSigns);
        examsytem=findViewById(R.id.examSystem);
        diagnosis=findViewById(R.id.diagnosis);
        nursingplan=findViewById(R.id.nursingPlan);
        soapnote=findViewById(R.id.soapNote);
        treatmanetplan=findViewById(R.id.treatmentPlan);
        complete=findViewById(R.id.complete);
        close=findViewById(R.id.close);
        save=findViewById(R.id.save);


        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        //set adapters
        assessmentchecklist.setAdapter(adapterDist);
        biographicaldata.setAdapter(adapterDist);
        relevanthistory.setAdapter(adapterDist);
        chiefcomplaint.setAdapter(adapterDist);
        rapidsurvey.setAdapter(adapterDist);
        vitalsigns.setAdapter(adapterDist);
        examsytem.setAdapter(adapterDist);
        diagnosis.setAdapter(adapterDist);
        nursingplan.setAdapter(adapterDist);
        soapnote.setAdapter(adapterDist);
        treatmanetplan.setAdapter(adapterDist);
        complete.setAdapter(adapterDist);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xpatientid = patinetid.getText().toString().trim();
                final String xassessmentchecklist = assessmentchecklist.getText().toString().trim();
                final String xbiographicaldata = biographicaldata.getText().toString().trim();
                final String xrelevanthistory = relevanthistory.getText().toString().trim();
                final String xchiefcomplaint = chiefcomplaint.getText().toString().trim();
                final String xrapidsurvey = rapidsurvey.getText().toString().trim();
                final String xvitalsigns = vitalsigns.getText().toString().trim();
                final String xexamsytem = examsytem.getText().toString().trim();
                final String xdiagnosis = diagnosis.getText().toString().trim();
                final String xnursingplan = nursingplan.getText().toString().trim();
                final String xsoapnote = soapnote.getText().toString().trim();
                final String xtreatmanetplan = treatmanetplan.getText().toString().trim();
                final String xcomplete = complete.getText().toString().trim();



                boolean var = myDb.registerInpatientCare(xyear,xdistrict,xhc,xpatientid,xassessmentchecklist,xbiographicaldata,xrelevanthistory,xchiefcomplaint,xrapidsurvey,xvitalsigns,xexamsytem,xdiagnosis,xnursingplan,xsoapnote,xtreatmanetplan,xcomplete);
                if (var) {
                    Toast.makeText(inpatientsCare.this, "Item recorded", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(inpatientsCare.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), keyIndicators .class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                    startActivity(intent);
             }
        });

    }
}