package com.example.readmybook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "Information.db";
    final static int DATABASE_VERSION = 1;
    final static String TABLE1_NAME = "User_table";
    final static String T1COL1 = "Id";
    final static String T1COL2 = "FName";
    final static String T1COL3 = "LName";
    final static String T1COL4 = "Age";
    final static String T1COL5 = "Address";
    final static String T1COL6 = "Email";
    final static String T1COL7 = "Password";
    final static String T1COL8 = "IsAdmin";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE1_NAME + "(" + T1COL1 + " INTEGER PRIMARY KEY," +
                T1COL2 + " Text," + T1COL3 + " Text, " + T1COL4 + " INTEGER," + T1COL5 + " Text," +
                T1COL6 + " Text," + T1COL7 + " Text," + T1COL8 + " Integer)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE1_NAME);
        onCreate(db);
    }
}
