package com.example.secondexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.lang.ref.SoftReference;

public class MainActivity extends AppCompatActivity {

    TextInputLayout xtypelayout, xdistlayout, xhclayout;
    AutoCompleteTextView xtypetxt, xdistricttxt,xhctxt;
    Integer Districtid;
    Button savecont;
    String[] Rulindo = new String[]{"MURAMBI Rulindo","KININI","MAREMBO","BUBANGU","BUREGA","TUMBA","KISARO","MUSHONGI","MUYANZA","KAJEVUBA","REMERA MBOGO","TARE","RULINDO","RUKOZO","BUYOGA","SHYORONGI","RUTONDE","MUYANZA","RWAHI","MASORO","KINIHIRA"};
    String[] Nyabihu = new String[]{"MWIYANIKE","BIGOGWE","KAREBA","ARUSHA","RWANKERI","SHYIRA","KINTOBO","NYAKIGEZI","KABATWA","RUREMBO","KORA","JOMBA","BIREMBO","GAKAMBA","RAMBURA","NYAKIRIBA"};
    String[] Rwamagana = new String[]{"AVEGA","NYAGASAMBU","RUBONA","MURAMBI","NYAKARIRO","GISHARI","KARENGE","MUSHA","RWAMAGANA","MUNYAGA","MWULIRE","NZIGE","MUYUMBU","GAHENGERI","RUHUNDA"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;

    TextInputEditText xsector,xcells,xvillage,xpubhpost,xprihpost,xpopulation,xpatients,xbeds,xconsrooms,xhosprooms,xchw,xazero,xaone,xatwo,xmidwife;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        progressDialog = new ProgressDialog(this);
        setContentView(R.layout.activity_main2);



        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        //Log.d("year", year);
        //Log.d("district", district);
        //Log.d("Hc", hc);

        xsector = findViewById(R.id.sector);
        xcells = findViewById(R.id.cells);
        xvillage = findViewById(R.id.village);
        xpubhpost = findViewById(R.id.pubhpost);
        xprihpost = findViewById(R.id.prihpost);
        xpopulation = findViewById(R.id.population);
        xpatients = findViewById(R.id.patients);
        xbeds = findViewById(R.id.beds);
        xconsrooms = findViewById(R.id.consrooms);
        xhosprooms = findViewById(R.id.hosprooms);
        xchw = findViewById(R.id.chw);
        xazero = findViewById(R.id.Azero);
        xaone = findViewById(R.id.Aone);
        xatwo = findViewById(R.id.Atwo);
        xmidwife = findViewById(R.id.midwife);


        savecont=findViewById(R.id.save1);
        myDb = new Databasehelper(this);



        savecont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if (!validatesector() | !validatecell() | !validatevillage() | !validatepubpost() | !validatepripost() | !validatepopulation() | !validatepatients() | !validatebeds() | !validateconsrooms() | !validatehosprooms() | !validatechw() | !validatea0() | !validatea1() | !validateA2() | !validatemidwife())
                    return;

                else {
                   //final String ftype = this.xtypetxt.getText().toString().trim();
                   //final String fdistrict = this.xdistricttxt.getText().toString().trim();
                   //final String fhc = this.xhctxt.getText().toString().trim();
                   final String fsector = xsector.getText().toString().trim();
                   final String fcell =xcells.getText().toString().trim();
                   final String fvillage = xvillage.getText().toString().trim();
                   final String fpubhpost = xpubhpost.getText().toString().trim();
                   final String fprihpost = xprihpost.getText().toString().trim();
                   final String fpopulation = xpopulation.getText().toString().trim();
                   final String fpatients = xpatients.getText().toString().trim();
                   final String fbeds = xbeds.getText().toString().trim();
                   final String fconsrooms = xconsrooms.getText().toString().trim();
                   final String fhosprooms = xhosprooms.getText().toString().trim();
                   final String fchw = xchw.getText().toString().trim();
                   final String fazero = xazero.getText().toString().trim();
                   final String faone = xaone.getText().toString().trim();
                   final String fatwo = xatwo.getText().toString().trim();
                   final String fmidwife = xmidwife.getText().toString().trim();
                   final String fyear= year;
                   final String fdistrict = district;
                   final String fhc = hc;
                    /*
                   Log.d("year", fyear);
                   Log.d("district", fdistrict);
                   Log.d("hc", fhc );
                   Log.d("sector", fsector);
                   Log.d("cell", fcell);
                   Log.d("village", fvillage);
                   Log.d("pubpost", fpubhpost);
                   Log.d("pripost", fprihpost);
                   Log.d("population", fpopulation);
                   Log.d("patients", fpatients);
                   Log.d("beds", fbeds);
                   Log.d("consrooms", fconsrooms);
                   Log.d("hosprooms", fhosprooms);
                   Log.d("chw", fchw);
                   Log.d("A0", fazero);
                   Log.d("A1", faone);
                   Log.d("A2", fatwo);
                   Log.d("Midwife", fmidwife);
                */
                    
                   boolean var = myDb.registerBasicInformation(fyear,fdistrict,fhc,fsector,fcell,fvillage,fpubhpost,fprihpost,fpopulation,fpatients,fbeds,fconsrooms,
                           fhosprooms,fchw,fazero,faone,fatwo,fmidwife);
                   if (var){
                       Toast.makeText(MainActivity.this,"Basic information 1 added",Toast.LENGTH_LONG);
                       Intent intent = new Intent(getBaseContext(), Steptwo.class);
                       intent.putExtra("year_id", fyear);
                       intent.putExtra("district", fdistrict);
                       intent.putExtra("hc", fhc);

                       startActivity(intent);
                       finish();
                   }else{
                       Toast.makeText(MainActivity.this, "An error occured", Toast.LENGTH_SHORT).show();
                   }

                }



            }
        });
    }

    private boolean validatesector(){
        String val = xsector.getText().toString();
        if (val.isEmpty()){
            xsector.setError("Sector can't be empty");
            return false;
        }else{
            xsector.setError(null);
            return true;
        }
    }

    private boolean validatecell(){
        String val = xcells.getText().toString();
        if (val.isEmpty()){
            xcells.setError("Cells can't be empty");
            return false;
        }else{
            xcells.setError(null);
            return true;
        }
    }

    private boolean validatevillage(){
        String val = xvillage.getText().toString();
        if (val.isEmpty()){
            xvillage.setError("Village can't be empty");
            return false;
        }else{
            xvillage.setError(null);
            return true;
        }
    }

    private boolean validatepubpost(){
        String val = xpubhpost.getText().toString();
        if (val.isEmpty()){
            xpubhpost.setError("public health post can't be empty");
            return false;
        }else{
            xpubhpost.setError(null);
            return true;
        }
    }

    private boolean validatepripost(){
        String val = xprihpost.getText().toString();
        if (val.isEmpty()){
            xprihpost.setError("Private health post can't be empty");
            return false;
        }else{
            xprihpost.setError(null);
            return true;
        }
    }

    private boolean validatepopulation(){
        String val = xpopulation.getText().toString();
        if (val.isEmpty()){
            xpopulation.setError("population can't be empty");
            return false;
        }else{
            xpopulation.setError(null);
            return true;
        }
    }

    private boolean validatepatients(){
        String val = xpatients.getText().toString();
        if (val.isEmpty()){
            xpatients.setError("Number of Patients can't be empty");
            return false;
        }else{
            xpatients.setError(null);
            return true;
        }
    }

    private boolean validatebeds(){
        String val = xbeds.getText().toString();
        if (val.isEmpty()){
            xbeds.setError("Number of beds can't be empty");
            return false;
        }else{
            xbeds.setError(null);
            return true;
        }
    }

    private boolean validateconsrooms(){
        String val = xconsrooms.getText().toString();
        if (val.isEmpty()){
            xconsrooms.setError("Consulatation rooms can't be empty");
            return false;
        }else{
            xconsrooms.setError(null);
            return true;
        }
    }

    private boolean validatehosprooms(){
        String val = xhosprooms.getText().toString();
        if (val.isEmpty()){
            xhosprooms.setError("hospitalization room can't be empty");
            return false;
        }else{
            xhosprooms.setError(null);
            return true;
        }
    }

    private boolean validatechw(){
        String val = xchw.getText().toString();
        if (val.isEmpty()){
            xchw.setError("CHW can't be empty");
            return false;
        }else{
            xchw.setError(null);
            return true;
        }
    }

    private boolean validatea0(){
        String val = xazero.getText().toString();
        if (val.isEmpty()){
            xazero.setError("A0 can't be empty");
            return false;
        }else{
            xazero.setError(null);
            return true;
        }
    }

    private boolean validatea1(){
        String val = xaone.getText().toString();
        if (val.isEmpty()){
            xaone.setError("A1 can't be empty");
            return false;
        }else{
            xaone.setError(null);
            return true;
        }
    }

    private boolean validateA2(){
        String val = xatwo.getText().toString();
        if (val.isEmpty()){
            xaone.setError("A2 can't be empty");
            return false;
        }else{
            xaone.setError(null);
            return true;
        }
    }
    private boolean validatemidwife(){
        String val = xmidwife.getText().toString();
        if (val.isEmpty()){
            xmidwife.setError("Midwife number can't be empty");
            return false;
        }else{
            xmidwife.setError(null);
            return true;
        }
    }


    
}