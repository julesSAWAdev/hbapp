package com.example.secondexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class serviceDescription extends AppCompatActivity {
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    AutoCompleteTextView ancdirection,ancservice,ancresponsiblename,anccurrentdata,ancresponsiblephoto,ancarea,ancrequestedlistofsupplies,anccurrentlistofsupplies,anchygiene,anchandhygience;
    Button saveNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_description);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        //anc service hook
        ancdirection = findViewById(R.id.ancdirectiontxt);
        ancservice = findViewById(R.id.ancservicelabeltxt);
        ancresponsiblename = findViewById(R.id.ancresponsenametxt);
        anccurrentdata = findViewById(R.id.anccurrentdatatxt);
        ancresponsiblephoto = findViewById(R.id.ancresponsiblephototxt);
        ancarea = findViewById(R.id.ancareamaintenedtxt);
        ancrequestedlistofsupplies = findViewById(R.id.ancsuppliestxt);
        anccurrentlistofsupplies = findViewById(R.id.ancexisingsuppliestxt);
        anchygiene = findViewById(R.id.anchygienetxt);
        anchandhygience = findViewById(R.id.anchandtxt);

        //set adapter
        ancdirection.setAdapter(adapterDist);
        ancservice.setAdapter(adapterDist);
        ancresponsiblename.setAdapter(adapterDist);
        anccurrentdata.setAdapter(adapterDist);
        ancresponsiblephoto.setAdapter(adapterDist);
        ancarea.setAdapter(adapterDist);
        ancrequestedlistofsupplies.setAdapter(adapterDist);
        anccurrentlistofsupplies.setAdapter(adapterDist);
        anchygiene.setAdapter(adapterDist);
        anchandhygience.setAdapter(adapterDist);


        saveNext = findViewById(R.id.serviceDesc);

        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionVaccination.class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);

                startActivity(intent);
            }
        });



    }


}