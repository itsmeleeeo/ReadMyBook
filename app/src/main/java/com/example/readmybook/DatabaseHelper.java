package com.example.readmybook;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "Users.db";
    final static int DATABASE_VERSION = 1;
    final static String TABLE1_NAME = "Usertable_signup";
    final static String T1COL1 = "Id";
    final static String T1COL2 = "Name";
    final static String T1COL3 = "Age";
    final static String T1COL4 = "Address";
    final static String T1COL5 = "Email";
    final static String T1COL6 = "Password";
    final static String T1COL7 = "IsAdmin";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE1_NAME + "(" + T1COL1 + " INTEGER PRIMARY KEY," +
                T1COL2 + " Text," + T1COL3 + " INTEGER," + T1COL4 + " Text," +
                T1COL5 + " Text," + T1COL6 + " Text," + T1COL7 + " Integer)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE1_NAME);
        onCreate(db);
    }

    public boolean addRecord(String name,String Email,String PassSign, String Address,String Age,Integer adminornot){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T1COL2,name);
        values.put(T1COL3,Age);
        values.put(T1COL4,Address);
        values.put(T1COL5,Email);
        values.put(T1COL6,PassSign);
        values.put(T1COL7,adminornot);
        long r = sqLiteDatabase.insert(TABLE1_NAME,null,values);
        if(r>0)
            return true;
        else
            return false;

    }
}