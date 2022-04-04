package com.example.readmybook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Activity_AddABook extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    EditText txtAddBook= findViewById(R.id.txtBookTitleAddABook);
    EditText txtBookAuthor= findViewById(R.id.txtAuthorAB);
    EditText txtPublicationYear = findViewById(R.id.txtPublicationYearAB);
    EditText txtPublisher = findViewById(R.id.txtPublisherAB);
    EditText txtIsbn = findViewById(R.id.txtIsbnAB);
    Button btnAddBook = findViewById(R.id.btnAddBookAB);
    Spinner spinRentOutAmount = findViewById(R.id.spinRentOutAmountAB);
    Spinner spinGenre = findViewById(R.id.spinGenreAB);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_abook);

        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}