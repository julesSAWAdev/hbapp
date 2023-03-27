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

public class valueOfPharmacy extends AppCompatActivity {
    TextInputEditText  fyear,medcost,medexpcost,valuestock;

    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveItem,closePage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_value_of_pharmacy);

        Intent intent = getIntent();
        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");
        final String section = getIntent().getStringExtra("section");


        fyear=findViewById(R.id.fyear);
        medcost=findViewById(R.id.medCost);
        medexpcost=findViewById(R.id.medExpCost);
        valuestock=findViewById(R.id.valueStock);
        saveItem=findViewById(R.id.Save);
        closePage=findViewById(R.id.Close);


        myDb = new Databasehelper(this);

        closePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getBaseContext(), PharmacyDispensary.class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);
                intent.putExtra("section", section);


                startActivity(intent);
            }
        });

        saveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xfyear= fyear.getText().toString().trim();
                final String xmedcost= medcost.getText().toString().trim();
                final String xmedexpcost= medexpcost.getText().toString().trim();
                final String xvaluestock= valuestock.getText().toString().trim();


                boolean var = myDb.registerValuePharmacyStock(xyear,xdistrict,xhc,xfyear,xmedcost,xmedexpcost,xvaluestock);
                if (var) {
                    Toast.makeText(valueOfPharmacy.this, "Item recorded", Toast.LENGTH_LONG).show();
                    fyear.setText("");
                    medcost.setText("");
                    medexpcost.setText("");
                    valuestock.setText("");
                    Toast.makeText(valueOfPharmacy.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}