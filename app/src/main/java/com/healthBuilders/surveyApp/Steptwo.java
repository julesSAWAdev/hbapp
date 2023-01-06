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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Steptwo extends AppCompatActivity {
    String[] response = new String[]{ "Yes","No","N/A"};
    TextInputLayout organisationtxt,updatetxt;
    AutoCompleteTextView organi,uptodate,accessible,labtecav,labtecsign,
            labtecemp,nuresearav,nursearsign,nursearempsign,nursevacav,nursevacsign,nursevacempsign,custcareav,custcaresign,
            custcareempsign,nursetbav,nursetbsign,nursetbempsign, nurchiav,nurchisign,nurchiempsign,socialav,socialsign,socialempsign,
            nursecpnav,nursecpnsign,nursecpnempsign,midwifeav,midwifesign,midwifeempsign,soppharmacy,evidence,qicomitee,Staffmeeting,COSAmeeting,cogemeeting,chwmeeting;
    TextInputEditText totstaff,totnurse,paidstaf,clinicalstaff,tbstaff,stafinfection,staffcovid,staffevaluated,stafillness,stafinjuries,staffhepatite,
                        staffrate,patientrate;
    Button saveSteptwo;
    TextInputEditText position1,position2,position3,position4,position5,position6,position7,position8,position9;

    private ProgressDialog progressDialog;
    private Databasehelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_steptwo);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        Log.d("year", year);
        Log.d("district", district);
        Log.d("Hc", hc);


       //organization chart
        organi=findViewById(R.id.orgavtxt);
        uptodate=findViewById(R.id.uptodatetxt);
        accessible=findViewById(R.id.accessibletxt);
        //lab technician
        position1=findViewById(R.id.position1);
        labtecav=findViewById(R.id.labtecavltxt);
        labtecsign=findViewById(R.id.labtecsigntxt);
       labtecemp=findViewById(R.id.labtecempsigntxt);
       //NURSE AR
        position2=findViewById(R.id.position2);
       nuresearav=findViewById(R.id.nurseAravltxt);
       nursearsign=findViewById(R.id.nurseArsigntxt);
       nursearempsign=findViewById(R.id.nurseArempsigntxt);
       //Nurse Vaccination
        position3=findViewById(R.id.position3);
        nursevacav=findViewById(R.id.nurseVacavltxt);
        nursevacsign=findViewById(R.id.nurseVacsigned);
        nursevacempsign=findViewById(R.id.nurseVacempsigntxt);
        //files customer care
        position4=findViewById(R.id.position4);
        custcareav=findViewById(R.id.CustCareavltxt);
        custcaresign=findViewById(R.id.CustCaresigntxt);
        custcareempsign=findViewById(R.id.CustCareempsigntxt);

        //files Nurse TB
        position5=findViewById(R.id.position5);
        nursetbav=findViewById(R.id.nurseTbavltxt);
        nursetbsign=findViewById(R.id.nurseTbsigntxt);
        nursetbempsign=findViewById(R.id.nurseTbempsigntxt);

        //files nursechi
        position6=findViewById(R.id.position6);
        nurchiav=findViewById(R.id.nurseChiravltxt);
        nurchisign=findViewById(R.id.nurseChirsigntxt);
        nurchiempsign=findViewById(R.id.nurseChirempsigntxt);

        //SOCIAL FILES
        position7=findViewById(R.id.position7);
        socialav=findViewById(R.id.socialavltxt);
        socialsign=findViewById(R.id.socialsigntxt);
        socialempsign=findViewById(R.id.socialempsigntxt);

        //files nurse cpn
        position8=findViewById(R.id.position8);
        nursecpnav=findViewById(R.id.nurseCPNavltxt);
        nursecpnsign=findViewById(R.id.nurseCPNsigntxt);
        nursecpnempsign=findViewById(R.id.nurseCPNempsigntxt);

        // midwife files hooks
        position9=findViewById(R.id.position9);
        midwifeav=findViewById(R.id.Midwifeavltxt);
        midwifesign=findViewById(R.id.Midwifesigntxt);
        midwifeempsign=findViewById(R.id.Midwifeempsigntxt);

        //SOP pharmacy
        soppharmacy=findViewById(R.id.SOPpharmacytxt);

        //evidence
        evidence=findViewById(R.id.evidencetxt);

        //QIcommitee
        qicomitee=findViewById(R.id.QIcommitee);

        //hooks for inputEdittext
        totstaff=findViewById(R.id.totStaff);
        totnurse=findViewById(R.id.totNurse);
        paidstaf=findViewById(R.id.PaidStaff);
        clinicalstaff=findViewById(R.id.clinicalStaff);
        tbstaff=findViewById(R.id.TBstaff);
        stafinfection=findViewById(R.id.staffInfection);
        staffcovid=findViewById(R.id.staffCovid);
        staffevaluated=findViewById(R.id.StaffperfEvaluated);
        stafillness=findViewById(R.id.staffIllness);
        stafinjuries=findViewById(R.id.staffInjuries);
        staffhepatite=findViewById(R.id.staffHepatite);
        staffrate=findViewById(R.id.StaffRate);
        patientrate=findViewById(R.id.patitentsRate);

        Staffmeeting=findViewById(R.id.Meetingstxt);
        COSAmeeting=findViewById(R.id.cosatxt);
        cogemeeting=findViewById(R.id.cogetxt);
        chwmeeting=findViewById(R.id.chwtxt);


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

        //sop pharmacy adapter
        soppharmacy.setAdapter(adapterDist);

        //evidence adapter
        evidence.setAdapter(adapterDist);

        //qicomitte adapter
        qicomitee.setAdapter(adapterDist);

        //staff meeting  adapter
        Staffmeeting.setAdapter(adapterDist);
        //staff meeting  adapter
        COSAmeeting.setAdapter(adapterDist);
        cogemeeting.setAdapter(adapterDist);
        chwmeeting.setAdapter(adapterDist);

        //database initialization
        myDb = new Databasehelper(this);







        saveSteptwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xorgani = organi.getText().toString().trim();
                final String xuptodate = uptodate.getText().toString().trim();;
                final String xaccessible = accessible.getText().toString().trim();

                final String xposition1=position1.getText().toString().trim();
                final String xlabtecav= labtecav.getText().toString().trim();
                final String xlabtecsign=  labtecsign.getText().toString().trim();
                final String xlabtecemp =  labtecemp.getText().toString().trim();
                //nurse AR
                final String xposition2=position2.getText().toString().trim();
                final String xnuresearav=  nuresearav.getText().toString().trim();
                final String xnursearsign=  nursearsign.getText().toString().trim();
                final String xnursearempsign=  nursearempsign.getText().toString().trim();
                //nurse vaccination
                final String xposition3=position3.getText().toString().trim();
                final String xnursevacav=  nursevacav.getText().toString().trim();
                final String xnursevacsign=  nursevacsign.getText().toString().trim();
                final String xnursevacempsign=  nursevacempsign.getText().toString().trim();
                //customer care
                final String xposition4=position4.getText().toString().trim();
                final String xcustcareav= custcareav.getText().toString().trim();
                final String xcustcaresign=  custcaresign.getText().toString().trim();
                final String xcustcareempsign= custcareempsign.getText().toString().trim();

                //nurse TB
                final String xposition5=position5.getText().toString().trim();
                final String xnursetbav=  nursetbav.getText().toString().trim();
                final String xnursetbsign= nursetbsign.getText().toString().trim();
                final String xnursetbempsign=  nursetbempsign.getText().toString().trim();

                // files petite churlgie
                final String xposition6=position6.getText().toString().trim();
                final String xnurchiav= nurchiav.getText().toString().trim();
                final String xnurchisign= nurchisign.getText().toString().trim();
                final String xnurchiempsign= nurchiempsign.getText().toString().trim();


                //social file adapter
                final String xposition7=position7.getText().toString().trim();
                final String xsocialav= socialav.getText().toString().trim();
                final String xsocialsign= socialsign.getText().toString().trim();
                final String xsocialempsign= socialempsign.getText().toString().trim();

                //Nurse cpn adapter
                final String xposition8=position8.getText().toString().trim();
                final String xnursecpnav= nursecpnav.getText().toString().trim();
                final String xnursecpnsign= nursecpnsign.getText().toString().trim();
                final String xnursecpnempsign= nursecpnempsign.getText().toString().trim();

                //midwife adapter
                final String xposition9=position9.getText().toString().trim();
                final String xmidwifeav= midwifeav.getText().toString().trim();
                final String xmidwifesign= midwifesign.getText().toString().trim();
                final String xmidwifeempsign= midwifeempsign.getText().toString().trim();

                //xopa pahrmacy
                final String xsoppharmacy= soppharmacy.getText().toString().trim();

                //evidencepharmacy
                final String xevidence= evidence.getText().toString().trim();

                //qicomitee
                final String xqicomitee= qicomitee.getText().toString().trim();




                // get input text values

                final String xtotstaff = totstaff.getText().toString().trim();
                final String xtotnurse = totnurse.getText().toString().trim();
                final String xpaidstaff = paidstaf.getText().toString().trim();
                final String xclinicalstaff = clinicalstaff.getText().toString().trim();
                final String xtbstaff = tbstaff.getText().toString().trim();
                final String xstaffinfection = stafinfection.getText().toString().trim();
                final String xstaffcovid = staffcovid.getText().toString().trim();
                final String xstaffevaluated = staffevaluated.getText().toString().trim();
                final String xstaffillness = stafillness.getText().toString().trim();
                final String xstaffinjuries = stafinjuries.getText().toString().trim();
                final String xstaffhepatite = staffhepatite.getText().toString().trim();
                final String xstaffrate = staffrate.getText().toString().trim();
                final String xpatientrate = patientrate.getText().toString().trim();
                final String xstaffmeeting = Staffmeeting.getText().toString().trim();
                final String xcosameeting = COSAmeeting.getText().toString().trim();
                final String xcogemeeting = cogemeeting.getText().toString().trim();
                final String xchwmeeting = chwmeeting.getText().toString().trim();




                //intent collection

                final String xyear=year;
                final String xhc=hc;
                final String xdistrict=district;
                Log.d("year", xyear);
                Log.d("HC", xhc);
                Log.d("district", xdistrict);

                boolean var = myDb.registerBasicInformation2(xyear,xdistrict,xhc,xorgani,xuptodate,xaccessible,xposition1,xlabtecav,xlabtecsign,xlabtecemp,xposition2,xnuresearav,xnursearsign,xnursearempsign,xposition3
                ,xnursevacav,xnursevacsign,xnursevacempsign,xposition4,xcustcareav,xcustcaresign,xcustcareempsign,xposition5,xnursetbav,xnursetbsign,xnursetbempsign,xposition6,xnurchiav,xnurchisign,xnurchiempsign,xposition7,xsocialav,
                        xsocialsign,xsocialempsign,xposition8,xnursecpnav,xnursecpnsign,xnursecpnempsign,xposition9,xmidwifeav,xmidwifesign,xmidwifeempsign,xsoppharmacy,xevidence,xqicomitee,
                        xtotstaff,xtotnurse,xpaidstaff,xclinicalstaff,xtbstaff,xstaffinfection,xstaffcovid,xstaffevaluated,xstaffillness,xstaffinjuries,xstaffhepatite,xstaffrate,xpatientrate,xstaffmeeting,xcosameeting,xcogemeeting,xchwmeeting);
                if (var){
                    Toast.makeText(Steptwo.this,"record added succesfuly",Toast.LENGTH_SHORT);
                    startActivity(new Intent(Steptwo.this, startPage.class));
                    finish();
                }else{
                    Toast.makeText(Steptwo.this, "An error occured", Toast.LENGTH_SHORT).show();
                }
            }


        });


    }
}