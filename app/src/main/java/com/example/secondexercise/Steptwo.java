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

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Steptwo extends AppCompatActivity {
    String[] response = new String[]{ "Yes","No","N/A"};
    TextInputLayout organisationtxt,updatetxt;
    AutoCompleteTextView organi,uptodate,accessible,labtecav,labtecsign,
            labtecemp,nuresearav,nursearsign,nursearempsign,nursevacav,nursevacsign,nursevacempsign,custcareav,custcaresign,
            custcareempsign,nursetbav,nursetbsign,nursetbempsign, nurchiav,nurchisign,nurchiempsign,socialav,socialsign,socialempsign,
            nursecpnav,nursecpnsign,nursecpnempsign,midwifeav,midwifesign,midwifeempsign,soppharmacy,evidence,qicomitee;
    TextInputEditText totstaff,totnurse,paidstaf,clinicalstaff,tbstaff,stafinfection,staffcovid,staffevaluated,stafillness,stafinjuries,staffhepatite,
                        staffrate,patientrate;
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

                //xopa pahrmacy
                final String xsoppharmacy= soppharmacy.getText().toString().trim();

                //evidencepharmacy
                final String xevidence= evidence.getText().toString().trim();

                //qicomitee
                final String xqicomitee= qicomitee.getText().toString().trim();

                Log.d("organi", xorgani);

                Log.d("uptodate", xuptodate);
                Log.d("accessible", xaccessible);
                Log.d("labtecav", xlabtecav);
                Log.d("labsign", xlabtecsign);
                Log.d("labemp", xlabtecemp);
                Log.d("nursearv", xnuresearav);
                Log.d("nursearsign", xnursearsign);
                Log.d("nursearempsign", xnursearempsign);
                Log.d("nursevacav", xnursevacav);
                Log.d("nursevacsign", xnursevacsign);
                Log.d("nursevacempsign", xnursevacempsign);
                Log.d("custocareav", xcustcareav);
                Log.d("custcaresign", xcustcaresign);
                Log.d("custcareemppsign", xcustcareempsign);
                Log.d("nursetbav", xnursetbav);
                Log.d("nursetbsign", xnursetbsign);
                Log.d("nursetbempsign", xnursetbempsign);
                Log.d("nursechi", xnurchiav);
                Log.d("nursechisign", xnurchisign);
                Log.d("nursechiempsign", xnurchiempsign);
                Log.d("socialav", xsocialav);
                Log.d("socialsign", xsocialsign);
                Log.d("socialempsign", xsocialempsign);
                Log.d("nursecpnav", xnursecpnav);
                Log.d("nursecpnsign", xnursecpnsign);
                Log.d("nursecpnempsign", xnursecpnempsign);
                Log.d("midwifeav", xmidwifeav);
                Log.d("midwifesign", xmidwifesign);
                Log.d("midwifeempsign", xmidwifeempsign);
                Log.d("SOPpharmacy", xsoppharmacy);
                Log.d("evidence", xevidence);
                Log.d("qicomitee", xqicomitee);

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

                Log.d("totstaff", xtotstaff);
                Log.d("totnurse", xtotnurse);
                Log.d("paidstaff", xpaidstaff);
                Log.d("clinicalstaff", xclinicalstaff);
                Log.d("tbstaff", xtbstaff);
                Log.d("staffinfection", xstaffinfection);
                Log.d("staffcovid", xstaffcovid);
                Log.d("staffevaluated", xstaffevaluated);
                Log.d("staffillness", xstaffillness);
                Log.d("staffinjuries", xstaffinjuries);
                Log.d("staffhepatite", xstaffhepatite);
                Log.d("staffrate", xstaffrate);
                Log.d("patientrate", xpatientrate);





            }
        });


    }
}