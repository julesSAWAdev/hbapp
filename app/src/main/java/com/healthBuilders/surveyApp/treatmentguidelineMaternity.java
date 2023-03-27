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

public class treatmentguidelineMaternity extends AppCompatActivity {
    AutoCompleteTextView nationaprotocol,essentialsupplies,privacyprovided,ppesupply;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_treatmentguideline_maternity);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");
        final String section = getIntent().getStringExtra("section");


        myDb = new Databasehelper(this);

        //hooks
        nationaprotocol=findViewById(R.id.nationalProtocol);
        essentialsupplies=findViewById(R.id.essentialSupplies);
        privacyprovided=findViewById(R.id.privacyProvided);
        ppesupply=findViewById(R.id.ppeSupply);
        save=findViewById(R.id.saveClose);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        //set adapters
        nationaprotocol.setAdapter(adapterDist);
        essentialsupplies.setAdapter(adapterDist);
        privacyprovided.setAdapter(adapterDist);
        ppesupply.setAdapter(adapterDist);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xnationaprotocol = nationaprotocol.getText().toString().trim();
                final String xessentialsupplies = essentialsupplies.getText().toString().trim();
                final String xprivacyprovided = privacyprovided.getText().toString().trim();
                final String xppesupply = ppesupply.getText().toString().trim();



                boolean var = myDb.registerMaternity(xyear,xdistrict,xhc,xnationaprotocol,xessentialsupplies,xprivacyprovided,xppesupply);
                if (var) {
                    Toast.makeText(treatmentguidelineMaternity.this, "Item recorded", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getBaseContext(), referralProcess .class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);
                    intent.putExtra("section", section);


                    startActivity(intent);
                }else{
                    Toast.makeText(treatmentguidelineMaternity.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });


    }
}