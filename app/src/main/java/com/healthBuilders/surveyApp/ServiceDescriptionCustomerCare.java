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

public class ServiceDescriptionCustomerCare extends AppCompatActivity {
    AutoCompleteTextView Customerdirection,Customerservice,Customerresponsiblename,Customercurrentdata,Customerresponsiblephoto,Customerarea,Customerrequestedlistofsupplies,Customercurrentlistofsupplies,Customerhygiene,Customerhandhygience;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description_customer_care);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        Customerdirection = findViewById(R.id.Customerdirectiontxt);
        Customerservice = findViewById(R.id.Customerservicelabeltxt);
        Customerresponsiblename = findViewById(R.id.Customerresponsenametxt);
        Customercurrentdata = findViewById(R.id.Customercurrentdatatxt);
        Customerresponsiblephoto = findViewById(R.id.Customerresponsiblephototxt);
        Customerarea = findViewById(R.id.Customerareamaintenedtxt);
        Customerrequestedlistofsupplies = findViewById(R.id.Customersuppliestxt);
        Customercurrentlistofsupplies = findViewById(R.id.Customerexisingsuppliestxt);
        Customerhygiene = findViewById(R.id.Customerhygienetxt);
        Customerhandhygience = findViewById(R.id.Customerhandtxt);

        //family planning adapterlist
        Customerdirection.setAdapter(adapterDist);
        Customerservice.setAdapter(adapterDist);
        Customerresponsiblename.setAdapter(adapterDist);
        Customercurrentdata.setAdapter(adapterDist);
        Customerresponsiblephoto.setAdapter(adapterDist);
        Customerarea.setAdapter(adapterDist);
        Customerrequestedlistofsupplies.setAdapter(adapterDist);
        Customercurrentlistofsupplies.setAdapter(adapterDist);
        Customerhygiene.setAdapter(adapterDist);
        Customerhandhygience.setAdapter(adapterDist);

        saveNext = findViewById(R.id.serviceDescCustomer);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionConsultation.class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);
                startActivity(intent);
            }
        });
    }
}