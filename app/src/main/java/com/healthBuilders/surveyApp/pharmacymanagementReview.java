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

public class pharmacymanagementReview extends AppCompatActivity {
    Button save;
    AutoCompleteTextView drugseparate,drugforms,drugrequisition,drugalphabet,drugclass,drugfifo,drugfefo,drugother,
            drugnone,pharmacydry,pharmacyclean,pharmacyprotected,pharmacyorganized,pharmacythermometer,pharmacyrefrigerator,
                        pharmacymonitored,pharmacyinventory,pharmacyessentials,pharmacynotes;

    TextInputEditText pharmacytemperature,pharmacyrefrigiratortemp;
    String[] response = new String[]{ "Yes","No","N/A"};
    String[] response1 = new String[]{ "Once/week","Twice/week","Thrice/week","More often","Other"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pharmacymanagement_review);



        Intent intent = getIntent();
        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");
        final String section = getIntent().getStringExtra("section");



        save=findViewById(R.id.save1);
        drugseparate=findViewById(R.id.drugSeparate);
        drugforms=findViewById(R.id.drugForms);
        drugrequisition=findViewById(R.id.drugRequisition);
        drugalphabet=findViewById(R.id.drugAlphabet);
        drugclass=findViewById(R.id.drugClass);
        drugfifo=findViewById(R.id.drugFifo);
        drugfefo=findViewById(R.id.drugFefo);
        drugother=findViewById(R.id.drugOther);
        drugnone=findViewById(R.id.drugNone);
        pharmacydry=findViewById(R.id.pharmacyDry);
        pharmacyclean=findViewById(R.id.pharmacyClean);
        pharmacyprotected=findViewById(R.id.pharmacyProtected);
        pharmacyorganized=findViewById(R.id.pharmacyOrganized);
        pharmacythermometer=findViewById(R.id.pharmacyThermometer);
        pharmacyrefrigerator=findViewById(R.id.pharmacyRefrigerator);
        pharmacymonitored=findViewById(R.id.pharmacyMonitored);
        pharmacyinventory=findViewById(R.id.pharmacyInventory);
        pharmacyessentials=findViewById(R.id.pharmacyEssentials);
        pharmacynotes=findViewById(R.id.pharmacyNotes);

        pharmacytemperature=findViewById(R.id.pharmacyTemparature);
        pharmacyrefrigiratortemp=findViewById(R.id.pharmacyRefrigiratorTemparature);



        //adapter
        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);
        ArrayAdapter<String> adapterDist1 = new ArrayAdapter<>(this, R.layout.dropdown_item2, response1);

        //set adapters
        drugseparate.setAdapter(adapterDist);
        drugforms.setAdapter(adapterDist);
        drugrequisition.setAdapter(adapterDist1);
        drugalphabet.setAdapter(adapterDist);
        drugclass.setAdapter(adapterDist);
        drugfifo.setAdapter(adapterDist);
        drugfefo.setAdapter(adapterDist);
        drugother.setAdapter(adapterDist);
        drugnone.setAdapter(adapterDist);
        pharmacydry.setAdapter(adapterDist);
        pharmacyclean.setAdapter(adapterDist);
        pharmacyprotected.setAdapter(adapterDist);
        pharmacyorganized.setAdapter(adapterDist);
        pharmacythermometer.setAdapter(adapterDist);
        pharmacyrefrigerator.setAdapter(adapterDist);
        pharmacymonitored.setAdapter(adapterDist);
        pharmacyinventory.setAdapter(adapterDist);
        pharmacyessentials.setAdapter(adapterDist);
        pharmacynotes.setAdapter(adapterDist);

        myDb = new Databasehelper(this);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xdrugseparate= drugseparate.getText().toString().trim();
                final String xdrugforms= drugforms.getText().toString().trim();
                final String xdrugrequisition= drugrequisition.getText().toString().trim();
                final String xdrugalphabet= drugalphabet.getText().toString().trim();
                final String xdrugclass= drugclass.getText().toString().trim();
                final String xdrugfifo= drugfifo.getText().toString().trim();
                final String xdrugfefo= drugfefo.getText().toString().trim();
                final String xdrugother= drugother.getText().toString().trim();
                final String xdrugnone= drugnone.getText().toString().trim();
                final String xpharmacydry= pharmacydry.getText().toString().trim();
                final String xpharmacyclean= pharmacyclean.getText().toString().trim();
                final String xpharmacyprotected= pharmacyprotected.getText().toString().trim();
                final String xpharmacyorganized= pharmacyorganized.getText().toString().trim();
                final String xpharmacythermometer= pharmacythermometer.getText().toString().trim();
                final String xpharmacyrefrigerator= pharmacyrefrigerator.getText().toString().trim();
                final String xpharmacymonitored= pharmacymonitored.getText().toString().trim();
                final String xpharmacyinventory= pharmacyinventory.getText().toString().trim();
                final String xpharmacyessentials= pharmacyessentials.getText().toString().trim();
                final String xpharmacynotes= pharmacynotes.getText().toString().trim();
                final String xpharmacytemperature= pharmacytemperature.getText().toString().trim();
                final String xpharmacyrefrigiratortemp= pharmacyrefrigiratortemp.getText().toString().trim();
                boolean var = myDb.registerManagementReview(xyear,xdistrict,xhc,xdrugseparate,xdrugforms,xdrugrequisition,xdrugalphabet,xdrugclass,xdrugfifo,xdrugfefo,xdrugother,xdrugnone,xpharmacydry,xpharmacyclean,xpharmacyprotected,xpharmacyorganized,xpharmacythermometer,xpharmacyrefrigerator,xpharmacymonitored,xpharmacyinventory,xpharmacyessentials,xpharmacynotes,xpharmacytemperature,xpharmacyrefrigiratortemp);
                if (var) {

                    Toast.makeText(pharmacymanagementReview.this, "Data recorded", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getBaseContext(), pharmacyStock.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);
                    intent.putExtra("section", section);


                    startActivity(intent);
            }else{
                    Toast.makeText(pharmacymanagementReview.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}