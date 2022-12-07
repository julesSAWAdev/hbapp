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

public class DocumentationSanitation extends AppCompatActivity {
    AutoCompleteTextView stafflatrines,patientlatrines,totallatrines,brokenlatrines,cleanlatrines,odorlesslatrines,handwashlatrines,
    scheduledlatrines,opd,hosprooms;
    Button savenext;
    private ProgressDialog progressDialog;
    private Databasehelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_documentation_sanitation);


        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        stafflatrines=findViewById(R.id.customeravailable);
        patientlatrines=findViewById(R.id.customertrack);
        totallatrines=findViewById(R.id.customerapproved);
        brokenlatrines=findViewById(R.id.customerapproved);
        cleanlatrines=findViewById(R.id.customerapproved);
        odorlesslatrines=findViewById(R.id.customerapproved);
        handwashlatrines=findViewById(R.id.customerapproved);
        scheduledlatrines=findViewById(R.id.customerapproved);
        opd=findViewById(R.id.customerapproved);
        hosprooms=findViewById(R.id.customerapproved);

        savenext=findViewById(R.id.saniNext);

        myDb = new Databasehelper(this);

        savenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xstafflatrines=stafflatrines.getText().toString().trim();
                final String xpatientlatrines=patientlatrines.getText().toString().trim();
                final String xtotallatrines=totallatrines.getText().toString().trim();
                final String xbrokenlatrines=brokenlatrines.getText().toString().trim();
                final String xcleanlatrines=cleanlatrines.getText().toString().trim();
                final String xodorlesslatrines=odorlesslatrines.getText().toString().trim();
                final String xhandwashlatrines=handwashlatrines.getText().toString().trim();
                final String xscheduledlatrines=scheduledlatrines.getText().toString().trim();
                final String xopd=opd.getText().toString().trim();
                final String xhosprooms=hosprooms.getText().toString().trim();

                boolean var = myDb.registerDocumentationSanitation(xyear,xdistrict,xhc,xstafflatrines,xpatientlatrines,xtotallatrines,xbrokenlatrines,xcleanlatrines,xodorlesslatrines,xhandwashlatrines,xscheduledlatrines,xopd,xhosprooms);
                if (var) {


                    Intent intent = new Intent(getBaseContext(), SurveySection.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                    Toast.makeText(DocumentationSanitation.this, "Survey Section recorded", Toast.LENGTH_SHORT).show();

                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(DocumentationSanitation.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }


        });
    }
}