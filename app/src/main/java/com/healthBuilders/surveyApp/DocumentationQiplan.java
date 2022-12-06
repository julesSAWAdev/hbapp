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

public class DocumentationQiplan extends AppCompatActivity {
    AutoCompleteTextView available,tracked,approvedti,approvedcosa,comstaff;
    Button savenext;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_documentation_qiplan);


        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        available=findViewById(R.id.qiavailable);
        tracked=findViewById(R.id.qitrack);
        approvedti=findViewById(R.id.qiapproved);
        approvedcosa=findViewById(R.id.qicosa);
        comstaff=findViewById(R.id.qicommunicated);

        myDb = new Databasehelper(this);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);
        available.setAdapter(adapterDist);
        tracked.setAdapter(adapterDist);
        approvedti.setAdapter(adapterDist);
        approvedcosa.setAdapter(adapterDist);
        comstaff.setAdapter(adapterDist);

        savenext = findViewById(R.id.qinext);

        savenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xavailable=available.getText().toString().trim();
                final String xtracked=tracked.getText().toString().trim();
                final String xapprovedti=approvedti.getText().toString().trim();
                final String xapprovedcosa=approvedcosa.getText().toString().trim();
                final String ccomstaff=comstaff.getText().toString().trim();

                boolean var = myDb.registerDocumentationQiplan(xyear,xdistrict,xhc,xavailable,xtracked,xapprovedti,xapprovedcosa,ccomstaff);
                if (var) {
                    Intent intent = new Intent(getBaseContext(), DocumentationWorkSchedule.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);


                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(DocumentationQiplan.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }


        });
    }
}