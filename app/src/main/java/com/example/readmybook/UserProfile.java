package com.example.readmybook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserProfile extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    EditText txtEnterName= findViewById(R.id.txtEnterName);
    EditText txtEmail= findViewById(R.id.txtEmail);
    EditText txtPassSign = findViewById(R.id.txtPassSign);
    EditText txtAddress = findViewById(R.id.txtAddress);
    EditText txtAge = findViewById(R.id.txtAge);
    Button btnUpdateUserProfile = findViewById(R.id.btnUpdateUProfile);
    Button btnDeleteProfile = findViewById(R.id.btnDeletAccUProfile);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        btnUpdateUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnDeleteProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}