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

public class ServiceDescriptionNoticeboard extends AppCompatActivity {
    AutoCompleteTextView  Noticecurrentdata;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description_noticeboard);


        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        Noticecurrentdata = findViewById(R.id.Noticecurrentdatatxt);

        Noticecurrentdata.setAdapter(adapterDist);
        myDb = new Databasehelper(this);

        saveNext = findViewById(R.id.serviceDescNotice);
        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xcurrentdata = Noticecurrentdata.getText().toString().trim();

                boolean var = myDb.registerTNoticeBoardCurrentDataServiceDescription(xyear,xdistrict,xhc,xcurrentdata);
                if (var) {
                    Intent intent = new Intent(getBaseContext(), startPage.class);


                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(ServiceDescriptionNoticeboard.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}