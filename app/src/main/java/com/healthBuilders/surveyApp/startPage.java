package com.healthBuilders.surveyApp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

public class startPage extends AppCompatActivity {
    TextInputLayout xsurvey, xdisdrop,xhcdrop;
    AutoCompleteTextView xdistricttxt, xhealthcentertxt;
    Integer Districtid;
    Button savecont,Sync;
    String[] Rulindo = new String[]{"MURAMBI Rulindo","KININI","MAREMBO","BUBANGU","BUREGA","TUMBA","KISARO","MUSHONGI","MUYANZA","KAJEVUBA","REMERA MBOGO","TARE","RULINDO","RUKOZO","BUYOGA","SHYORONGI","RUTONDE","MUYANZA","RWAHI","MASORO","KINIHIRA"};
    String[] Nyabihu = new String[]{"MWIYANIKE","BIGOGWE","KAREBA","ARUSHA","RWANKERI","SHYIRA","KINTOBO","NYAKIGEZI","KABATWA","RUREMBO","KORA","JOMBA","BIREMBO","GAKAMBA","RAMBURA","NYAKIRIBA"};
    String[] Rwamagana = new String[]{"AVEGA","NYAGASAMBU","RUBONA","MURAMBI","NYAKARIRO","GISHARI","KARENGE","MUSHA","RWAMAGANA","MUNYAGA","MWULIRE","NZIGE","MUYUMBU","GAHENGERI","RUHUNDA"};

