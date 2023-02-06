package com.healthBuilders.surveyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class keyIndicators extends AppCompatActivity {
    TextInputEditText yearid,diacases,diadeaths,pnecases,pnedeaths,malcases,maldeaths,malucases,maludeaths;
    Button save,close;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_key_indicators);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        myDb = new Databasehelper(this);

        yearid=findViewById(R.id.yearId);
        diacases=findViewById(R.id.diaCases);
        diadeaths=findViewById(R.id.diaDeaths);
        pnecases=findViewById(R.id.pneCases);
        pnedeaths=findViewById(R.id.pneDeaths);
        malcases=findViewById(R.id.malCases);
        maldeaths=findViewById(R.id.malDeaths);
        malucases=findViewById(R.id.maluCases);
        maludeaths=findViewById(R.id.maluDeaths);

        close=findViewById(R.id.close);
        save=findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xyearid = yearid.getText().toString().trim();
                final String xdiacases = diacases.getText().toString().trim();
                final String xdiadeaths = diadeaths.getText().toString().trim();
                final String xpnecases = pnecases.getText().toString().trim();
                final String xpnedeaths = pnedeaths.getText().toString().trim();
                final String xmalcases = malcases.getText().toString().trim();
                final String xmaldeaths = maldeaths.getText().toString().trim();
                final String xmalucases = maludeaths.getText().toString().trim();
                final String xmaludeaths = maludeaths.getText().toString().trim();



                boolean var = myDb.registerKeyIndicators(xyear,xdistrict,xhc,xyearid,xdiacases,xdiadeaths,xpnecases,xpnedeaths,xmalcases,xmaldeaths,xmalucases,xmaludeaths);
                if (var) {
                    Toast.makeText(keyIndicators.this, "Item recorded", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(keyIndicators.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AdmittedPatients .class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);

                startActivity(intent);
            }
        });
    }
}