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

public class DocumentationBusinessPlan extends AppCompatActivity {
    AutoCompleteTextView available,tracked,approvedti,comstaff;
    Button savenext;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_documentation_business_plan);
        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");
        final String section = getIntent().getStringExtra("section");


        available=findViewById(R.id.bplanavailable);
        tracked=findViewById(R.id.bplantrack);
        approvedti=findViewById(R.id.bplanapproved);
        comstaff=findViewById(R.id.bplancommunicated);

        myDb = new Databasehelper(this);
        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);
        available.setAdapter(adapterDist);
        tracked.setAdapter(adapterDist);
        approvedti.setAdapter(adapterDist);
        comstaff.setAdapter(adapterDist);

        savenext = findViewById(R.id.bplannext);

        savenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xavailable=available.getText().toString().trim();
                final String xtracked=tracked.getText().toString().trim();
                final String xapprovedti=approvedti.getText().toString().trim();
                final String ccomstaff=comstaff.getText().toString().trim();
                boolean var = myDb.registerDocumentationBusinessPlan(xyear,xdistrict,xhc,xavailable,xtracked,xapprovedti,ccomstaff);
                if (var) {
                    Toast.makeText(DocumentationBusinessPlan.this, "Data recorded", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getBaseContext(), DocumentationBudget.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);
                    intent.putExtra("section", section);


                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(DocumentationBusinessPlan.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }


        });


    }
}