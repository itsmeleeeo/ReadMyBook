package com.example.readmybook;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "Information.db";
    final static int DATABASE_VERSION = 9;
    final static String TABLE1_NAME = "Usertable_signup";
    final static String T1COL1 = "Id";
    final static String T1COL2 = "Name";
    final static String T1COL3 = "Age";
    final static String T1COL4 = "Address";
    final static String T1COL5 = "Email";
    final static String T1COL6 = "Password";
    final static String T1COL7 = "IsAdmin";

    final static String TABLE2_NAME = "Add_a_book";
    final static String T2COL1="Book_title";
    final static String T2COL2 = "Author";
    final static String T2COL3="ISBN";
    final static String T2COL4="Publisher";
    final static String T2COL5="Publication_year";
    final static String T2COL6="Spinner_data";

    final static String TABLE3_NAME = "Track_a_book";

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
        String pQuery = "CREATE TABLE " + TABLE2_NAME + "(" + T2COL1 + " Text," + T2COL2 + " Text," + T2COL3 +
                " INTEGER PRIMARY KEY," + T2COL4 + " Text," + T2COL5 +
                " INTEGER, " + T2COL6 + " Text)";
        db.execSQL(pQuery);
        String Query = "CREATE TABLE " + TABLE3_NAME + "(" + T2COL3 + " INTEGER," + "FOREIGN KEY"+ "(" + T2COL3 + ") " + "REFERENCES " +
        TABLE2_NAME + "(" + T2COL3 + ")" + ")";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE1_NAME);
        db.execSQL("DROP TABLE " + TABLE2_NAME );
        db.execSQL("DROP TABLE " + TABLE3_NAME);
        onCreate(db);
    }

    //Add a new user account
    public boolean addRecord(String name,String Email,String PassSign, String Address,String Age,int adminornot){
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
    public boolean addBookRecord(String booktitle,String author,String isbn,String publicationyear,String publisher,String spinnergenre){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(T2COL1,booktitle);
        values.put(T2COL2,author);
        values.put(T2COL3,isbn);
        values.put(T2COL4,publisher);
        values.put(T2COL5,publicationyear);
        values.put(T2COL6,spinnergenre);
        long r = sqLiteDatabase.insert(TABLE2_NAME,null,values);
        if(r>0)
            return true;
        else
            return false;
    }
    public boolean UpdateUserInfo(String email, String pass) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T1COL6, pass);
        long u = sqLiteDatabase.update(TABLE1_NAME,values, "email=?", new String[]{email});
        if(u > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean track_a_book(int isbn){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        ContentValues values= new ContentValues();
        values.put(T2COL3,isbn);
        long r= sqLiteDatabase.insert(TABLE3_NAME,null,values);
        if(r>0)
            return true;
        else
            return false;
    }

    public boolean CheckEmailAndPassword(String email, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT " + T1COL5 + "," + T1COL6 + " FROM " + TABLE1_NAME + " WHERE " + T1COL5 + " =  email " + " AND " + T1COL6 + " =  password ";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if(cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
