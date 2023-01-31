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

public class treatmentguidelinesOverall extends AppCompatActivity {
    AutoCompleteTextView hyavailable,hyuptodate,hyinformed,diaavailable,diauptodate,diainformed,resavailable,resuptodate,resinformed,malavailable,maluptodate,malinformed,stiavailable,stiuptodate,stiinformed;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_treatmentguidelines_overall);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        myDb = new Databasehelper(this);

        //hooks
        hyavailable=findViewById(R.id.hyAvailable);
        hyuptodate = findViewById(R.id.hyUptodate);
        hyinformed = findViewById(R.id.hyInformed);

        diaavailable=findViewById(R.id.diaAvailable);
        diauptodate = findViewById(R.id.diaUptodate);
        diainformed = findViewById(R.id.diaInformed);

        resavailable=findViewById(R.id.resAvailable);
        resuptodate = findViewById(R.id.resUptodate);
        resinformed = findViewById(R.id.resInformed);

        malavailable=findViewById(R.id.malAvailable);
        maluptodate = findViewById(R.id.malUptodate);
        malinformed = findViewById(R.id.malInformed);

        stiavailable=findViewById(R.id.stiAvailable);
        stiuptodate = findViewById(R.id.stiUptodate);
        stiinformed = findViewById(R.id.stiInformed);

        save = findViewById(R.id.saveClose);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        //set adapters
        hyavailable.setAdapter(adapterDist);
        hyuptodate.setAdapter(adapterDist);
        hyavailable.setAdapter(adapterDist);

        diaavailable.setAdapter(adapterDist);
        diauptodate.setAdapter(adapterDist);
        diaavailable.setAdapter(adapterDist);

        resavailable.setAdapter(adapterDist);
        resuptodate.setAdapter(adapterDist);
        resavailable.setAdapter(adapterDist);

        malavailable.setAdapter(adapterDist);
        maluptodate.setAdapter(adapterDist);
        malavailable.setAdapter(adapterDist);

        stiavailable.setAdapter(adapterDist);
        stiuptodate.setAdapter(adapterDist);
        stiavailable.setAdapter(adapterDist);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xhyavailable = hyavailable.getText().toString().trim();
                final String xhyuptodate = hyuptodate.getText().toString().trim();
                final String xhyinformed = hyinformed.getText().toString().trim();
                final String xdiaavailable = diaavailable.getText().toString().trim();
                final String xdiauptodate = diauptodate.getText().toString().trim();
                final String xdiainformed = diainformed.getText().toString().trim();
                final String xresavailable = resavailable.getText().toString().trim();
                final String xresuptodate = resuptodate.getText().toString().trim();
                final String xresinformed = resinformed.getText().toString().trim();
                final String xmalavailable = malavailable.getText().toString().trim();
                final String xmaluptodate = maluptodate.getText().toString().trim();
                final String xmalinformed = malinformed.getText().toString().trim();
                final String xstiavailable = stiavailable.getText().toString().trim();
                final String xstiuptodate = stiuptodate.getText().toString().trim();
                final String xstiinformed = stiinformed.getText().toString().trim();



                boolean var = myDb.registerOverall(xyear,xdistrict,xhc,xhyavailable,xhyuptodate,xhyinformed,xdiaavailable,xdiauptodate,xdiainformed,xresavailable,xresuptodate,xresinformed,xmalavailable,xmaluptodate,xmalinformed,xstiavailable,xstiuptodate,xstiinformed);
                if (var) {
                    Toast.makeText(treatmentguidelinesOverall.this, "Item recorded", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getBaseContext(), treatmentguidelineMaternity .class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                    startActivity(intent);
                }else{
                    Toast.makeText(treatmentguidelinesOverall.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });


    }
}