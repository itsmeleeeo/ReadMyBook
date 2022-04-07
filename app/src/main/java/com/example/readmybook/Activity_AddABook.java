package com.example.readmybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Activity_AddABook extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    long isbn_num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_abook);
        databaseHelper = new DatabaseHelper(this);
        EditText txtBookTitleAddABook = findViewById(R.id.txtBookTitleAddABook);
        EditText txtAuthorAB = findViewById(R.id.txtAuthorAB);
        EditText txtPublicationYearAB = findViewById(R.id.txtPublicationYearAB);
        EditText txtPublisherAB = findViewById(R.id.txtPublisherAB);
        EditText txtIsbnAB = findViewById(R.id.txtIsbnAB);
        Button btnAddBookAB = findViewById(R.id.btnAddBookAB);
        Spinner SpinnerGenre = findViewById(R.id.spinGenreAB);

        btnAddBookAB.setOnClickListener(new View.OnClickListener() {
            boolean isInserted_book;

            @Override
            public void onClick(View view) {
                String final_isbn = txtIsbnAB.getText().toString();

                     if(final_isbn.length()==13) {
                         isInserted_book = databaseHelper.addBookRecord(txtBookTitleAddABook.getText().toString(), txtAuthorAB.getText().toString(), txtIsbnAB.getText().toString(),
                                 txtPublicationYearAB.getText().toString(), txtPublisherAB.getText().toString(), SpinnerGenre.getSelectedItem().toString());

                         if (isInserted_book) {
                             isbn_num = Long.parseLong(txtIsbnAB.getText().toString());
                             Toast.makeText(Activity_AddABook.this,
                                     Html.fromHtml("<big>data is inserted successfully</big>"),
                                     Toast.LENGTH_SHORT).show();
                             try {
                                 Intent i = new Intent(Activity_AddABook.this, trackabook.class);
                                 i.putExtra("ISBN", String.valueOf(isbn_num));
                                 startActivity(i);
                             } catch (Exception e) {
                                 e.printStackTrace();
                                 System.out.println();
                             }

                         } else {
                             Toast.makeText(Activity_AddABook.this,
                                     Html.fromHtml("<big>data is not inserted</big>"),
                                     Toast.LENGTH_SHORT).show();
                         }
                     }
               else {
                   Toast.makeText(Activity_AddABook.this,Html.fromHtml("Please enter 13-digit ISBN"),Toast.LENGTH_SHORT).show();
                     }
            }
        });
    }
}