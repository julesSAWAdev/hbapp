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

public class referralProcess extends AppCompatActivity {
    AutoCompleteTextView reason,findings,procedures,immediatecondition,patienttransferedto,feedback,
            referalsheets,standardform,transport;
    TextInputEditText patientid;
    Button save,close;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_referral_process);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        myDb = new Databasehelper(this);

        //hooks
        patientid=findViewById(R.id.patientId);
        reason=findViewById(R.id.Reason);
        findings=findViewById(R.id.Findings);
        procedures=findViewById(R.id.Procedures);
        immediatecondition=findViewById(R.id.immediateCondition);
        patienttransferedto=findViewById(R.id.patientTransferedTo);
        feedback=findViewById(R.id.Feedback);
        referalsheets=findViewById(R.id.referalSheets);
        standardform=findViewById(R.id.standardForm);
        transport=findViewById(R.id.Transport);
        save=findViewById(R.id.Savebtn);
        close=findViewById(R.id.Closebtn);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        //set adapters
        reason.setAdapter(adapterDist);
        findings.setAdapter(adapterDist);
        procedures.setAdapter(adapterDist);
        immediatecondition.setAdapter(adapterDist);
        patienttransferedto.setAdapter(adapterDist);
        feedback.setAdapter(adapterDist);
        referalsheets.setAdapter(adapterDist);
        standardform.setAdapter(adapterDist);
        transport.setAdapter(adapterDist);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xreason = reason.getText().toString().trim();
                final String xfindings = findings.getText().toString().trim();
                final String xprocedures = procedures.getText().toString().trim();
                final String ximmediatecondition = immediatecondition.getText().toString().trim();
                final String xpatienttransferedto = patienttransferedto.getText().toString().trim();
                final String xfeedback = feedback.getText().toString().trim();
                final String xreferalsheets = referalsheets.getText().toString().trim();
                final String xstandardform = standardform.getText().toString().trim();
                final String xtransport = transport.getText().toString().trim();



                boolean var = myDb.registerReferal(xyear,xdistrict,xhc,xreason,xfindings,xprocedures,ximmediatecondition,xpatienttransferedto,xfeedback,xreferalsheets,xstandardform,xtransport);
                if (var) {
                    Toast.makeText(referralProcess.this, "Item recorded", Toast.LENGTH_LONG).show();
                    patientid.setText("");
                    reason.setText("");
                    findings.setText("");
                    procedures.setText("");
                    immediatecondition.setText("");
                    patienttransferedto.setText("");
                    feedback.setText("");
                    referalsheets.setText("");
                    standardform.setText("");
                    transport.setText("");
                }else{
                    Toast.makeText(referralProcess.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(), outpatientMalaria .class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                startActivity(intent);
            }
        });


    }
}