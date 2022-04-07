package com.example.readmybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class shareabookadminpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shareabookadminpage);

        Button btnremoveabook = findViewById(R.id.btnremovebookpage);
        Button btnremoveuser = findViewById(R.id.btnremoveauserpage);
        Button btnblockuser = findViewById(R.id.btnblockauserpage);
        Button btntrackabook = findViewById(R.id.btntrackabookpage);
        Button btnlogout = findViewById(R.id.btnlogout);

        btnremoveabook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(shareabookadminpage.this,admin_removebook.class));
            }
        });

        btnremoveuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(shareabookadminpage.this, adminremoveuser.class));
            }
        });

        btnblockuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(shareabookadminpage.this, SettingUp.class));
            }
        });

        btntrackabook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(shareabookadminpage.this, trackabook.class));
            }
        });

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent (shareabookadminpage.this, MainActivity.class));
            }
        });


    }
}






























