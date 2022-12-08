package com.healthBuilders.surveyApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Databasehelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "hbexercise";
    private static final String TABLE_NAME = "users";

    private static final String COL_1 = "ID";
    private static final String COL_2 = "FNAME";
    private static final String COL_3 = "LNAME";
    private static final String COL_4 = "EMAIL";
    private static final String COL_5 = "PASSWORD";

    private static final String TABLE_NAME2 = "BASIC_INFO";
    private static final String COL2_1 = "year";
    private static final String COL2_2 = "district";
    private static final String COL2_3 = "hc";
    private static final String COL2_4 = "sector";
    private static final String COL2_5 = "cell";
    private static final String COL2_6 = "village";
    private static final String COL2_7 = "pubpost";
    private static final String COL2_8 = "pripost";
    private static final String COL2_9 = "population";
    private static final String COL2_10 = "patients";
    private static final String COL2_11 = "beds";
    private static final String COL2_12 = "consrooms";
    private static final String COL2_13 = "hosprooms";
    private static final String COL2_14 = "chw";
    private static final String COL2_15 = "a0";
    private static final String COL2_16 = "a1";
    private static final String COL2_17 = "a2";
    private static final String COL2_18 = "midwife";

    private static final String TABLE_NAME3="BASIC_INFO2";
    private static final String COL3_1 = "year";
    private static final String COL3_2 = "district";
    private static final String COL3_3 = "hc";
    private static final String COL3_4 = "organi";
    private static final String COL3_5 = "uptodate";
    private static final String COL3_6 = "accessible";
    private static final String COL3_7 = "labtecav";
    private static final String COL3_8 = "labsign";
    private static final String COL3_9 = "labemp";
    private static final String COL3_10 = "nursearv";
    private static final String COL3_11 = "nursearsign";
    private static final String COL3_12 = "nursearempsign";
    private static final String COL3_13 = "nursevacav";
    private static final String COL3_14 = "nursevacsign";
    private static final String COL3_15 = "nursevacempsign";
    private static final String COL3_16 = "custocareav";
    private static final String COL3_17 = "custcaresign";
    private static final String COL3_18 = "custcareemppsign";
    private static final String COL3_19 = "nursetbav";
    private static final String COL3_20 = "nursetbsign";
    private static final String COL3_21 = "nursetbempsign";
    private static final String COL3_22 = "nursechi";
    private static final String COL3_23 = "nursechisign";
    private static final String COL3_24 = "nursechiempsign";
    private static final String COL3_25 = "socialav";
    private static final String COL3_26 = "socialsign";
    private static final String COL3_27= "socialempsign";
    private static final String COL3_28 = "nursecpnav";
    private static final String COL3_29 = "nursecpnsign";
    private static final String COL3_30 = "nursecpnempsign";
    private static final String COL3_31 = "midwifeav";
    private static final String COL3_32 = "midwifesign";
    private static final String COL3_33 = "midwifeempsign";
    private static final String COL3_34 = "SOPpharmacy";
    private static final String COL3_35 = "evidence";
    private static final String COL3_36 = "qicomitee";
    private static final String COL3_37 = "totstaff";
    private static final String COL3_38 = "totnurse";
    private static final String COL3_39 = "paidstaff";
    private static final String COL3_40 = "clinicalstaff";
    private static final String COL3_41 = "tbstaff";
    private static final String COL3_42 = "staffinfection";
    private static final String COL3_43 = "staffcovid";
    private static final String COL3_44 = "staffevaluated";
    private static final String COL3_45= "staffillness";
    private static final String COL3_46 = "staffinjuries";
    private static final String COL3_47= "staffhepatite";
    private static final String COL3_48= "staffrate";
    private static final String COL3_49= "patientrate";
    private static final String COL3_50= "staffmetting";
    private static final String COL3_51= "cosametting";



    //Service description table
    private static final String TABLE_NAME4="Anc_servicedescription";
    private static final String anc_1= "year";
    private static final String anc_2= "district";
    private static final String anc_3= "hc";
    private static final String anc_4= "direction";
    private static final String anc_5= "service";
    private static final String anc_6= "responsiblename";
    private static final String anc_7= "currentdata";
    private static final String anc_8= "responsiblephoto";
    private static final String anc_9= "area";
    private static final String anc_10= "requestedlistofsupplies";
    private static final String anc_11= "currentlistofsupplies";
    private static final String anc_12= "hygiene";
    private static final String anc_13= "handhygiene";

    private static final String TABLE_NAME5="vaccinaion_description";
    private static final String TABLE_NAME6="familyplanning_description";
    private static final String TABLE_NAME7="pharmacystock_description";
    private static final String TABLE_NAME8="pharmacydispensing_description";
    private static final String TABLE_NAME9="ncd_description";
    private static final String TABLE_NAME10="ceho_description";
    private static final String TABLE_NAME11="cashier_description";
    private static final String TABLE_NAME12="accounting_description";
    private static final String TABLE_NAME13="laboratory_description";
    private static final String TABLE_NAME14="titulaire_description";
    private static final String TABLE_NAME15="datamanager_description";
    private static final String TABLE_NAME16="arv_description";
    private static final String TABLE_NAME17="customercare_description";
    private static final String TABLE_NAME18="consultationroom_description";
    private static final String TABLE_NAME19="maternity_description";
    private static final String TABLE_NAME20="hospitalization_description";
    private static final String TABLE_NAME21="toilets_description";
    private static final String TABLE_NAME22="noticeboard_description";

    //documentation and sanitation
    private static final String TABLE_NAME23="documentation_actionplan";
    private static final String TABLE_NAME24="documentation_businessplan";
    private static final String TABLE_NAME25="documentation_budget";
    private static final String TABLE_NAME26="documentation_inservice";
    private static final String TABLE_NAME27="documentation_workschedule";
    private static final String TABLE_NAME28="documentation_qiplan";
    private static final String TABLE_NAME29="external_trainings";
    private static final String TABLE_NAME30="attendance_register";
    private static final String TABLE_NAME31="payables_register";
    private static final String TABLE_NAME32="receivables_register";
    private static final String TABLE_NAME33="malaria_plan";
    private static final String TABLE_NAME34="customercare_program";
    private static final String TABLE_NAME35="sanitation";
    private static final String TABLE_NAME36="datamanagement_sop";
    private static final String TABLE_NAME37="datamanagement_deliveries";
    private static final String TABLE_NAME38="datamanagement_NCD";
    private static final String TABLE_NAME39="datamanagement_BCG";
    private static final String TABLE_NAME40="datamanagement_Malaria";
    private static final String TABLE_NAME41="datamanagement_opdregisters";
    private static final String TABLE_NAME42="maternal_neonatal";

    private static final String doc_1= "year";
    private static final String doc_2= "district";
    private static final String doc_3= "hc";
    private static final String doc_4= "available";
    private static final String doc_5= "tracked";
    private static final String doc_6= "approvedti";
    private static final String doc_7= "approvedcosa";
    private static final String doc_8= "comstaff";
    private static final String doc_9= "approved";


    //sanitation
    private static final String s1= "year";
    private static final String s2= "district";
    private static final String s3= "hc";
    private static final String s4= "STAFFLATRINES";
    private static final String s5= "PATIRNETLATRINES";
    private static final String s6= "TOTALLATRINES";
    private static final String s7= "BROKENLATRINES";
    private static final String s8= "CLEANLATRINES";
    private static final String s9= "ODORLESSLATRINES";
    private static final String s10= "HANDWASHLATRINES";
    private static final String s11= "LATRINESCHEDULES";
    private static final String s12= "OPD";
    private static final String s13= "HOSPITALIZATIONROOMS";

    //data management SOP
    private static final String d1= "year";
    private static final String d2= "district";
    private static final String d3= "hc";
    private static final String d4= "available";
    private static final String d5= "signed";
    private static final String d6= "submited";
    private static final String d7= "dmavailable";

    //data management data accuracy deliveries
    private static final String de1= "year";
    private static final String de2= "district";
    private static final String de3= "hc";
    private static final String de4= "patientfile";
    private static final String de5= "register";
    private static final String de6= "hmis_hardcopy";
    private static final String de7= "hmis_softcopy";
    private static final String de8= "accurate";
    private static final String de10= "labregister";

    //opd registers
    private static final String opd1= "year";
    private static final String opd2= "district";
    private static final String opd3= "hc";
    private static final String opd4= "lines";
    private static final String opd5= "fields";
    private static final String opd6= "blanks";

    ///maternity and neonatal health
    private static final String m1="year";
    private static final String m2="district";
    private static final String m3="hc";
    private static final String m4="maternalyear";
    private static final String m5="obsetricalANC";
    private static final String m6="registrations";
    private static final String m7="referalsANC";
    private static final String m8="obsetricalMaternity";
    private static final String m9="deliveries";
    private static final String m10="livebirths";
    private static final String m11="maternaldeaths";
    private static final String m12="neonataldeaths";
    private static final String m13="stillbirths";
    private static final String m14="postpartun";
    private static final String m15="anc4";
    private static final String m16="anc1";
    private static final String m17="underfivedeaths";
    private static final String m18="childrenconsulted";
    private static final String m19="contraceptiveusers";
    private static final String m20="mr2vaccines";
    private static final String m21="ultrasoundscans";













    public Databasehelper(@Nullable Context context ) {
        super(context, DATABASE_NAME, null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, FNAME TEXT, LNAME TEXT, EMAIL TEXT,PASSWORD TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME2 + "(YEAR TEXT, DISTRICT TEXT, HC TEXT,SECTOR TEXT, CELL TEXT,VILLAGE TEXT, PUBPOST TEXT, PRIPOST TEXT,POPULATION TEXT,PATIENTS TEXT,BEDS TEXT, CONSROOMS TEXT,HOSPROOMS TEXT,CHW TEXT,A0 TEXT,A1 TEXT,A2 TEXT,MIDWIFE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME3 + "(YEAR TEXT, DISTRICT TEXT, HC TEXT,ORGANI TEXT, UPTODATE TEXT,ACCESSIBLE TEXT, LABTECAV TEXT,LABSIGN TEXT,LABEMP TEXT,NURSEARV TEXT,NURSEARSIGN TEXT,NURSEAREMPSIGN TEXT,NURSEVACAV TEXT,NURSEVACSIGN TEXT,NURSEVACEMPSIGN TEXT,CUSTOCAREAV TEXT,CUSTCARESIGN TEXT,CUSTCAREEMPPSIGN TEXT,NURSETBAV TEXT,NURSETBSIGN TEXT,NURSETBEMPSIGN TEXT,NURSECHI TEXT,NURSECHISIGN TEXT,NURSECHIEMPSIGN TEXT,SOCIALAV TEXT,SOCIALSIGN TEXT,SOCIALEMPSIGN TEXT,NURSECPNAV TEXT,NURSECPNSIGN TEXT,NURSECPNEMPSIGN TEXT,MIDWIFEAV TEXT,MIDWIFESIGN TEXT,MIDWIFEEMPSIGN TEXT,SOPPHARMACY TEXT,EVIDENCE TEXT,QICOMITEE TEXT,TOTSTAFF TEXT,TOTNURSE TEXT,PAIDSTAFF TEXT,CLINICALSTAFF TEXT,TBSTAFF TEXT,STAFFINFECTION TEXT,STAFFCOVID TEXT,STAFFEVALUATED TEXT,STAFFILLNESS TEXT,STAFFINJURIES TEXT,STAFFHEPATITE TEXT,STAFFRATE TEXT,PATIENTRATE TEXT,STAFFMETTING TEXT,COSAMETTING TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME4 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME5 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME6 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME7 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME8 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME9 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME10 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME11 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME12 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME13 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME14 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME15 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME16 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME17 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME18 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME19 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME20 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME21 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME22 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,CURRENTDATA TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME23 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVEDTI TEXT,APPROVEDCOSA TEXT,COMSTAFF TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME24 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVEDTI TEXT,APPROVEDCOSA TEXT,COMSTAFF TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME25 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVEDTI TEXT,APPROVEDCOSA TEXT,COMSTAFF TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME26 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVEDTI TEXT,APPROVEDCOSA TEXT,COMSTAFF TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME27   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVEDTI TEXT,APPROVEDCOSA TEXT,COMSTAFF TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME28   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVEDTI TEXT,APPROVEDCOSA TEXT,COMSTAFF TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME29   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME30   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME31   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME32   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME33   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVED TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME34   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVED TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME35 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,STAFFLATRINES TEXT,PATIRNETLATRINES TEXT,TOTALLATRINES TEXT,BROKENLATRINES TEXT,CLEANLATRINES TEXT,ODORLESSLATRINES TEXT,HANDWASHLATRINES TEXT,LATRINESCHEDULES,OPD TEXT,HOSPITALIZATIONROOMS TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME36   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,SIGNED TEXT,SUBMITED TEXT,DMAVAILABLE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME37   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,PATIENTFILE TEXT,REGISTER TEXT,HMIS_HARDCOPY TEXT,HMIS_SOFTCOPY TEXT,ACCURATE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME38   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,PATIENTFILE TEXT,REGISTER TEXT,HMIS_HARDCOPY TEXT,HMIS_SOFTCOPY TEXT,ACCURATE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME39   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,PATIENTFILE TEXT,REGISTER TEXT,HMIS_HARDCOPY TEXT,HMIS_SOFTCOPY TEXT,ACCURATE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME40   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,PATIENTFILE TEXT,REGISTER TEXT,HMIS_HARDCOPY TEXT,HMIS_SOFTCOPY TEXT,LABREGISTER TEXT,ACCURATE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME41   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,LINES TEXT,FIELDS TEXT,BLANKS TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME42   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,maternalyear TEXT,obsetricalANC TEXT,registrations TEXT,referalsANC TEXT,obsetricalMaternity TEXT,deliveries TEXT,livebirths TEXT,maternaldeaths TEXT,neonataldeaths TEXT,stillbirths TEXT,postpartun TEXT,anc4 TEXT,anc1 TEXT,underfivedeaths TEXT,childrenconsulted TEXT,contraceptiveusers TEXT,mr2vaccines TEXT,ultrasoundscans TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME4);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME5);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME6);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME7);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME8);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME9);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME10);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME11);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME12);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME13);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME14);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME15);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME16);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME17);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME18);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME19);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME20);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME21);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME22);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME23);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME24);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME25);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME26);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME27);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME28);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME29);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME30);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME31);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME32);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME33);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME34);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME35);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME36);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME37);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME38);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME39);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME40);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME41);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME42);
        onCreate(db);
    }

    public boolean registerUSer(String firstname,String lastname, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, firstname);
        values.put(COL_3, lastname);
        values.put(COL_4, email);
        values.put(COL_5, password);


        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerBasicInformation(String year, String district, String hc, String sector, String cell, String village, String pubpost, String pripost, String population, String patients, String beds, String consrooms, String hosprooms, String chw, String a0, String a1,String a2, String midwives){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL2_1,year);
        values.put(COL2_2,district);
        values.put(COL2_3,hc);
        values.put(COL2_4,sector);
        values.put(COL2_5,cell);
        values.put(COL2_6,village);
        values.put(COL2_7,pubpost);
        values.put(COL2_8,pripost);
        values.put(COL2_9,population);
        values.put(COL2_10,patients);
        values.put(COL2_11,beds);
        values.put(COL2_12,consrooms);
        values.put(COL2_13,hosprooms);
        values.put(COL2_14,chw);
        values.put(COL2_15,a0);
        values.put(COL2_16,a1);
        values.put(COL2_17,a2);
        values.put(COL2_18,midwives);

        long result = db.insert(TABLE_NAME2, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean registerAncServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME4, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerVacServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME5, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerFpServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME6, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerPharmacyServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME7, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerPharmacyDispenseServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME8, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerNcdServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME9, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerCehoServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME10, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerCashierServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME11, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerAccountingServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME12, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerLaboratoryServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME13, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerTitulaireServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME14, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDataManagerServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME15, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerArvServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME16, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerCustomerCareServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME17, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerConsultationServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME18, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerMaternityServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME19, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerHospitalizationServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME20, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerToiletsServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME21, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerTNoticeBoardCurrentDataServiceDescription(String year, String district, String hc,String currentdata){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,currentdata);

        long result = db.insert(TABLE_NAME22, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }


        public boolean registerBasicInformation2(String year, String district, String hc, String organi,String uptodate,String accessible,String  labtecav,
                                             String  labsign, String  labemp, String  nursearv, String  nursearsign, String  nursearempsign, String  nursevacav,
                                             String  nursevacsign ,String  nursevacempsign,
                                             String  custocareav, String  custcaresign, String  custcareemppsign, String  nursetbav ,String  nursetbsign ,
                                             String  nursetbempsign, String  nursechi, String  nursechisign ,String  nursechiempsign ,String  socialav ,
                                             String socialsign ,String  socialempsign ,String  nursecpnav ,String  nursecpnsign ,String  nursecpnempsign ,
                                             String  midwifeav, String  midwifesign, String  midwifeempsign ,String  SOPpharmacy, String  evidence,
                                             String  qicomitee ,String  totstaff ,String  totnurse, String  paidstaff ,String  clinicalstaff,
                                             String  tbstaff ,String  staffinfection, String  staffcovid ,String  staffevaluated ,
                                             String  staffillness ,String  staffinjuries ,String  staffhepatite, String  staffrate ,
                                             String  patientrate ,String  staffmetting, String cosametting ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put( COL3_1 ,year);
        values.put( COL3_2 ,district);
        values.put( COL3_3 ,hc);
        values.put( COL3_4 ,organi);
        values.put( COL3_5 ,uptodate);
        values.put( COL3_6 ,accessible);
        values.put( COL3_7 ,labtecav);
        values.put( COL3_8 ,labsign);
        values.put( COL3_9 ,labemp);
        values.put( COL3_10 ,nursearv);
        values.put( COL3_11 ,nursearsign);
        values.put( COL3_12 ,nursearempsign);
        values.put( COL3_13 ,nursevacav);
        values.put( COL3_14 ,nursevacsign);
        values.put( COL3_15 ,nursevacempsign);
        values.put( COL3_16 ,custocareav);
        values.put( COL3_17 ,custcaresign);
        values.put( COL3_18 ,custcareemppsign);
        values.put( COL3_19 ,nursetbav);
        values.put( COL3_20 ,nursetbsign);
        values.put( COL3_21 ,nursetbempsign);
        values.put( COL3_22 ,nursechi);
        values.put( COL3_23 ,nursechisign);
        values.put( COL3_24 ,nursechiempsign);
        values.put( COL3_25 ,socialav);
        values.put( COL3_26 ,socialsign);
        values.put( COL3_27,socialempsign);
        values.put( COL3_28 ,nursecpnav);
        values.put( COL3_29 ,nursecpnsign);
        values.put( COL3_30 ,nursecpnempsign);
        values.put( COL3_31 ,midwifeav);
        values.put( COL3_32 ,midwifesign);
        values.put( COL3_33 ,midwifeempsign);
        values.put( COL3_34 ,SOPpharmacy);
        values.put( COL3_35 ,evidence);
        values.put( COL3_36 ,qicomitee);
        values.put( COL3_37 ,totstaff);
        values.put( COL3_38 ,totnurse);
        values.put( COL3_39 ,paidstaff);
        values.put( COL3_40 ,clinicalstaff);
        values.put( COL3_41 ,tbstaff);
        values.put( COL3_42 ,staffinfection);
        values.put( COL3_43 ,staffcovid);
        values.put( COL3_44 ,staffevaluated);
        values.put( COL3_45,staffillness);
        values.put( COL3_46 ,staffinjuries);
        values.put( COL3_47,staffhepatite);
        values.put( COL3_48,staffrate);
        values.put( COL3_49,patientrate);
        values.put( COL3_50,staffmetting);
        values.put( COL3_51,cosametting);

        long result = db.insert(TABLE_NAME3, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean userCheck(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String [] colummns = { COL_1 };
        String selection = COL_4 + "=?" + " and " + COL_5 + "=?";
        String [] selectionargs = {email, password};
        Cursor cursor = db.query(TABLE_NAME, colummns, selection, selectionargs, null, null, null);
        int counter = cursor.getCount();
        db.close();
        cursor.close();
        if(counter > 0){
            return true;
        }else{
            return false;
        }
    }



    //documentation and sanitation save functions
    public boolean registerDocumentationActionPlan(String year, String district, String hc,String available,String tracked,String approvedti,String approvedcosa,String comsatff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_6,approvedti);
        values.put(doc_7,approvedcosa);
        values.put(doc_8,comsatff);
        long result = db.insert(TABLE_NAME23, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDocumentationBusinessPlan(String year, String district, String hc,String available,String tracked,String approvedti,String approvedcosa,String comsatff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_6,approvedti);
        values.put(doc_7,approvedcosa);
        values.put(doc_8,comsatff);
        long result = db.insert(TABLE_NAME24, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDocumentationBudget(String year, String district, String hc,String available,String tracked,String approvedti,String approvedcosa,String comsatff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_6,approvedti);
        values.put(doc_7,approvedcosa);
        values.put(doc_8,comsatff);
        long result = db.insert(TABLE_NAME25, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDocumentationInService(String year, String district, String hc,String available,String tracked,String approvedti,String approvedcosa,String comsatff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_6,approvedti);
        values.put(doc_7,approvedcosa);
        values.put(doc_8,comsatff);
        long result = db.insert(TABLE_NAME26, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }


    public boolean registerDocumentationWorkSchedule(String year, String district, String hc,String available,String tracked,String approvedti,String approvedcosa,String comsatff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_6,approvedti);
        values.put(doc_7,approvedcosa);
        values.put(doc_8,comsatff);
        long result = db.insert(TABLE_NAME27, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDocumentationQiplan(String year, String district, String hc,String available,String tracked,String approvedti,String approvedcosa,String comsatff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_6,approvedti);
        values.put(doc_7,approvedcosa);
        values.put(doc_8,comsatff);
        long result = db.insert(TABLE_NAME28, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }


    public boolean registerDocumentationRegister(String year, String district, String hc,String available,String tracked){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        long result = db.insert(TABLE_NAME29, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDocumentationAttendance(String year, String district, String hc,String available,String tracked){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        long result = db.insert(TABLE_NAME30, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerDocumentationPayables(String year, String district, String hc,String available,String tracked){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        long result = db.insert(TABLE_NAME31, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerDocumentationReceivables(String year, String district, String hc,String available,String tracked){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        long result = db.insert(TABLE_NAME32, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDocumentationMalaria(String year, String district, String hc,String available,String tracked,String approved){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_9,approved);
        long result = db.insert(TABLE_NAME33, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDocumentationCustomer(String year, String district, String hc,String available,String tracked,String approved){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_9,approved);
        long result = db.insert(TABLE_NAME34, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDocumentationSanitation(String year, String district, String hc,String stafflatrines,String patientlatrines,String totlatrines,String brokelatrines,String cleanlatrines,String nodorlatrines,String handwashlatrine,String schedulelatrine,String opd,String hospirooms){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(s1,year);
        values.put(s2,district);
        values.put(s3,hc);
        values.put(s4,stafflatrines);
        values.put(s5,patientlatrines);
        values.put(s6,totlatrines);
        values.put(s7,brokelatrines);
        values.put(s8,cleanlatrines);
        values.put(s9,nodorlatrines);
        values.put(s10,handwashlatrine);
        values.put(s11,schedulelatrine);
        values.put(s12,opd);
        values.put(s13,hospirooms);

        long result = db.insert(TABLE_NAME35, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDatamanagementSOP(String year, String district, String hc,String available,String signed,String submited,String dmavailable){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(d1,year);
        values.put(d2,district);
        values.put(d3,hc);
        values.put(d4,available);
        values.put(d5,signed);
        values.put(d6,submited);
        values.put(d7,dmavailable);
        long result = db.insert(TABLE_NAME36, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDatamanagementDeliveries(String year, String district, String hc,String patientfile,String register,String hmis_hardcopy,String hmis_softcopy,String accurate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(de1,year);
        values.put(de2,district);
        values.put(de3,hc);
        values.put(de4,patientfile);
        values.put(de5,register);
        values.put(de6,hmis_hardcopy);
        values.put(de7,hmis_softcopy);
        values.put(de8,accurate);
        long result = db.insert(TABLE_NAME37, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDatamanagementNcd(String year, String district, String hc,String patientfile,String register,String hmis_hardcopy,String hmis_softcopy,String accurate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(de1,year);
        values.put(de2,district);
        values.put(de3,hc);
        values.put(de4,patientfile);
        values.put(de5,register);
        values.put(de6,hmis_hardcopy);
        values.put(de7,hmis_softcopy);
        values.put(de8,accurate);
        long result = db.insert(TABLE_NAME38, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerDatamanagementBcg(String year, String district, String hc,String patientfile,String register,String hmis_hardcopy,String hmis_softcopy,String accurate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(de1,year);
        values.put(de2,district);
        values.put(de3,hc);
        values.put(de4,patientfile);
        values.put(de5,register);
        values.put(de6,hmis_hardcopy);
        values.put(de7,hmis_softcopy);
        values.put(de8,accurate);
        long result = db.insert(TABLE_NAME39, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDatamanagementMalaria(String year, String district, String hc,String patientfile,String register,String hmis_hardcopy,String hmis_softcopy,String labregister,String accurate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(de1,year);
        values.put(de2,district);
        values.put(de3,hc);
        values.put(de4,patientfile);
        values.put(de5,register);
        values.put(de6,hmis_hardcopy);
        values.put(de7,hmis_softcopy);
        values.put(de10,labregister);
        values.put(de8,accurate);
        long result = db.insert(TABLE_NAME40, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }



    }

    public boolean registerDatamanagementOpdRegisters(String year, String district, String hc,String lines,String fields,String blanks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(opd1,year);
        values.put(opd2,district);
        values.put(opd3,hc);
        values.put(opd4,lines);
        values.put(opd5,fields);
        values.put(opd6,blanks);
        long result = db.insert(TABLE_NAME41, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }



    }

    public boolean registerMaternalNeonatal( String year,String district,String hc,String maternalyear, String obsetricalANC, String registrations, String referalsANC, String obsetricalMaternity, String deliveries, String livebirths, String maternaldeaths, String neonataldeaths, String stillbirths, String postpartun, String anc4, String anc1, String underfivedeaths, String childrenconsulted, String contraceptiveusers, String mr2vaccines, String ultrasoundscans){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(m1,year);
        values.put(m2,district);
        values.put(m3,hc);
        values.put(m4,maternalyear);
        values.put(m5,obsetricalANC);
        values.put(m6  ,registrations);
        values.put(m6  ,referalsANC);
        values.put(m6  ,obsetricalMaternity);
        values.put(m6  ,deliveries);
        values.put(m6  ,livebirths);
        values.put(m6  ,maternaldeaths);
        values.put(m6  ,neonataldeaths);
        values.put(m6  ,stillbirths);
        values.put(m6  ,postpartun);
        values.put(m6  ,anc4);
        values.put(m6  ,anc1);
        values.put(m6  ,underfivedeaths);
        values.put(m6  ,childrenconsulted);
        values.put(m6  ,contraceptiveusers);
        values.put(m6  ,mr2vaccines);
        values.put(m6  ,ultrasoundscans);
        long result = db.insert(TABLE_NAME42, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }



    }



}
