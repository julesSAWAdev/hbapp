package com.example.secondexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;

public class serviceDescription extends AppCompatActivity {
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    AutoCompleteTextView ancdirection,ancservice,ancresponsiblename,anccurrentdata,ancresponsiblephoto,ancarea,ancrequestedlistofsupplies,anccurrentlistofsupplies,anchygiene,anchandhygience
            ,vacdirection,vacservice,vacresponsiblename,vaccurrentdata,vacresponsiblephoto,vacarea,vacrequestedlistofsupplies,vaccurrentlistofsupplies,vachygiene,vachandhygience,
            fpdirection,fpservice,fpresponsiblename,fpcurrentdata,fpresponsiblephoto,fparea,fprequestedlistofsupplies,fpcurrentlistofsupplies,fphygiene,fphandhygience;

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

        //vaccination service hook
        vacdirection = findViewById(R.id.vacdirectiontxt);
        vacservice = findViewById(R.id.vacservicelabeltxt);
        vacresponsiblename = findViewById(R.id.vacresponsenametxt);
        vaccurrentdata = findViewById(R.id.vaccurrentdatatxt);
        vacresponsiblephoto = findViewById(R.id.vacresponsiblephototxt);
        vacarea = findViewById(R.id.vacareamaintenedtxt);
        vacrequestedlistofsupplies = findViewById(R.id.vacsuppliestxt);
        vaccurrentlistofsupplies = findViewById(R.id.vacexisingsuppliestxt);
        vachygiene = findViewById(R.id.vachygienetxt);
        vachandhygience = findViewById(R.id.vachandtxt);


        //family planning service hook

        fpdirection = findViewById(R.id.fpdirectiontxt);
        fpservice = findViewById(R.id.fpservicelabeltxt);
        fpresponsiblename = findViewById(R.id.fpresponsenametxt);
        fpcurrentdata = findViewById(R.id.fpcurrentdatatxt);
        fpresponsiblephoto = findViewById(R.id.fpresponsiblephototxt);
        fparea = findViewById(R.id.fpareamaintenedtxt);
        fprequestedlistofsupplies = findViewById(R.id.fpsuppliestxt);
        fpcurrentlistofsupplies = findViewById(R.id.fpexisingsuppliestxt);
        fphygiene = findViewById(R.id.fphygienetxt);
        fphandhygience = findViewById(R.id.fphandtxt);

    }
}