package com.example.readmybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    int admin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EditText txtEnterName = findViewById(R.id.txtEnterName);
        EditText txtEmail = findViewById(R.id.txtEmail);
        EditText txtPassSign = findViewById(R.id.txtPassSign);
        EditText txtAddress = findViewById(R.id.txtAddress);
        EditText txtAge = findViewById(R.id.txtAge);
        Button btnRegister = findViewById(R.id.btnRegister);
        databaseHelper = new DatabaseHelper(this);
        RadioButton rdBtnAdmin = findViewById(R.id.rdBtnAdmin);
        RadioButton rdBtnUser = findViewById(R.id.rdBtnUser);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            boolean isInserted;

            @Override
            public void onClick(View v) {
                if (rdBtnAdmin.isChecked()) {
                    admin = 1;

                } else if (rdBtnUser.isChecked()) {
                    admin = 0;

                }
                isInserted = databaseHelper.addRecord(txtEnterName.getText().toString(), txtEmail.getText().toString(),
                        txtPassSign.getText().toString(), txtAddress.getText().toString(), txtAge.getText().toString(), admin);

                if (isInserted) {
                    Toast.makeText(SignUp.this,
                            Html.fromHtml("<big>data is inserted successfully</big>"),
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUp.this, MainActivity.class));
                } else {
                    Toast.makeText(SignUp.this,
                            Html.fromHtml("<big>data is not inserted</big>"),
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
