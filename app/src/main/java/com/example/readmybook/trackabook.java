package com.example.readmybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class trackabook extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    long isbn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trackabook);
        databaseHelper= new DatabaseHelper(this);
        Intent i = getIntent();
        if (i!=null){
            isbn= Long.parseLong(getIntent().getStringExtra("ISBN"));
        }

        Button btn_tracker=findViewById(R.id.btn_tracker);
        btn_tracker.setOnClickListener(new View.OnClickListener() {
            boolean is_tracking;
            @Override
            public void onClick(View view) {
                is_tracking=databaseHelper.track_a_book(isbn);

                if (is_tracking) {
                    Toast.makeText(trackabook.this,
                            Html.fromHtml("<big>Your books are successfully saved.</big>"),
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(trackabook.this,
                            Html.fromHtml("<big>Your books are not saved.</big>"),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}