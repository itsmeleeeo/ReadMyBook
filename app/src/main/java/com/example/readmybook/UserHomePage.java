package com.example.readmybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserHomePage extends AppCompatActivity {

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
    }
}