package com.example.secondexercise;

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




    public Databasehelper(@Nullable Context context ) {
        super(context, DATABASE_NAME, null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, FNAME TEXT, LNAME TEXT, EMAIL TEXT,PASSWORD TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME2 + "(YEAR TEXT, DISTRICT TEXT, HC TEXT,SECTOR TEXT, CELL TEXT,VILLAGE TEXT, PUBPOST TEXT, PRIPOST TEXT,POPULATION TEXT,PATIENTS TEXT,BEDS TEXT, CONSROOMS TEXT,HOSPROOMS TEXT,CHW TEXT,A0 TEXT,A1 TEXT,A2 TEXT,MIDWIFE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME3 + "(YEAR TEXT, DISTRICT TEXT, HC TEXT,ORGANI TEXT, UPTODATE TEXT,ACCESSIBLE TEXT, LABTECAV TEXT,LABSIGN TEXT,LABEMP TEXT,NURSEARV TEXT,NURSEARSIGN TEXT,NURSEAREMPSIGN TEXT,NURSEVACAV TEXT,NURSEVACSIGN TEXT,NURSEVACEMPSIGN TEXT,CUSTOCAREAV TEXT,CUSTCARESIGN TEXT,CUSTCAREEMPPSIGN TEXT,NURSETBAV TEXT,NURSETBSIGN TEXT,NURSETBEMPSIGN TEXT,NURSECHI TEXT,NURSECHISIGN TEXT,NURSECHIEMPSIGN TEXT,SOCIALAV TEXT,SOCIALSIGN TEXT,SOCIALEMPSIGN TEXT,NURSECPNAV TEXT,NURSECPNSIGN TEXT,NURSECPNEMPSIGN TEXT,MIDWIFEAV TEXT,MIDWIFESIGN TEXT,MIDWIFEEMPSIGN TEXT,SOPPHARMACY TEXT,EVIDENCE TEXT,QICOMITEE TEXT,TOTSTAFF TEXT,TOTNURSE TEXT,PAIDSTAFF TEXT,CLINICALSTAFF TEXT,TBSTAFF TEXT,STAFFINFECTION TEXT,STAFFCOVID TEXT,STAFFEVALUATED TEXT,STAFFILLNESS TEXT,STAFFINJURIES TEXT,STAFFHEPATITE TEXT,STAFFRATE TEXT,PATIENTRATE TEXT,STAFFMETTING TEXT,COSAMETTING TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME3);
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


}
