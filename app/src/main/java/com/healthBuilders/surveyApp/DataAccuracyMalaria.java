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

public class DataAccuracyMalaria extends AppCompatActivity {
    TextInputEditText patientfile,register,hmis_hardcopy,hmis_softcopy,labregister,pharmacy;
    AutoCompleteTextView accurate;
    Button savenext;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_data_accuracy_malaria);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");
        final String section = getIntent().getStringExtra("section");


        patientfile=findViewById(R.id.deliverypatient);
        register=findViewById(R.id.deliveryregister);
        hmis_hardcopy=findViewById(R.id.deliveryhardcopy);
        hmis_softcopy=findViewById(R.id.deliverysoftcopy);
        labregister=findViewById(R.id.malarialabregister);
        accurate=findViewById(R.id.deliveryaccurate);
        pharmacy=findViewById(R.id.pharmacydata);

        savenext=findViewById(R.id.deliveryNext);

        myDb = new Databasehelper(this);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        accurate.setAdapter(adapterDist);

        savenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xpatientfile=patientfile.getText().toString().trim();
                final String xregister=register.getText().toString().trim();
                final String xhmis_hardcopy=hmis_hardcopy.getText().toString().trim();
                final String xhmis_softcopy=hmis_softcopy.getText().toString().trim();
                final String xlabregister=labregister.getText().toString().trim();
                final String xacurrate=accurate.getText().toString().trim();
                final String xpharmacy=pharmacy.getText().toString().trim();

                boolean var = myDb.registerDatamanagementMalaria(xyear,xdistrict,xhc,xpatientfile,xregister,xhmis_hardcopy,xhmis_softcopy,xacurrate,xlabregister,xpharmacy);
                if (var) {


                    Intent intent = new Intent(getBaseContext(), DataCompletenessOpd.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);
                    intent.putExtra("section", section);



                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(DataAccuracyMalaria.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }


        });
    }
}