package com.example.readmybook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class UserHomePage extends AppCompatActivity {
    private ArrayList<CourseModal> BookModalArrayList;
    private DatabaseHelper dbHandler;
    private BooksRVAdaptor BooksRVAdaptor;
    private RecyclerView BooksRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);

        Button btnAdd = findViewById(R.id.btnAddAbookUH);
        Button btnSettings = findViewById(R.id.btnLogOutUH);
        Button btnLogout = findViewById(R.id.btnLogout);
        Button btnGetBook = findViewById(R.id.btnGetABookUH);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserHomePage.this, Activity_AddABook.class));
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserHomePage.this, SettingUp.class));
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserHomePage.this, MainActivity.class));
            }
        });

        btnGetBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserHomePage.this, GetBookActivity.class));
            }
        });


        // initializing our all variables.
        BookModalArrayList = new ArrayList<>();
        dbHandler = new DatabaseHelper(UserHomePage.this);

        // getting our course array
        // list from db handler class.
        BookModalArrayList = dbHandler.readBooks();

        // on below line passing our array lost to our adapter class.
        BooksRVAdaptor = new BooksRVAdaptor(BookModalArrayList, UserHomePage.this);
        BooksRV = findViewById(R.id.recVMyBooksUH);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(UserHomePage.this, RecyclerView.VERTICAL, false);
        BooksRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        BooksRV.setAdapter(BooksRVAdaptor);
    }

}