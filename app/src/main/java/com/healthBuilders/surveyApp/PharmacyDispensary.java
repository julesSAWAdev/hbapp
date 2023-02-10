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

public class PharmacyDispensary extends AppCompatActivity {
    AutoCompleteTextView drugname,drugexpired,pharmacyregister,pharmacytallies,pharmacybook,pharmacysigned,consumptiontotal;
    String[] response = new String[]{ "Yes","No","N/A"};
    String[] drugs = new String[]{ "1.Amitriptyline capsule/tablet","2.Amoxicillin capsule/tablet","3.Atenolol capsule/tablet","4.Captopril capsule/tablet","5.Ciprofloxacin capsule/tablet","6.Co-trimoxazole suspension","7.Diazepam capsule/tablet","8.Diclofenac capsule/tablet","9.Glibenclamide capsule/tablet","10.Vitamin K inj","11.Dexamethazone inj","12.Paracetamol oral suspension","13.Salbutamol inhaler","14.Oxyctocin Inj Ampules"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveItem,closePage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pharmacy_dispensary);

        Intent intent = getIntent();
        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        drugname=findViewById(R.id.drugName);
        drugexpired=findViewById(R.id.drugExpired);
        pharmacyregister=findViewById(R.id.pharmacyRegister);
        pharmacytallies=findViewById(R.id.pharmacyTallies);
        pharmacybook=findViewById(R.id.pharmacyBook);
        pharmacysigned=findViewById(R.id.pharmacySigned);
        consumptiontotal=findViewById(R.id.consumptionTotal);

        saveItem=findViewById(R.id.Save);
        closePage=findViewById(R.id.Close);

        myDb = new Databasehelper(this);

        //adapter
        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);
        ArrayAdapter<String> adapterDist1 = new ArrayAdapter<>(this, R.layout.dropdown_item2, drugs);

        //set adapters
        drugname.setAdapter(adapterDist1);
        drugexpired.setAdapter(adapterDist);
        pharmacyregister.setAdapter(adapterDist);
        pharmacytallies.setAdapter(adapterDist);
        pharmacybook.setAdapter(adapterDist);
        pharmacysigned.setAdapter(adapterDist);
        consumptiontotal.setAdapter(adapterDist);

        closePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getBaseContext(),SurveySection.class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);

                startActivity(intent);
            }
        });

        saveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xdrugname= drugname.getText().toString().trim();
                final String xdrugexpired= drugexpired.getText().toString().trim();
                final String xpharmacyregister= pharmacyregister.getText().toString().trim();
                final String xpharmacytallies= pharmacytallies.getText().toString().trim();
                final String xpharmacybook= pharmacybook.getText().toString().trim();
                final String xpharmacysigned= pharmacysigned.getText().toString().trim();
                final String xconsumptiontotal= consumptiontotal.getText().toString().trim();

                boolean var = myDb.registerValuePharmacyDispensary(xyear,xdistrict,xhc,xdrugname,xdrugexpired,xpharmacyregister,xpharmacytallies,xpharmacybook,xpharmacysigned,xconsumptiontotal);
                if (var) {
                    Toast.makeText(PharmacyDispensary.this, "Item recorded", Toast.LENGTH_LONG).show();
                    drugname.setText("");
                    drugexpired.setText("");
                    pharmacyregister.setText("");
                    pharmacytallies.setText("");
                    pharmacybook.setText("");
                    pharmacysigned.setText("");
                    consumptiontotal.setText("");
                }else{
                    Toast.makeText(PharmacyDispensary.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });


    }
}