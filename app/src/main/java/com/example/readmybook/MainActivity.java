package com.example.readmybook;

import static com.example.readmybook.DatabaseHelper.T1COL5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    boolean checkUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView signUp = findViewById(R.id.txtNoAcc);
        TextView forgotPassword = findViewById(R.id.txtForgotPass);
        EditText emailLogin = findViewById(R.id.txtInputEmail);
        EditText passLogin = findViewById(R.id.txtInputPassword);

        databaseHelper = new DatabaseHelper(this);

        Button btnLogin  = findViewById(R.id.btnLogin);

        signUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SignUp.class));
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ForgotPassword.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String email = emailLogin.getText().toString();
                String pass = passLogin.getText().toString();
                if(email.equals("") || pass.equals("")) {
                    Toast.makeText(MainActivity.this, "There are empty fields. Make sure you fill them out", Toast.LENGTH_SHORT).show();
                }

                checkUser = databaseHelper.CheckEmailAndPassword(email, pass);

                if(checkUser) {
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, UserHomePage.class));
                } else {
                    Toast.makeText(MainActivity.this, "The email or password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}