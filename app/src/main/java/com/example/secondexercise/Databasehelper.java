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




    public Databasehelper(@Nullable Context context ) {
        super(context, DATABASE_NAME, null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, FNAME TEXT, LNAME TEXT, EMAIL TEXT,PASSWORD TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
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
