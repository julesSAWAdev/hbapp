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

public class safetyManagement extends AppCompatActivity {
    AutoCompleteTextView rightsposted,infection,satisfactiontool,satisfactiondata,suggestionbox,qiincident,annualhazard,
                        ppe,staffppe,staffsatisfactiontool,incidenttool,asrh,staffsatisfactiondata;

    TextInputEditText patientincidents,patientincidentanalyzed,numberhazards,numberhazardsfixed;

    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;

    Button savenext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_safety_management);

        Intent intent = getIntent();
        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        rightsposted=findViewById(R.id.rightPosted);
        infection=findViewById(R.id.Infection);
        satisfactiontool=findViewById(R.id.satisfactionTool);
        satisfactiondata=findViewById(R.id.satisfactionData);
        suggestionbox=findViewById(R.id.suggestionBox);
        qiincident=findViewById(R.id.qiIncident);
        annualhazard=findViewById(R.id.annualHazard);
        ppe=findViewById(R.id.ppe);
        staffppe=findViewById(R.id.staffPpe);
        staffsatisfactiontool=findViewById(R.id.staffSatisfactionTool);
        incidenttool=findViewById(R.id.incidentTool);
        asrh=findViewById(R.id.asrh);
        staffsatisfactiondata=findViewById(R.id.staffSatisfactionData);

        patientincidents=findViewById(R.id.patientsIncident);
        patientincidentanalyzed=findViewById(R.id.patientsIncidentAnalyzed);
        numberhazards=findViewById(R.id.numberHazards);
        numberhazardsfixed=findViewById(R.id.numberHazardsFixed);

        savenext=findViewById(R.id.saveNext);


        //adapter
        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        //set adapters
        rightsposted.setAdapter(adapterDist);
        infection.setAdapter(adapterDist);
        satisfactiontool.setAdapter(adapterDist);
        satisfactiondata.setAdapter(adapterDist);
        suggestionbox.setAdapter(adapterDist);
        qiincident.setAdapter(adapterDist);
        annualhazard.setAdapter(adapterDist);
        ppe.setAdapter(adapterDist);
        staffppe.setAdapter(adapterDist);
        staffsatisfactiontool.setAdapter(adapterDist);
        incidenttool.setAdapter(adapterDist);
        asrh.setAdapter(adapterDist);
        staffsatisfactiondata.setAdapter(adapterDist);
        myDb = new Databasehelper(this);


        savenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xrightsposted=rightsposted.getText().toString().trim();
                final String xinfection=infection.getText().toString().trim();
                final String xsatisfactiontool=satisfactiontool.getText().toString().trim();
                final String xsatisfactiondata=satisfactiondata.getText().toString().trim();
                final String xsuggestionbox=suggestionbox.getText().toString().trim();
                final String xqiincident=qiincident.getText().toString().trim();
                final String xannualhazard=annualhazard.getText().toString().trim();
                final String xppe=ppe.getText().toString().trim();
                final String xstaffppe=staffppe.getText().toString().trim();
                final String xstaffsatisfactiontool=staffsatisfactiontool.getText().toString().trim();
                final String xincidenttool=incidenttool.getText().toString().trim();
                final String xasrh=asrh.getText().toString().trim();
                final String xstaffsatisfactiondata=staffsatisfactiondata.getText().toString().trim();

                final String xpatientincidents=patientincidents.getText().toString().trim();
                final String xpatientincidentanalyzed=patientincidentanalyzed.getText().toString().trim();
                final String xnumberhazards=numberhazards.getText().toString().trim();
                final String xnumberhazardsfixed=numberhazardsfixed.getText().toString().trim();

                boolean var = myDb.RegisterSafetyManagement(xyear,xdistrict,xhc,xrightsposted,xinfection,xsatisfactiontool,xsatisfactiondata,xsuggestionbox,xqiincident,xannualhazard,xppe,xstaffppe,xstaffsatisfactiontool,xincidenttool,xasrh,xstaffsatisfactiondata,xpatientincidents,xpatientincidentanalyzed,xnumberhazards,xnumberhazardsfixed);
                if (var) {


                    Intent intent = new Intent(getBaseContext(), healthEducation.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                    startActivity(intent);
                }else{
                    Toast.makeText(safetyManagement.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });



    }
}