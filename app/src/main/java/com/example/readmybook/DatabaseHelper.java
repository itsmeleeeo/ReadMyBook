package com.example.readmybook;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

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
    final static String T2COL1 = "Book_title";
    final static String T2COL2 = "Author";
    final static String T2COL3 = "ISBN";
    final static String T2COL4 = "Publisher";
    final static String T2COL5 = "Publication_year";
    final static String T2COL6 = "Spinner_data";

    final static String TABLE3_NAME = "Track_a_book";
    final static String TABLE4_NAME = "Employees";
    final static  String T4COL1 = "EmployeeID";
    final static  String T4COL2 = "FirstName";
    final static  String T4COL3 = "LastName";
    final static  String T4COL4 = "SecurityLevel";
    final static  String T4COL5 = "Email";

    final static String TABLE5_NAME = "Genres";
    final static  String T5COL1 = "Fantasy";
    final static  String T5COL2 = "Adventure";
    final static  String T5COL3 = "Romance";
    final static  String T5COL4 = "Dystopian";
    final static  String T5COL5 = "Mystery";
    final static  String T5COL6 = "Horror";
    final static  String T5COL7 = "Thriller";
    final static  String T5COL8 = "Paranormal";
    final static  String T5COL9 = "Historical Fiction";
    final static  String T5COL10 = "Science Fiction";
    final static  String T5COL11 = "Children's";
    final static  String T5COL12 = "Memoir";
    final static  String T5COL13 = "Cooking";
    final static  String T5COL14 = "Art";
    final static  String T5COL15 = "Self-Help";
    final static  String T5COL16 = "Development";
    final static  String T5COL17 = "Health";
    final static  String T5COL18 = "History";
    final static  String T5COL19 = "Travel";
    final static  String T5COL20 = "Guide/How-to";
    final static  String T5COL21 = "Families";
    final static  String T5COL22 = "Humor";



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
        String Query = "CREATE TABLE " + TABLE3_NAME + "(" + T2COL3 + " INTEGER," + "FOREIGN KEY" + "(" + T2COL3 + ") " + "REFERENCES " +
                TABLE2_NAME + "(" + T2COL3 + ")" + ")";
        db.execSQL(Query);
        String eQuery = "CREATE TABLE " + TABLE4_NAME + "(" + T4COL1 + " INTEGER PRIMARY KEY," +
                T4COL2 + " Text," + T4COL3 + " Text," +
                T4COL4 + " Text," + T4COL5 + " Text)";
        db.execSQL(eQuery);
//        String gQuery = "CREATE TABLE " + TABLE5_NAME + "(" + T5COL1 + " INTEGER," +
//                T5COL2 + " INTEGER," + T5COL3 + " INTEGER," +
//                T5COL4 + " INTEGER," + T5COL5+ " INTEGER," + T5COL6 + " INTEGER," + T5COL7 + " INTEGER," + T5COL8 + " INTEGER," +
//                T5COL10+ " INTEGER," + T5COL11 + " INTEGER," + T5COL12 + " INTEGER," + T5COL13 + " INTEGER," +
//                T5COL14 + " INTEGER," + T5COL15+ " INTEGER," + T5COL16 + " INTEGER," + T5COL17 + " INTEGER," + T5COL18 + " INTEGER," +
//                T5COL19 + " INTEGER," + T5COL20+ " INTEGER," + T5COL21 + " INTEGER," + T5COL22 + " INTEGER)";
//        db.execSQL(gQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE1_NAME);
        db.execSQL("DROP TABLE " + TABLE2_NAME);
        db.execSQL("DROP TABLE " + TABLE3_NAME);
        db.execSQL("DROP TABLE " + TABLE2_NAME);
        db.execSQL("DROP TABLE " + TABLE3_NAME);
        db.execSQL("DROP TABLE " + TABLE5_NAME);
       // db.execSQL("DROP TABLE " + TABLE6_NAME);
        onCreate(db);
    }

    //Add a new user account
    public boolean addRecord(String name, String Email, String PassSign, String Address, String Age, int adminornot) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T1COL2, name);
        values.put(T1COL3, Age);
        values.put(T1COL4, Address);
        values.put(T1COL5, Email);
        values.put(T1COL6, PassSign);
        values.put(T1COL7, adminornot);
        long r = sqLiteDatabase.insert(TABLE1_NAME, null, values);
        if (r > 0)
            return true;
        else
            return false;

    }

    public boolean addBookRecord(String booktitle, String author, String isbn, String publicationyear, String publisher, String spinnergenre) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T2COL1, booktitle);
        values.put(T2COL2, author);
        values.put(T2COL3, isbn);
        values.put(T2COL4, publisher);
        values.put(T2COL5, publicationyear);
        values.put(T2COL6, spinnergenre);
        long r = sqLiteDatabase.insert(TABLE2_NAME, null, values);
        if (r > 0)
            return true;
        else
            return false;
    }
    public boolean ForgotPassword(String email, String pass) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T1COL5, email);
        values.put(T1COL6, pass);
        long u = sqLiteDatabase.update(TABLE1_NAME,values, "email=?", new String[]{email, pass});
        if(u > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean track_a_book(long isbn) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(T2COL3, isbn);
        long r = sqLiteDatabase.insert(TABLE3_NAME, null, values);
        if (r > 0)
            return true;
        else
            return false;
    }

    public boolean CheckEmailAndPassword(String email, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT " + T1COL5 + "," + T1COL6 + " FROM " + TABLE1_NAME + " WHERE " + T1COL5 + " =  email " + " AND " + T1COL6 + " =  password ";
//        "SELECT * FROM " + TABLE1_NAME + " WHERE " + T1COL5 + " = ' Email '" + " AND " + T1COL6 + " = ' Password '";

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }


    public boolean UpdateAllUserInfo(String email,String name,String PassSign, String Address,String Age ){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T1COL2,name);
        values.put(T1COL3,Age);
        values.put(T1COL4,Address);
        values.put(T1COL6,PassSign);
        long u = sqLiteDatabase.update(TABLE1_NAME,values, "email=?", new String[]{email});
        if(u > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean DeleteUserProfile(String email){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long j = sqLiteDatabase.delete(TABLE1_NAME,"email=?",new String[]{email});
        if(j > 0) {
            return true;
        } else {
            return false;
        }
    }

    // we have created a new method for reading all the Books.
    public ArrayList<CourseModal> readBooks() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorBooks = db.rawQuery("SELECT * FROM " + TABLE2_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<CourseModal> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorBooks.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new CourseModal(cursorBooks.getString(1),
                        cursorBooks.getString(2),
                        cursorBooks.getString(3)));
            } while (cursorBooks.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorBooks.close();
        return courseModalArrayList;
    }
}
