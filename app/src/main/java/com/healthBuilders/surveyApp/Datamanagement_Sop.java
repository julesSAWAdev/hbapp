package com.healthBuilders.surveyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class Datamanagement_Sop extends AppCompatActivity {
    AutoCompleteTextView available,signed,submited,dmavailable;
    Button savenext;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_datamanagement__sop);
        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");
        final String section = getIntent().getStringExtra("section");


        available=findViewById(R.id.sopavailable);
        signed=findViewById(R.id.sopsigned);
        submited=findViewById(R.id.sopsubmited);
        dmavailable=findViewById(R.id.sopmavailable);

        savenext=findViewById(R.id.sopNext);

        myDb = new Databasehelper(this);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);
        available.setAdapter(adapterDist);
        signed.setAdapter(adapterDist);
        submited.setAdapter(adapterDist);
        dmavailable.setAdapter(adapterDist);

        savenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xavailable=available.getText().toString().trim();
                final String xsigned=signed.getText().toString().trim();
                final String xsubmited=submited.getText().toString().trim();
                final String xdmavailable=dmavailable.getText().toString().trim();

                boolean var = myDb.registerDatamanagementSOP(xyear,xdistrict,xhc,xavailable,xsigned,xsubmited,xdmavailable);
                if (var) {


                    Intent intent = new Intent(getBaseContext(), DataAccuracyDeliveries.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);
                    intent.putExtra("section", section);


                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(Datamanagement_Sop.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }


        });
    }
}