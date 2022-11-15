package com.example.secondexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class Steptwo extends AppCompatActivity {
    String[] response = new String[]{ "Yes","No","N/A"};
    TextInputLayout organisationtxt,updatetxt;
    AutoCompleteTextView organi,uptodate,accessible,labtecav,labtecsign,
            labtecemp,nuresearav,nursearsign,nursearempsign,nursevacav,nursevacsign,nursevacempsign,custcareav,custcaresign,
            custcareempsign,nursetbav,nursetbsign,nursetbempsign, nurchiav,nurchisign,nurchiempsign,socialav,socialsign,socialempsign,
            nursecpnav,nursecpnsign,nursecpnempsign,midwifeav,midwifesign,midwifeempsign;
    Button saveSteptwo;

    String organifinal,uptodatefinal,accessiblefinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_steptwo);

        Intent intent = getIntent();

        //final String year = getIntent().getStringExtra("year_id");
        //final String district = getIntent().getStringExtra("district");
        //final String hc = getIntent().getStringExtra("hc");

        //Log.d("year", year);
        //Log.d("district", district);
        //Log.d("Hc", hc);

       //organization chart
        organi=findViewById(R.id.orgavtxt);
        uptodate=findViewById(R.id.uptodatetxt);
        accessible=findViewById(R.id.accessibletxt);
        //lab technician
        labtecav=findViewById(R.id.labtecavltxt);
        labtecsign=findViewById(R.id.labtecsigntxt);
       labtecemp=findViewById(R.id.labtecempsigntxt);
       //NURSE AR
       nuresearav=findViewById(R.id.nurseAravltxt);
       nursearsign=findViewById(R.id.nurseArsigntxt);
       nursearempsign=findViewById(R.id.nurseArempsigntxt);
       //Nurse Vaccination
        nursevacav=findViewById(R.id.nurseVacavltxt);
        nursevacsign=findViewById(R.id.nurseVacsigned);
        nursevacempsign=findViewById(R.id.nurseVacempsigntxt);
        //files customer care
        custcareav=findViewById(R.id.CustCareavltxt);
        custcaresign=findViewById(R.id.CustCaresigntxt);
        custcareempsign=findViewById(R.id.CustCareempsigntxt);

        //files Nurse TB
        nursetbav=findViewById(R.id.nurseTbavltxt);
        nursetbsign=findViewById(R.id.nurseTbsigntxt);
        nursetbempsign=findViewById(R.id.nurseTbempsigntxt);

        //files nursechi
        nurchiav=findViewById(R.id.nurseChiravltxt);
        nurchisign=findViewById(R.id.nurseChirsigntxt);
        nurchiempsign=findViewById(R.id.nurseChirempsigntxt);

        //SOCIAL FILES
        socialav=findViewById(R.id.socialavltxt);
        socialsign=findViewById(R.id.socialsigntxt);
        socialempsign=findViewById(R.id.socialempsigntxt);

        //files nurse cpn
        nursecpnav=findViewById(R.id.nurseCPNavltxt);
        nursecpnsign=findViewById(R.id.nurseCPNsigntxt);
        nursecpnempsign=findViewById(R.id.nurseCPNempsigntxt);

        // midwife files hooks
        midwifeav=findViewById(R.id.Midwifeavltxt);
        midwifesign=findViewById(R.id.Midwifesigntxt);
        midwifeempsign=findViewById(R.id.Midwifeempsigntxt);

        //save button
        saveSteptwo = findViewById(R.id.save2);




        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        //organisation chart
        organi.setAdapter(adapterDist);
        uptodate.setAdapter(adapterDist);
        accessible.setAdapter(adapterDist);
        //lab technician
        labtecav.setAdapter(adapterDist);
        labtecsign.setAdapter(adapterDist);
        labtecemp.setAdapter(adapterDist);
        //nurse AR
        nuresearav.setAdapter(adapterDist);
        nursearsign.setAdapter(adapterDist);
        nursearempsign.setAdapter(adapterDist);
        //nurse vaccination
        nursevacav.setAdapter(adapterDist);
        nursevacsign.setAdapter(adapterDist);
        nursevacempsign.setAdapter(adapterDist);
        //customer care
        custcareav.setAdapter(adapterDist);
        custcaresign.setAdapter(adapterDist);
        custcareempsign.setAdapter(adapterDist);
        custcareempsign.setAdapter(adapterDist);

        //nurse TB

        nursetbav.setAdapter(adapterDist);
        nursetbsign.setAdapter(adapterDist);
        nursetbempsign.setAdapter(adapterDist);

        // files petite churlgie
        nurchiav.setAdapter(adapterDist);
        nurchisign.setAdapter(adapterDist);
        nurchiempsign.setAdapter(adapterDist);


        //social file adapter
        socialav.setAdapter(adapterDist);
        socialsign.setAdapter(adapterDist);
        socialempsign.setAdapter(adapterDist);

        //Nurse cpn adapter
        nursecpnav.setAdapter(adapterDist);
        nursecpnsign.setAdapter(adapterDist);
        nursecpnempsign.setAdapter(adapterDist);

        //midwife adapter
        midwifeav.setAdapter(adapterDist);
        midwifesign.setAdapter(adapterDist);
        midwifeempsign.setAdapter(adapterDist);






        saveSteptwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xorgani = organi.getText().toString().trim();
                final String xuptodate = uptodate.getText().toString().trim();;
                final String xaccessible = accessible.getText().toString().trim();

                final String xlabtecav= labtecav.getText().toString().trim();
                final String xlabtecsign=  labtecsign.getText().toString().trim();
                final String xlabtecemp =  labtecemp.getText().toString().trim();
                //nurse AR
                final String xnuresearav=  nuresearav.getText().toString().trim();
                final String xnursearsign=  nursearsign.getText().toString().trim();
                final String xnursearempsign=  nursearempsign.getText().toString().trim();
                //nurse vaccination
                final String xnursevacav=  nursevacav.getText().toString().trim();
                final String xnursevacsign=  nursevacsign.getText().toString().trim();
                final String xnursevacempsign=  nursevacempsign.getText().toString().trim();
                //customer care
                final String xcustcareav= custcareav.getText().toString().trim();
                final String xcustcaresign=  custcaresign.getText().toString().trim();
                final String xcustcareempsign= custcareempsign.getText().toString().trim();

                //nurse TB

                final String xnursetbav=  nursetbav.getText().toString().trim();
                final String xnursetbsign= nursetbsign.getText().toString().trim();
                final String xnursetbempsign=  nursetbempsign.getText().toString().trim();

                // files petite churlgie
                final String xnurchiav= nurchiav.getText().toString().trim();
                final String xnurchisign= nurchisign.getText().toString().trim();
                final String xnurchiempsign= nurchiempsign.getText().toString().trim();


                //social file adapter
                final String xsocialav= socialav.getText().toString().trim();
                final String xsocialsign= socialsign.getText().toString().trim();
                final String xsocialempsign= socialempsign.getText().toString().trim();

                //Nurse cpn adapter
                final String xnursecpnav= nursecpnav.getText().toString().trim();
                final String xnursecpnsign= nursecpnsign.getText().toString().trim();
                final String xnursecpnempsign= nursecpnempsign.getText().toString().trim();

                //midwife adapter
                final String xmidwifeav= midwifeav.getText().toString().trim();
                final String xmidwifesign= midwifesign.getText().toString().trim();
                final String xmidwifeempsign= midwifeempsign.getText().toString().trim();

                Log.d("organi", xorgani);

                Log.d("uptodate", xuptodate);
                Log.d("accessible", xaccessible);
                Log.d("labtecav", xlabtecav);
                Log.d("labsign", xlabtecsign);
                Log.d("labemp", xlabtecemp);
                Log.d("nursearv", xnuresearav);
                Log.d("nursearsign", xnursearsign);
                Log.d("nursearempsign", xnursearempsign);




            }
        });


    }
}