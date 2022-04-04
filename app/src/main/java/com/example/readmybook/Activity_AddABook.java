package com.example.readmybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Activity_AddABook extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    int isbn_num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_abook);
        databaseHelper= new DatabaseHelper(this);
        EditText txtBookTitleAddABook= findViewById(R.id.txtBookTitleAddABook);
        EditText txtAuthorAB= findViewById(R.id.txtAuthorAB);
        EditText txtPublicationYearAB = findViewById(R.id.txtPublicationYearAB);
        EditText txtPublisherAB = findViewById(R.id.txtPublisherAB);
        EditText txtIsbnAB= findViewById(R.id.txtIsbnAB);
        Button btnAddBookAB = findViewById(R.id.btnAddBookAB);
        Spinner SpinnerGenre = findViewById(R.id.spinGenreAB);

        btnAddBookAB.setOnClickListener(new View.OnClickListener() {
            boolean isInserted_book;
            @Override
            public void onClick(View view) {
                isInserted_book=databaseHelper.addBookRecord(txtBookTitleAddABook.getText().toString(),txtAuthorAB.getText().toString(),txtIsbnAB.getText().toString(),
                        txtPublicationYearAB.getText().toString(), txtPublisherAB.getText().toString(),SpinnerGenre.getSelectedItem().toString());

                if (isInserted_book) {
                    isbn_num=Integer.parseInt(txtIsbnAB.getText().toString());
                    Toast.makeText(Activity_AddABook.this,
                            Html.fromHtml("<big>data is inserted successfully</big>"),
                            Toast.LENGTH_SHORT).show();
                    Intent i= new Intent(Activity_AddABook.this,trackabook.class);
                    txtBookTitleAddABook.setText("");
                    txtAuthorAB.setText("");
                    txtIsbnAB.setText("");
                    txtPublicationYearAB.setText("");
                    txtPublisherAB.setText("");
                    startActivity(new Intent(Activity_AddABook.this, UserHomePage.class));
                    i.putExtra("ISBN",isbn_num);
                } else {
                    Toast.makeText(Activity_AddABook.this,
                            Html.fromHtml("<big>data is not inserted</big>"),
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}