    TextInputEditText xsurveyyear;
    public Databasehelper myDB;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_page);
        xsurveyyear=findViewById(R.id.etsurvey);
        xdistricttxt=findViewById(R.id.MainDist);
        xhealthcentertxt= findViewById(R.id.Mainhc);

        savecont= findViewById(R.id.nextPage1);
        Sync= findViewById(R.id.sync);

        myDB = new Databasehelper(this);


        final String[] Districts = new String[]{"Nyabihu", "Rulindo", "Rwamagana"};
        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, Districts);
        xdistricttxt.setAdapter(adapterDist);

        //to get selected value add item click listener
        xdistricttxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String district = xdistricttxt.getText().toString();

                Log.d("district is: ", district);

                if (district.equals("Nyabihu")){
                    Districtid = 6;
                    getHC(Districtid);


                }else if(district.equals("Rulindo")){
                    Districtid = 3;

                    getHC(Districtid);

                }else if(district.equals("Rwamagana")){
                    Districtid = 9;
                    getHC(Districtid);

                }
            }

        });


        savecont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                save1();
            }
        });

        Sync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              if(checkNetwork()==false){
                  Toast.makeText(startPage.this,"No internet connection",Toast.LENGTH_SHORT).show();
              }else{
                  readUSers();
                  readBasicInfo();
                  readBasicInfo2();
                  readAncServicedescription();
                  readVaccServicedescription();
                  readFamServicedescription();
                  readPharmacyStockServicedescription();
                  readPharmacyDispServicedescription();
                  readNcdServicedescription();
                  readCehoServicedescription();
                  readCashierServicedescription();
                  readAccountingServicedescription();
                  readLaboratoryServicedescription();
                  readTitulaireServicedescription();
                  readDataManagerServicedescription();
                  readDataARVServicedescription();
                  readCustoCareServicedescription();
                  readConsroomServicedescription();
                  readMaternityServicedescription();
                  readHospitalizationServicedescription();
                  readToiletsServicedescription();
                  readNoticeboardServicedescription();
                  readdocumentation_Actionplan();
                  readdocumentation_Businessplan();
                  readdocumentation_budgetplan();
                  readdocumentation_inservice();
                  readdocumentation_work();
                  readdocumentation_qi();
                  readdocumentation_ExtTraining();
                  readdocumentation_attendanceRegister();
                  readdocumentation_payableRegister();
                  readdocumentation_receivableRegister();
                  readdocumentation_malariaPlan();
                  readdocumentation_customerCareProgram();
                  readdocumentation_generalSanitation();
                  readData_DataManagementSOP();
                  readData_DataManagementdeliveries();
                  readData_DataManagementNCD();
                  readData_DataManagementBCG();
                  readData_DataCasesMalaria();


              }

            }
        });



    }
    private void getHC(Integer districtid) {
        if (districtid==3){
            ArrayAdapter<String> adapterHC = new ArrayAdapter<>(this, R.layout.dropdown_item2, Rulindo);
            xhealthcentertxt.setAdapter(adapterHC);
        }else if (districtid==6){
            ArrayAdapter<String> adapterHC = new ArrayAdapter<>(this, R.layout.dropdown_item2, Nyabihu);
            xhealthcentertxt.setAdapter(adapterHC);
        }else{
            ArrayAdapter<String> adapterHC = new ArrayAdapter<>(this, R.layout.dropdown_item2, Rwamagana);
            xhealthcentertxt.setAdapter(adapterHC);
        }


    }
    private void save1() {

        final String year = this.xsurveyyear.getText().toString().trim();
        final String district = this.xdistricttxt.getText().toString().trim();
        final String hc = this.xhealthcentertxt.getText().toString().trim();
        Intent intent = new Intent(getBaseContext(), SurveySection.class);
        intent.putExtra("year_id", year);
        intent.putExtra("district", district);
        intent.putExtra("hc", hc);

        startActivity(intent);


    }

    // read users ***************** sync
    public void readUSers(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getUSers(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String id,fname,lname,email,password,status;
                id = cursor.getString(0);
                fname = cursor.getString(1);
                lname = cursor.getString(2);
                email = cursor.getString(3);
                password = cursor.getString(4);
                status = cursor.getString(5);

                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/home.php?ID="+id+"&FNAME="+fname+"&LNAME="+lname+"&EMAIL="+email+"&PASSWORD="+password, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        final String ID=id.toString();
                        final String FNAME=fname.toString();
                        final String LNAME=lname.toString();
                        final String PASSWORD=password.toString();
                        final String EMAIL=email.toString();

                       params.put("ID",ID);
                       params.put("FNAME",FNAME);
                       params.put("LNAME",LNAME);
                       params.put("EMAIL",EMAIL);
                       params.put("PASSWORD",PASSWORD);

                       return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
           int count = Databasehelper.updateUsers("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    // read basicinfo ***************** sync

    public void readBasicInfo(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getBasicInfo(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,SECTOR,CELL,VILLAGE,PUBPOST,PRIPOST,POPULATION,PATIENTS,BEDS,CONSROOMS,HOSPROOMS,CHW,A0,A1,A2,MIDWIFE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                SECTOR = cursor.getString(3);
                CELL = cursor.getString(4);
                VILLAGE = cursor.getString(5);
                PUBPOST = cursor.getString(6);
                PRIPOST = cursor.getString(7);
                POPULATION = cursor.getString(8);
                PATIENTS = cursor.getString(9);
                BEDS = cursor.getString(10);
                CONSROOMS = cursor.getString(11);
                HOSPROOMS = cursor.getString(12);
                CHW = cursor.getString(13);
                A0 = cursor.getString(14);
                A1 = cursor.getString(15);
                A2 = cursor.getString(16);
                MIDWIFE = cursor.getString(17);

                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/basicinfo.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&SECTOR="+SECTOR+"&CELL="+CELL+"&VILLAGE="+VILLAGE+"&PUBPOST="+PUBPOST+"&PRIPOST="+PRIPOST+"&POPULATION="+POPULATION+"&PATIENTS="+PATIENTS+"&BEDS="+BEDS+"&CONSROOMS="+CONSROOMS+"&HOSPROOMS="+HOSPROOMS+"&CHW="+CHW+"&A0="+A0+"&A1="+A1+"&A2="+A2+"&MIDWIFE="+MIDWIFE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateBasicInfo("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    // read basicinfo2 ***************** sync
    public void readBasicInfo2(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getBasicInfo2(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR ,DISTRICT ,HC ,ORGANI ,UPTODATE ,ACCESSIBE ,POSITION1 ,LABTECAV ,LABSIGN ,LABEMP ,POSITION2 ,NURSEARV ,NURSEARSIGN ,NURSEAREMPSIGN ,POSITION3 ,NURSEVACAV ,NURSEVACSIGN ,NURSEVACEMPSIGN ,POSITION4 ,CUSTOCAREAV ,CUSTCARESIGN ,CUSTCAREEMPPSIGN ,POSITION5 ,NURSETBAV ,NURSETBSIGN ,NURSETBEMPSIGN ,POSITION6 ,NURSECHI ,NURSECHISIGN ,NURSECHIEMPSIGN ,POSITION7 ,SOCIALAV ,SOCIALSIGN ,SOCIALEMPSIGN ,POSITION8 ,NURSECPNAV ,NURSECPNSIGN ,NURSECPNEMPSIGN ,POSITION9 ,MIDWIFEAV ,MIDWIFESIGN ,MIDWIFEEMPSIGN ,SOPPHARMACY ,EVIDENCE ,QICOMITEE ,TOTSTAFF ,TOTNURSE ,PAIDSTAFF ,CLINICALSTAFF ,TBSTAFF ,STAFFINFECTION ,STAFFCOVID ,STAFFEVALUATED ,STAFFILLNESS ,STAFFINJURIES ,STAFFHEPATITE ,STAFFRATE ,PATIENTRATE ,STAFFMETTING ,COSAMETTING ,COGEMETTING ,CHWMETTING;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                ORGANI= cursor.getString(3);
                UPTODATE= cursor.getString(4);
                ACCESSIBE= cursor.getString(5);
                POSITION1= cursor.getString(7);
                LABTECAV= cursor.getString(8);
                LABSIGN= cursor.getString(9);
                LABEMP= cursor.getString(10);
                POSITION2= cursor.getString(11);
                NURSEARV= cursor.getString(12);
                NURSEARSIGN= cursor.getString(13);
                NURSEAREMPSIGN= cursor.getString(14);
                POSITION3= cursor.getString(15);
                NURSEVACAV= cursor.getString(16);
                NURSEVACSIGN= cursor.getString(17);
                NURSEVACEMPSIGN= cursor.getString(18);
                POSITION4= cursor.getString(19);
                CUSTOCAREAV= cursor.getString(20);
                CUSTCARESIGN= cursor.getString(21);
                CUSTCAREEMPPSIGN= cursor.getString(22);
                POSITION5= cursor.getString(23);
                NURSETBAV= cursor.getString(24);
                NURSETBSIGN= cursor.getString(25);
                NURSETBEMPSIGN= cursor.getString(26);
                POSITION6= cursor.getString(27);
                NURSECHI= cursor.getString(28);
                NURSECHISIGN= cursor.getString(29);
                NURSECHIEMPSIGN= cursor.getString(30);
                POSITION7= cursor.getString(31);
                SOCIALAV= cursor.getString(32);
                SOCIALSIGN= cursor.getString(33);
                SOCIALEMPSIGN= cursor.getString(34);
                POSITION8= cursor.getString(35);
                NURSECPNAV= cursor.getString(36);
                NURSECPNSIGN= cursor.getString(37);
                NURSECPNEMPSIGN= cursor.getString(38);
                POSITION9= cursor.getString(39);
                MIDWIFEAV= cursor.getString(40);
                MIDWIFESIGN= cursor.getString(41);
                MIDWIFEEMPSIGN= cursor.getString(42);
                SOPPHARMACY= cursor.getString(43);
                EVIDENCE= cursor.getString(44);
                QICOMITEE= cursor.getString(45);
                TOTSTAFF= cursor.getString(46);
                TOTNURSE= cursor.getString(47);
                PAIDSTAFF= cursor.getString(48);
                CLINICALSTAFF= cursor.getString(49);
                TBSTAFF= cursor.getString(50);
                STAFFINFECTION= cursor.getString(51);
                STAFFCOVID= cursor.getString(52);
                STAFFEVALUATED= cursor.getString(53);
                STAFFILLNESS= cursor.getString(54);
                STAFFINJURIES= cursor.getString(55);
                STAFFHEPATITE= cursor.getString(56);
                STAFFRATE= cursor.getString(57);
                PATIENTRATE= cursor.getString(58);
                STAFFMETTING= cursor.getString(59);
                COSAMETTING= cursor.getString(60);
                COGEMETTING= cursor.getString(61);
                CHWMETTING= cursor.getString(62);

                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/basicinfo2.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&ORGANI="+ORGANI+"&UPTODATE="+UPTODATE+"&ACCESSIBE="+ACCESSIBE+"&POSITION1="+POSITION1+"&LABTECAV="+LABTECAV+"&LABSIGN="+LABSIGN+"&LABEMP="+LABEMP
                        +"&POSITION2="+POSITION2+"&NURSEARV="+NURSEARV+"&NURSEARSIGN="+NURSEARSIGN+"&NURSEAREMPSIGN="+NURSEAREMPSIGN+"&POSITION3="+POSITION3+"&NURSEVACAV="+NURSEVACAV+"&NURSEVACSIGN="+NURSEVACSIGN+"&NURSEVACEMPSIGN="+NURSEVACEMPSIGN+"&POSITION4="+POSITION4+"&CUSTOCAREAV="+CUSTOCAREAV+"&CUSTCARESIGN="+CUSTCARESIGN+"&CUSTCAREEMPPSIGN="+CUSTCAREEMPPSIGN+"&POSITION5="+POSITION5+"&NURSETBAV="+NURSETBAV+"&NURSETBSIGN="+NURSETBSIGN+"&NURSETBEMPSIGN="+NURSETBEMPSIGN+"&POSITION6="+POSITION6
                        +"&NURSECHI="+NURSECHI+"&NURSECHISIGN="+NURSECHISIGN+"&NURSECHIEMPSIGN="+NURSECHIEMPSIGN+"&POSITION7="+POSITION7+"&SOCIALAV="+SOCIALAV+"&SOCIALSIGN="+SOCIALSIGN+"&SOCIALEMPSIGN="+POSITION8+"&POSITION8="+NURSECPNAV+"&NURSECPNAV="+NURSECPNAV+"&NURSECPNSIGN="+NURSECPNSIGN
                        +"&POSITION9="+POSITION9+"&MIDWIFEAV="+MIDWIFEAV+"&MIDWIFESIGN="+MIDWIFESIGN+"&MIDWIFEEMPSIGN="+MIDWIFEEMPSIGN+"&SOPPHARMACY="+SOPPHARMACY+"&EVIDENCE="+EVIDENCE+"&QICOMITEE="+QICOMITEE+"&TOTSTAFF="+TOTSTAFF+"&TOTNURSE="+TOTNURSE+"&PAIDSTAFF="+PAIDSTAFF
                        +"&CLINICALSTAFF="+CLINICALSTAFF+"&TBSTAFF="+TBSTAFF+"&STAFFINFECTION="+STAFFINFECTION+"&STAFFCOVID="+STAFFCOVID+"&STAFFEVALUATED="+STAFFEVALUATED+"&STAFFILLNESS="+STAFFILLNESS+"&STAFFINJURIES="+STAFFINJURIES+"&STAFFHEPATITE="+STAFFHEPATITE+"&STAFFRATE="+STAFFRATE+"&PATIENTRATE="+PATIENTRATE
                        +"&STAFFMETTING="+STAFFMETTING+"&COSAMETTING="+COSAMETTING+"&COGEMETTING="+COGEMETTING+"&CHWMETTING="+CHWMETTING+"&SOCIALEMPSIGN="+SOCIALEMPSIGN+"&NURSECPNEMPSIGN="+NURSECPNEMPSIGN, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();


                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateBasicInfo2("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }


    //readANC_servicedescription

    public void readAncServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getAnc_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,DIRECTION,SERVICE,RESPONSIBLENAME,CURRENTDATA,RESPONSIBLEPHOTO,AREA,REQUESTEDLISTOFSUPPLIES,CURRENTLISTOFSUPPLIES,HYGIENE,HANDHYGIENE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                DIRECTION = cursor.getString(3);
                SERVICE = cursor.getString(4);
                RESPONSIBLENAME = cursor.getString(5);
                CURRENTDATA = cursor.getString(6);
                RESPONSIBLEPHOTO = cursor.getString(7);
                AREA = cursor.getString(8);
                REQUESTEDLISTOFSUPPLIES = cursor.getString(9);
                CURRENTLISTOFSUPPLIES = cursor.getString(10);
                HYGIENE = cursor.getString(11);
                HANDHYGIENE = cursor.getString(12);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/ancservicedescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&DIRECTION="+DIRECTION+"&SERVICE="+SERVICE+"&RESPONSIBLENAME="+RESPONSIBLENAME+"&CURRENTDATA="+CURRENTDATA+"&RESPONSIBLEPHOTO="+RESPONSIBLEPHOTO+"&AREA="+AREA+"&REQUESTEDLISTOFSUPPLIES="+REQUESTEDLISTOFSUPPLIES+"&CURRENTLISTOFSUPPLIES="+CURRENTLISTOFSUPPLIES+"&HYGIENE="+HYGIENE+"&HANDHYGIENE="+HANDHYGIENE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateAnc_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read vaccination_servicedescription

    public void readVaccServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getVacc_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,DIRECTION,SERVICE,RESPONSIBLENAME,CURRENTDATA,RESPONSIBLEPHOTO,AREA,REQUESTEDLISTOFSUPPLIES,CURRENTLISTOFSUPPLIES,HYGIENE,HANDHYGIENE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                DIRECTION = cursor.getString(3);
                SERVICE = cursor.getString(4);
                RESPONSIBLENAME = cursor.getString(5);
                CURRENTDATA = cursor.getString(6);
                RESPONSIBLEPHOTO = cursor.getString(7);
                AREA = cursor.getString(8);
                REQUESTEDLISTOFSUPPLIES = cursor.getString(9);
                CURRENTLISTOFSUPPLIES = cursor.getString(10);
                HYGIENE = cursor.getString(11);
                HANDHYGIENE = cursor.getString(12);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/vaccinationservicedescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&DIRECTION="+DIRECTION+"&SERVICE="+SERVICE+"&RESPONSIBLENAME="+RESPONSIBLENAME+"&CURRENTDATA="+CURRENTDATA+"&RESPONSIBLEPHOTO="+RESPONSIBLEPHOTO+"&AREA="+AREA+"&REQUESTEDLISTOFSUPPLIES="+REQUESTEDLISTOFSUPPLIES+"&CURRENTLISTOFSUPPLIES="+CURRENTLISTOFSUPPLIES+"&HYGIENE="+HYGIENE+"&HANDHYGIENE="+HANDHYGIENE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateVacc_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read family planning _servicedescription

    public void readFamServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getFam_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,DIRECTION,SERVICE,RESPONSIBLENAME,CURRENTDATA,RESPONSIBLEPHOTO,AREA,REQUESTEDLISTOFSUPPLIES,CURRENTLISTOFSUPPLIES,HYGIENE,HANDHYGIENE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                DIRECTION = cursor.getString(3);
                SERVICE = cursor.getString(4);
                RESPONSIBLENAME = cursor.getString(5);
                CURRENTDATA = cursor.getString(6);
                RESPONSIBLEPHOTO = cursor.getString(7);
                AREA = cursor.getString(8);
                REQUESTEDLISTOFSUPPLIES = cursor.getString(9);
                CURRENTLISTOFSUPPLIES = cursor.getString(10);
                HYGIENE = cursor.getString(11);
                HANDHYGIENE = cursor.getString(12);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/familyservicedescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&DIRECTION="+DIRECTION+"&SERVICE="+SERVICE+"&RESPONSIBLENAME="+RESPONSIBLENAME+"&CURRENTDATA="+CURRENTDATA+"&RESPONSIBLEPHOTO="+RESPONSIBLEPHOTO+"&AREA="+AREA+"&REQUESTEDLISTOFSUPPLIES="+REQUESTEDLISTOFSUPPLIES+"&CURRENTLISTOFSUPPLIES="+CURRENTLISTOFSUPPLIES+"&HYGIENE="+HYGIENE+"&HANDHYGIENE="+HANDHYGIENE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateFam_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read pharmacy stock _servicedescription

    public void readPharmacyStockServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getPharmaStock_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,DIRECTION,SERVICE,RESPONSIBLENAME,CURRENTDATA,RESPONSIBLEPHOTO,AREA,REQUESTEDLISTOFSUPPLIES,CURRENTLISTOFSUPPLIES,HYGIENE,HANDHYGIENE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                DIRECTION = cursor.getString(3);
                SERVICE = cursor.getString(4);
                RESPONSIBLENAME = cursor.getString(5);
                CURRENTDATA = cursor.getString(6);
                RESPONSIBLEPHOTO = cursor.getString(7);
                AREA = cursor.getString(8);
                REQUESTEDLISTOFSUPPLIES = cursor.getString(9);
                CURRENTLISTOFSUPPLIES = cursor.getString(10);
                HYGIENE = cursor.getString(11);
                HANDHYGIENE = cursor.getString(12);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/pharmactstockdescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&DIRECTION="+DIRECTION+"&SERVICE="+SERVICE+"&RESPONSIBLENAME="+RESPONSIBLENAME+"&CURRENTDATA="+CURRENTDATA+"&RESPONSIBLEPHOTO="+RESPONSIBLEPHOTO+"&AREA="+AREA+"&REQUESTEDLISTOFSUPPLIES="+REQUESTEDLISTOFSUPPLIES+"&CURRENTLISTOFSUPPLIES="+CURRENTLISTOFSUPPLIES+"&HYGIENE="+HYGIENE+"&HANDHYGIENE="+HANDHYGIENE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updatePharmaStock_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read pharmacy dispensing _servicedescription

    public void readPharmacyDispServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getPharmaDisp_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,DIRECTION,SERVICE,RESPONSIBLENAME,CURRENTDATA,RESPONSIBLEPHOTO,AREA,REQUESTEDLISTOFSUPPLIES,CURRENTLISTOFSUPPLIES,HYGIENE,HANDHYGIENE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                DIRECTION = cursor.getString(3);
                SERVICE = cursor.getString(4);
                RESPONSIBLENAME = cursor.getString(5);
                CURRENTDATA = cursor.getString(6);
                RESPONSIBLEPHOTO = cursor.getString(7);
                AREA = cursor.getString(8);
                REQUESTEDLISTOFSUPPLIES = cursor.getString(9);
                CURRENTLISTOFSUPPLIES = cursor.getString(10);
                HYGIENE = cursor.getString(11);
                HANDHYGIENE = cursor.getString(12);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/pharmactDispdescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&DIRECTION="+DIRECTION+"&SERVICE="+SERVICE+"&RESPONSIBLENAME="+RESPONSIBLENAME+"&CURRENTDATA="+CURRENTDATA+"&RESPONSIBLEPHOTO="+RESPONSIBLEPHOTO+"&AREA="+AREA+"&REQUESTEDLISTOFSUPPLIES="+REQUESTEDLISTOFSUPPLIES+"&CURRENTLISTOFSUPPLIES="+CURRENTLISTOFSUPPLIES+"&HYGIENE="+HYGIENE+"&HANDHYGIENE="+HANDHYGIENE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updatePharmacyDisp_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }


    //read ncd _servicedescription

    public void readNcdServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getncd_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,DIRECTION,SERVICE,RESPONSIBLENAME,CURRENTDATA,RESPONSIBLEPHOTO,AREA,REQUESTEDLISTOFSUPPLIES,CURRENTLISTOFSUPPLIES,HYGIENE,HANDHYGIENE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                DIRECTION = cursor.getString(3);
                SERVICE = cursor.getString(4);
                RESPONSIBLENAME = cursor.getString(5);
                CURRENTDATA = cursor.getString(6);
                RESPONSIBLEPHOTO = cursor.getString(7);
                AREA = cursor.getString(8);
                REQUESTEDLISTOFSUPPLIES = cursor.getString(9);
                CURRENTLISTOFSUPPLIES = cursor.getString(10);
                HYGIENE = cursor.getString(11);
                HANDHYGIENE = cursor.getString(12);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/ncdserviceDescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&DIRECTION="+DIRECTION+"&SERVICE="+SERVICE+"&RESPONSIBLENAME="+RESPONSIBLENAME+"&CURRENTDATA="+CURRENTDATA+"&RESPONSIBLEPHOTO="+RESPONSIBLEPHOTO+"&AREA="+AREA+"&REQUESTEDLISTOFSUPPLIES="+REQUESTEDLISTOFSUPPLIES+"&CURRENTLISTOFSUPPLIES="+CURRENTLISTOFSUPPLIES+"&HYGIENE="+HYGIENE+"&HANDHYGIENE="+HANDHYGIENE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updatencd_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read ceho _servicedescription
    public void readCehoServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getceho_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,DIRECTION,SERVICE,RESPONSIBLENAME,CURRENTDATA,RESPONSIBLEPHOTO,AREA,REQUESTEDLISTOFSUPPLIES,CURRENTLISTOFSUPPLIES,HYGIENE,HANDHYGIENE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                DIRECTION = cursor.getString(3);
                SERVICE = cursor.getString(4);
                RESPONSIBLENAME = cursor.getString(5);
                CURRENTDATA = cursor.getString(6);
                RESPONSIBLEPHOTO = cursor.getString(7);
                AREA = cursor.getString(8);
                REQUESTEDLISTOFSUPPLIES = cursor.getString(9);
                CURRENTLISTOFSUPPLIES = cursor.getString(10);
                HYGIENE = cursor.getString(11);
                HANDHYGIENE = cursor.getString(12);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/cehoserviceDescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&DIRECTION="+DIRECTION+"&SERVICE="+SERVICE+"&RESPONSIBLENAME="+RESPONSIBLENAME+"&CURRENTDATA="+CURRENTDATA+"&RESPONSIBLEPHOTO="+RESPONSIBLEPHOTO+"&AREA="+AREA+"&REQUESTEDLISTOFSUPPLIES="+REQUESTEDLISTOFSUPPLIES+"&CURRENTLISTOFSUPPLIES="+CURRENTLISTOFSUPPLIES+"&HYGIENE="+HYGIENE+"&HANDHYGIENE="+HANDHYGIENE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateceho_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read cahier _servicedescription
    public void readCashierServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getcashier_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,DIRECTION,SERVICE,RESPONSIBLENAME,CURRENTDATA,RESPONSIBLEPHOTO,AREA,REQUESTEDLISTOFSUPPLIES,CURRENTLISTOFSUPPLIES,HYGIENE,HANDHYGIENE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                DIRECTION = cursor.getString(3);
                SERVICE = cursor.getString(4);
                RESPONSIBLENAME = cursor.getString(5);
                CURRENTDATA = cursor.getString(6);
                RESPONSIBLEPHOTO = cursor.getString(7);
                AREA = cursor.getString(8);
                REQUESTEDLISTOFSUPPLIES = cursor.getString(9);
                CURRENTLISTOFSUPPLIES = cursor.getString(10);
                HYGIENE = cursor.getString(11);
                HANDHYGIENE = cursor.getString(12);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/cashierserviceDescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&DIRECTION="+DIRECTION+"&SERVICE="+SERVICE+"&RESPONSIBLENAME="+RESPONSIBLENAME+"&CURRENTDATA="+CURRENTDATA+"&RESPONSIBLEPHOTO="+RESPONSIBLEPHOTO+"&AREA="+AREA+"&REQUESTEDLISTOFSUPPLIES="+REQUESTEDLISTOFSUPPLIES+"&CURRENTLISTOFSUPPLIES="+CURRENTLISTOFSUPPLIES+"&HYGIENE="+HYGIENE+"&HANDHYGIENE="+HANDHYGIENE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updatecashier_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read Accounting _servicedescription
    public void readAccountingServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getAccounting_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,DIRECTION,SERVICE,RESPONSIBLENAME,CURRENTDATA,RESPONSIBLEPHOTO,AREA,REQUESTEDLISTOFSUPPLIES,CURRENTLISTOFSUPPLIES,HYGIENE,HANDHYGIENE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                DIRECTION = cursor.getString(3);
                SERVICE = cursor.getString(4);
                RESPONSIBLENAME = cursor.getString(5);
                CURRENTDATA = cursor.getString(6);
                RESPONSIBLEPHOTO = cursor.getString(7);
                AREA = cursor.getString(8);
                REQUESTEDLISTOFSUPPLIES = cursor.getString(9);
                CURRENTLISTOFSUPPLIES = cursor.getString(10);
                HYGIENE = cursor.getString(11);
                HANDHYGIENE = cursor.getString(12);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/AccountserviceDescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&DIRECTION="+DIRECTION+"&SERVICE="+SERVICE+"&RESPONSIBLENAME="+RESPONSIBLENAME+"&CURRENTDATA="+CURRENTDATA+"&RESPONSIBLEPHOTO="+RESPONSIBLEPHOTO+"&AREA="+AREA+"&REQUESTEDLISTOFSUPPLIES="+REQUESTEDLISTOFSUPPLIES+"&CURRENTLISTOFSUPPLIES="+CURRENTLISTOFSUPPLIES+"&HYGIENE="+HYGIENE+"&HANDHYGIENE="+HANDHYGIENE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateAccounting_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read laboratory _servicedescription
    public void readLaboratoryServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getLaboratory_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,DIRECTION,SERVICE,RESPONSIBLENAME,CURRENTDATA,RESPONSIBLEPHOTO,AREA,REQUESTEDLISTOFSUPPLIES,CURRENTLISTOFSUPPLIES,HYGIENE,HANDHYGIENE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                DIRECTION = cursor.getString(3);
                SERVICE = cursor.getString(4);
                RESPONSIBLENAME = cursor.getString(5);
                CURRENTDATA = cursor.getString(6);
                RESPONSIBLEPHOTO = cursor.getString(7);
                AREA = cursor.getString(8);
                REQUESTEDLISTOFSUPPLIES = cursor.getString(9);
                CURRENTLISTOFSUPPLIES = cursor.getString(10);
                HYGIENE = cursor.getString(11);
                HANDHYGIENE = cursor.getString(12);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/LaboratoryerviceDescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&DIRECTION="+DIRECTION+"&SERVICE="+SERVICE+"&RESPONSIBLENAME="+RESPONSIBLENAME+"&CURRENTDATA="+CURRENTDATA+"&RESPONSIBLEPHOTO="+RESPONSIBLEPHOTO+"&AREA="+AREA+"&REQUESTEDLISTOFSUPPLIES="+REQUESTEDLISTOFSUPPLIES+"&CURRENTLISTOFSUPPLIES="+CURRENTLISTOFSUPPLIES+"&HYGIENE="+HYGIENE+"&HANDHYGIENE="+HANDHYGIENE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateLaboratory_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read Titulaire _servicedescription
    public void readTitulaireServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getTitulaire_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,DIRECTION,SERVICE,RESPONSIBLENAME,CURRENTDATA,RESPONSIBLEPHOTO,AREA,REQUESTEDLISTOFSUPPLIES,CURRENTLISTOFSUPPLIES,HYGIENE,HANDHYGIENE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                DIRECTION = cursor.getString(3);
                SERVICE = cursor.getString(4);
                RESPONSIBLENAME = cursor.getString(5);
                CURRENTDATA = cursor.getString(6);
                RESPONSIBLEPHOTO = cursor.getString(7);
                AREA = cursor.getString(8);
                REQUESTEDLISTOFSUPPLIES = cursor.getString(9);
                CURRENTLISTOFSUPPLIES = cursor.getString(10);
                HYGIENE = cursor.getString(11);
                HANDHYGIENE = cursor.getString(12);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/TitulaireserviceDescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&DIRECTION="+DIRECTION+"&SERVICE="+SERVICE+"&RESPONSIBLENAME="+RESPONSIBLENAME+"&CURRENTDATA="+CURRENTDATA+"&RESPONSIBLEPHOTO="+RESPONSIBLEPHOTO+"&AREA="+AREA+"&REQUESTEDLISTOFSUPPLIES="+REQUESTEDLISTOFSUPPLIES+"&CURRENTLISTOFSUPPLIES="+CURRENTLISTOFSUPPLIES+"&HYGIENE="+HYGIENE+"&HANDHYGIENE="+HANDHYGIENE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateTitulaire_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read dataManager _servicedescription
    public void readDataManagerServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getDataman_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,DIRECTION,SERVICE,RESPONSIBLENAME,CURRENTDATA,RESPONSIBLEPHOTO,AREA,REQUESTEDLISTOFSUPPLIES,CURRENTLISTOFSUPPLIES,HYGIENE,HANDHYGIENE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                DIRECTION = cursor.getString(3);
                SERVICE = cursor.getString(4);
                RESPONSIBLENAME = cursor.getString(5);
                CURRENTDATA = cursor.getString(6);
                RESPONSIBLEPHOTO = cursor.getString(7);
                AREA = cursor.getString(8);
                REQUESTEDLISTOFSUPPLIES = cursor.getString(9);
                CURRENTLISTOFSUPPLIES = cursor.getString(10);
                HYGIENE = cursor.getString(11);
                HANDHYGIENE = cursor.getString(12);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/DAtamanservicedescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&DIRECTION="+DIRECTION+"&SERVICE="+SERVICE+"&RESPONSIBLENAME="+RESPONSIBLENAME+"&CURRENTDATA="+CURRENTDATA+"&RESPONSIBLEPHOTO="+RESPONSIBLEPHOTO+"&AREA="+AREA+"&REQUESTEDLISTOFSUPPLIES="+REQUESTEDLISTOFSUPPLIES+"&CURRENTLISTOFSUPPLIES="+CURRENTLISTOFSUPPLIES+"&HYGIENE="+HYGIENE+"&HANDHYGIENE="+HANDHYGIENE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateDataman_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read ARV  _servicedescription
    public void readDataARVServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getArv_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,DIRECTION,SERVICE,RESPONSIBLENAME,CURRENTDATA,RESPONSIBLEPHOTO,AREA,REQUESTEDLISTOFSUPPLIES,CURRENTLISTOFSUPPLIES,HYGIENE,HANDHYGIENE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                DIRECTION = cursor.getString(3);
                SERVICE = cursor.getString(4);
                RESPONSIBLENAME = cursor.getString(5);
                CURRENTDATA = cursor.getString(6);
                RESPONSIBLEPHOTO = cursor.getString(7);
                AREA = cursor.getString(8);
                REQUESTEDLISTOFSUPPLIES = cursor.getString(9);
                CURRENTLISTOFSUPPLIES = cursor.getString(10);
                HYGIENE = cursor.getString(11);
                HANDHYGIENE = cursor.getString(12);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/arvservicedescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&DIRECTION="+DIRECTION+"&SERVICE="+SERVICE+"&RESPONSIBLENAME="+RESPONSIBLENAME+"&CURRENTDATA="+CURRENTDATA+"&RESPONSIBLEPHOTO="+RESPONSIBLEPHOTO+"&AREA="+AREA+"&REQUESTEDLISTOFSUPPLIES="+REQUESTEDLISTOFSUPPLIES+"&CURRENTLISTOFSUPPLIES="+CURRENTLISTOFSUPPLIES+"&HYGIENE="+HYGIENE+"&HANDHYGIENE="+HANDHYGIENE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateArv_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read customer care  _servicedescription
    public void readCustoCareServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getCustoCare_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,DIRECTION,SERVICE,RESPONSIBLENAME,CURRENTDATA,RESPONSIBLEPHOTO,AREA,REQUESTEDLISTOFSUPPLIES,CURRENTLISTOFSUPPLIES,HYGIENE,HANDHYGIENE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                DIRECTION = cursor.getString(3);
                SERVICE = cursor.getString(4);
                RESPONSIBLENAME = cursor.getString(5);
                CURRENTDATA = cursor.getString(6);
                RESPONSIBLEPHOTO = cursor.getString(7);
                AREA = cursor.getString(8);
                REQUESTEDLISTOFSUPPLIES = cursor.getString(9);
                CURRENTLISTOFSUPPLIES = cursor.getString(10);
                HYGIENE = cursor.getString(11);
                HANDHYGIENE = cursor.getString(12);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/custocareservicedescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&DIRECTION="+DIRECTION+"&SERVICE="+SERVICE+"&RESPONSIBLENAME="+RESPONSIBLENAME+"&CURRENTDATA="+CURRENTDATA+"&RESPONSIBLEPHOTO="+RESPONSIBLEPHOTO+"&AREA="+AREA+"&REQUESTEDLISTOFSUPPLIES="+REQUESTEDLISTOFSUPPLIES+"&CURRENTLISTOFSUPPLIES="+CURRENTLISTOFSUPPLIES+"&HYGIENE="+HYGIENE+"&HANDHYGIENE="+HANDHYGIENE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateCustoCare_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read consultation room  _servicedescription
    public void readConsroomServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getConsroom_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,DIRECTION,SERVICE,RESPONSIBLENAME,CURRENTDATA,RESPONSIBLEPHOTO,AREA,REQUESTEDLISTOFSUPPLIES,CURRENTLISTOFSUPPLIES,HYGIENE,HANDHYGIENE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                DIRECTION = cursor.getString(3);
                SERVICE = cursor.getString(4);
                RESPONSIBLENAME = cursor.getString(5);
                CURRENTDATA = cursor.getString(6);
                RESPONSIBLEPHOTO = cursor.getString(7);
                AREA = cursor.getString(8);
                REQUESTEDLISTOFSUPPLIES = cursor.getString(9);
                CURRENTLISTOFSUPPLIES = cursor.getString(10);
                HYGIENE = cursor.getString(11);
                HANDHYGIENE = cursor.getString(12);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/consroomservicedescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&DIRECTION="+DIRECTION+"&SERVICE="+SERVICE+"&RESPONSIBLENAME="+RESPONSIBLENAME+"&CURRENTDATA="+CURRENTDATA+"&RESPONSIBLEPHOTO="+RESPONSIBLEPHOTO+"&AREA="+AREA+"&REQUESTEDLISTOFSUPPLIES="+REQUESTEDLISTOFSUPPLIES+"&CURRENTLISTOFSUPPLIES="+CURRENTLISTOFSUPPLIES+"&HYGIENE="+HYGIENE+"&HANDHYGIENE="+HANDHYGIENE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateConsroom_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read Maternity  _servicedescription
    public void readMaternityServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getMaternity_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,DIRECTION,SERVICE,RESPONSIBLENAME,CURRENTDATA,RESPONSIBLEPHOTO,AREA,REQUESTEDLISTOFSUPPLIES,CURRENTLISTOFSUPPLIES,HYGIENE,HANDHYGIENE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                DIRECTION = cursor.getString(3);
                SERVICE = cursor.getString(4);
                RESPONSIBLENAME = cursor.getString(5);
                CURRENTDATA = cursor.getString(6);
                RESPONSIBLEPHOTO = cursor.getString(7);
                AREA = cursor.getString(8);
                REQUESTEDLISTOFSUPPLIES = cursor.getString(9);
                CURRENTLISTOFSUPPLIES = cursor.getString(10);
                HYGIENE = cursor.getString(11);
                HANDHYGIENE = cursor.getString(12);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/maternityservicedescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&DIRECTION="+DIRECTION+"&SERVICE="+SERVICE+"&RESPONSIBLENAME="+RESPONSIBLENAME+"&CURRENTDATA="+CURRENTDATA+"&RESPONSIBLEPHOTO="+RESPONSIBLEPHOTO+"&AREA="+AREA+"&REQUESTEDLISTOFSUPPLIES="+REQUESTEDLISTOFSUPPLIES+"&CURRENTLISTOFSUPPLIES="+CURRENTLISTOFSUPPLIES+"&HYGIENE="+HYGIENE+"&HANDHYGIENE="+HANDHYGIENE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateMaternity_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read hosptalization rooom  _servicedescription
    public void readHospitalizationServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getHosproom_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,DIRECTION,SERVICE,RESPONSIBLENAME,CURRENTDATA,RESPONSIBLEPHOTO,AREA,REQUESTEDLISTOFSUPPLIES,CURRENTLISTOFSUPPLIES,HYGIENE,HANDHYGIENE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                DIRECTION = cursor.getString(3);
                SERVICE = cursor.getString(4);
                RESPONSIBLENAME = cursor.getString(5);
                CURRENTDATA = cursor.getString(6);
                RESPONSIBLEPHOTO = cursor.getString(7);
                AREA = cursor.getString(8);
                REQUESTEDLISTOFSUPPLIES = cursor.getString(9);
                CURRENTLISTOFSUPPLIES = cursor.getString(10);
                HYGIENE = cursor.getString(11);
                HANDHYGIENE = cursor.getString(12);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/Hosproomservicedescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&DIRECTION="+DIRECTION+"&SERVICE="+SERVICE+"&RESPONSIBLENAME="+RESPONSIBLENAME+"&CURRENTDATA="+CURRENTDATA+"&RESPONSIBLEPHOTO="+RESPONSIBLEPHOTO+"&AREA="+AREA+"&REQUESTEDLISTOFSUPPLIES="+REQUESTEDLISTOFSUPPLIES+"&CURRENTLISTOFSUPPLIES="+CURRENTLISTOFSUPPLIES+"&HYGIENE="+HYGIENE+"&HANDHYGIENE="+HANDHYGIENE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateHosproom_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read toilets rooom  _servicedescription
    public void readToiletsServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.gettoilets_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,DIRECTION,AREA,HYGIENE,HANDHYGIENE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                DIRECTION = cursor.getString(3);
                AREA = cursor.getString(4);
                HYGIENE = cursor.getString(5);
                HANDHYGIENE = cursor.getString(6);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/toiletsservicedescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&DIRECTION="+DIRECTION+"&AREA="+AREA+"&HYGIENE="+HYGIENE+"&HANDHYGIENE="+HANDHYGIENE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updatetoilets_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read notice board    _servicedescription
    public void readNoticeboardServicedescription(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getNoticeboard_servicedescription(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,CURRENTDATA;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                CURRENTDATA = cursor.getString(3);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/Noticeboardservicedescription.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&CURRENTDATA="+CURRENTDATA, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateNoticeboard_servicedescription("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read documentation action plan
    public void readdocumentation_Actionplan(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getDocumentation_actionplan(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,AVAILABLE,TRACKED,APPROVEDTI,APPROVEDCOSA,COMSTAFF;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                AVAILABLE = cursor.getString(3);
                TRACKED = cursor.getString(4);
                APPROVEDTI = cursor.getString(5);
                APPROVEDCOSA = cursor.getString(6);
                COMSTAFF = cursor.getString(7);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/documentation_actionplan.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&AVAILABLE="+AVAILABLE+"&TRACKED="+TRACKED+"&APPROVEDTI="+APPROVEDTI+"&APPROVEDCOSA="+APPROVEDCOSA+"&COMSTAFF="+COMSTAFF, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateDocumentation_actionplan("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read documentation business plan
    public void readdocumentation_Businessplan(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getDocumentation_businessplan(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,AVAILABLE,TRACKED,APPROVEDTI,COMSTAFF;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                AVAILABLE = cursor.getString(3);
                TRACKED = cursor.getString(4);
                APPROVEDTI = cursor.getString(5);
                COMSTAFF = cursor.getString(6);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/documentation_businessplan.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&AVAILABLE="+AVAILABLE+"&TRACKED="+TRACKED+"&APPROVEDTI="+APPROVEDTI+"&COMSTAFF="+COMSTAFF, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateDocumentation_businessplan("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read documentation budget plan
    public void readdocumentation_budgetplan(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getDocumentation_budgetplan(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,AVAILABLE,TRACKED,APPROVEDTI,APPROVEDCOSA,COMSTAFF;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                AVAILABLE = cursor.getString(3);
                TRACKED = cursor.getString(4);
                APPROVEDTI = cursor.getString(5);
                APPROVEDCOSA = cursor.getString(6);
                COMSTAFF = cursor.getString(7);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/documentation_budget.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&AVAILABLE="+AVAILABLE+"&TRACKED="+TRACKED+"&APPROVEDTI="+APPROVEDTI+"&APPROVEDCOSA="+APPROVEDCOSA+"&COMSTAFF="+COMSTAFF, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateDocumentation_budgetplan("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read documentation inservice plan
    public void readdocumentation_inservice(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getDocumentation_inservice(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,AVAILABLE,TRACKED,APPROVEDTI,COMSTAFF;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                AVAILABLE = cursor.getString(3);
                TRACKED = cursor.getString(4);
                APPROVEDTI = cursor.getString(5);
                COMSTAFF = cursor.getString(6);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/documentation_inservice.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&AVAILABLE="+AVAILABLE+"&TRACKED="+TRACKED+"&APPROVEDTI="+APPROVEDTI+"&COMSTAFF="+COMSTAFF, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateDocumentation_inservice("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read documentation workschedule plan
    public void readdocumentation_work(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getDocumentation_work(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,AVAILABLE,TRACKED,APPROVEDTI,COMSTAFF;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                AVAILABLE = cursor.getString(3);
                TRACKED = cursor.getString(4);
                APPROVEDTI = cursor.getString(5);
                COMSTAFF = cursor.getString(6);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/documentation_work.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&AVAILABLE="+AVAILABLE+"&TRACKED="+TRACKED+"&APPROVEDTI="+APPROVEDTI+"&COMSTAFF="+COMSTAFF, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateDocumentation_work("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read documentation QI plan
    public void readdocumentation_qi(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getDocumentation_qiplan(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,AVAILABLE,TRACKED,APPROVEDTI,COMSTAFF;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                AVAILABLE = cursor.getString(3);
                TRACKED = cursor.getString(4);
                APPROVEDTI = cursor.getString(5);
                COMSTAFF = cursor.getString(6);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/documentation_qiplan.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&AVAILABLE="+AVAILABLE+"&TRACKED="+TRACKED+"&APPROVEDTI="+APPROVEDTI+"&COMSTAFF="+COMSTAFF, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateDocumentation_qiplan("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read documentation external training plan
    public void readdocumentation_ExtTraining(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getDocumentation_externaltraining(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,AVAILABLE,TRACKED,APPROVEDTI,COMSTAFF;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                AVAILABLE = cursor.getString(3);
                TRACKED = cursor.getString(4);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/documentation_external.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&AVAILABLE="+AVAILABLE+"&TRACKED="+TRACKED, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateDocumentation_externaltraining("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read documentation attendance registers
    public void readdocumentation_attendanceRegister(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getDocumentation_attendanceregister(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,AVAILABLE,TRACKED,APPROVEDTI,COMSTAFF;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                AVAILABLE = cursor.getString(3);
                TRACKED = cursor.getString(4);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/documentation_attendance.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&AVAILABLE="+AVAILABLE+"&TRACKED="+TRACKED, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateDocumentation_attendanceregisters("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read documentation payable registers
    public void readdocumentation_payableRegister(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getDocumentation_payableregister(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,AVAILABLE,TRACKED,APPROVEDTI,COMSTAFF;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                AVAILABLE = cursor.getString(3);
                TRACKED = cursor.getString(4);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/documentation_payableregisters.php.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&AVAILABLE="+AVAILABLE+"&TRACKED="+TRACKED, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateDocumentation_payableregisters("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read documentation receivables registers
    public void readdocumentation_receivableRegister(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getDocumentation_receivableregister(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,AVAILABLE,TRACKED,APPROVEDTI,COMSTAFF;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                AVAILABLE = cursor.getString(3);
                TRACKED = cursor.getString(4);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/documentation_receivableregisters.php.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&AVAILABLE="+AVAILABLE+"&TRACKED="+TRACKED, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateDocumentation_receivableregisters("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read documentation Malaria plan
    public void readdocumentation_malariaPlan(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getDocumentation_malariaplan(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,AVAILABLE,TRACKED,APPROVED,COMSTAFF;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                AVAILABLE = cursor.getString(3);
                TRACKED = cursor.getString(4);
                APPROVED = cursor.getString(5);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/documentation_malariaplan.php.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&AVAILABLE="+AVAILABLE+"&TRACKED="+TRACKED+"&APPROVED="+APPROVED, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateDocumentation_malariaplan("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read documentation Malaria plan
    public void readdocumentation_customerCareProgram(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getDocumentation_CustomerCareProgram(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,AVAILABLE,TRACKED,APPROVED,COMSTAFF;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                AVAILABLE = cursor.getString(3);
                TRACKED = cursor.getString(4);
                APPROVED = cursor.getString(5);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/documentation_customerprogram.php.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&AVAILABLE="+AVAILABLE+"&TRACKED="+TRACKED+"&APPROVED="+APPROVED, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateDocumentation_CustomerCareprogram("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read documentation sanitation general information
    public void readdocumentation_generalSanitation(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getDocumentation_sanitation(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,STAFFLATRINES,PATIRNETLATRINES,TOTALLATRINES,BROKENLATRINES,CLEANLATRINES,ODORLESSLATRINES,HANDWASHLATRINES,LATRINESCHEDULES;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                STAFFLATRINES = cursor.getString(3);
                PATIRNETLATRINES = cursor.getString(4);
                TOTALLATRINES = cursor.getString(5);
                BROKENLATRINES = cursor.getString(6);
                CLEANLATRINES = cursor.getString(7);
                ODORLESSLATRINES = cursor.getString(8);
                HANDWASHLATRINES = cursor.getString(9);
                LATRINESCHEDULES = cursor.getString(10);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/documentation_generalSanitation.php.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&STAFFLATRINES="+STAFFLATRINES+"&PATIRNETLATRINES="+PATIRNETLATRINES+"&TOTALLATRINES="+TOTALLATRINES+"&BROKENLATRINES="+BROKENLATRINES+"&CLEANLATRINES="+CLEANLATRINES+"&ODORLESSLATRINES="+ODORLESSLATRINES+"&HANDWASHLATRINES="+HANDWASHLATRINES+"&LATRINESCHEDULES="+LATRINESCHEDULES, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateDocumentation_sanitation("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read  data managemnt sop
    public void readData_DataManagementSOP(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getdata_datamanagemntSOP(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,AVAILABLE,SIGNED,TOTALLATRINES,SUBMITED,DMAVAILABLE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                AVAILABLE = cursor.getString(3);
                SIGNED = cursor.getString(4);
                SUBMITED = cursor.getString(5);
                DMAVAILABLE = cursor.getString(6);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/documentation_datamanagementsop.php.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&AVAILABLE="+AVAILABLE+"&SIGNED="+SIGNED+"&SUBMITED="+SUBMITED+"&DMAVAILABLE="+DMAVAILABLE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateData_datamanagementSOP("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read  data managemnt deliveries
    public void readData_DataManagementdeliveries(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getData_datamanagementDeliveries(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,PATIENTFILE,REGISTER,HMIS_HARDCOPY,HMIS_SOFTCOPY,ACCURATE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                PATIENTFILE = cursor.getString(3);
                REGISTER = cursor.getString(4);
                HMIS_HARDCOPY = cursor.getString(5);
                HMIS_SOFTCOPY = cursor.getString(6);
                ACCURATE = cursor.getString(7);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/data_deliveries.php.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&PATIENTFILE="+PATIENTFILE+"&REGISTER="+REGISTER+"&HMIS_HARDCOPY="+HMIS_HARDCOPY+"&HMIS_SOFTCOPY="+HMIS_SOFTCOPY+"&ACCURATE="+ACCURATE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateData_datamanagementDeliveries("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read  data managemnt NCD
    public void readData_DataManagementNCD(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getData_datamanagementNCD(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,PATIENTFILE,REGISTER,HMIS_HARDCOPY,HMIS_SOFTCOPY,ACCURATE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                PATIENTFILE = cursor.getString(3);
                REGISTER = cursor.getString(4);
                HMIS_HARDCOPY = cursor.getString(5);
                HMIS_SOFTCOPY = cursor.getString(6);
                ACCURATE = cursor.getString(7);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/data_ncd.php.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&PATIENTFILE="+PATIENTFILE+"&REGISTER="+REGISTER+"&HMIS_HARDCOPY="+HMIS_HARDCOPY+"&HMIS_SOFTCOPY="+HMIS_SOFTCOPY+"&ACCURATE="+ACCURATE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateData_datamanagementNCD("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read  data managemnt BCG
    public void readData_DataManagementBCG(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getData_datamanagementBCG(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,PATIENTFILE,REGISTER,HMIS_HARDCOPY,HMIS_SOFTCOPY,ACCURATE;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                PATIENTFILE = cursor.getString(3);
                REGISTER = cursor.getString(4);
                HMIS_HARDCOPY = cursor.getString(5);
                HMIS_SOFTCOPY = cursor.getString(6);
                ACCURATE = cursor.getString(7);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/data_bcg.php.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&PATIENTFILE="+PATIENTFILE+"&REGISTER="+REGISTER+"&HMIS_HARDCOPY="+HMIS_HARDCOPY+"&HMIS_SOFTCOPY="+HMIS_SOFTCOPY+"&ACCURATE="+ACCURATE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateData_datamanagementBCG("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }

    //read  data managemnt BCG
    public void readData_DataCasesMalaria(){
        String status_id="0";
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = Databasehelper.getData_MalariaCases(status_id,sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                final String YEAR,DISTRICT,HC,PATIENTFILE,REGISTER,HMIS_HARDCOPY,HMIS_SOFTCOPY,ACCURATE,LABREGISTER,PHARMACY;
                YEAR = cursor.getString(0);
                DISTRICT = cursor.getString(1);
                HC = cursor.getString(2);
                PATIENTFILE = cursor.getString(3);
                REGISTER = cursor.getString(4);
                HMIS_HARDCOPY = cursor.getString(5);
                HMIS_SOFTCOPY = cursor.getString(6);
                ACCURATE = cursor.getString(7);
                LABREGISTER = cursor.getString(8);
                PHARMACY = cursor.getString(10);


                final StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://report.healthbuilders.org/app/data_malariacases.php.php?YEAR="+YEAR+"&DISTRICT="+DISTRICT+"&HC="+HC+"&PATIENTFILE="+PATIENTFILE+"&REGISTER="+REGISTER+"&HMIS_HARDCOPY="+HMIS_HARDCOPY+"&HMIS_SOFTCOPY="+HMIS_SOFTCOPY+"&ACCURATE="+ACCURATE+"&LABREGISTER="+LABREGISTER+"&PHARMACY="+PHARMACY, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
                    @Nullable
                    @Override
                    public Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String,String>();
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                VolleyLog.DEBUG = true;
                requestQueue.add(stringRequest);

            }while (cursor.moveToNext());
            int count = Databasehelper.updateData_MalariaCases("0","1",sqLiteDatabase);
            Toast.makeText(getApplicationContext(),count+" data updated",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }

    }


    //end for sync functions

    public boolean checkNetwork(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}