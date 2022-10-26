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




    public Databasehelper(@Nullable Context context ) {
        super(context, DATABASE_NAME, null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, FNAME TEXT, LNAME TEXT, EMAIL TEXT,PASSWORD TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME2 + "(YEAR TEXT, DISTRICT TEXT, HC TEXT,SECTOR TEXT, CELL TEXT,VILLAGE TEXT, PUBPOST TEXT, PRIPOST TEXT,POPULATION TEXT,PATIENTS TEXT,BEDS TEXT, CONSROOMS TEXT,HOSPROOMS TEXT,CHW TEXT,A0 TEXT,A1 TEXT,A2 TEXT,MIDWIFE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME2);
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
