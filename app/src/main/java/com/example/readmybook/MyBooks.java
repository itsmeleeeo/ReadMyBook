package com.example.readmybook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MyBooks extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText txtAddBook= findViewById(R.id.txtBookTitleAddABook);
    EditText txtBookAuthor= findViewById(R.id.txtAuthorAB);
    EditText txtPublicationYear = findViewById(R.id.txtPublicationYearAB);
    EditText txtPublisher = findViewById(R.id.txtPublisherAB);
    EditText txtIsbn = findViewById(R.id.txtIsbnAB);
    Button btnUpdateBook = findViewById(R.id.btnUpdateBook);
    Button btnDeleteBook = findViewById(R.id.btnDeletBook);
    Spinner spinRentOutAmount = findViewById(R.id.spinRentOutAmountAB);
    Spinner spinGenre = findViewById(R.id.spinGenreAB);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_books);

        btnUpdateBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnDeleteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}