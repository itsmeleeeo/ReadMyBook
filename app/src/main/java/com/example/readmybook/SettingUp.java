package com.example.readmybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingUp extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_up);
        EditText txtEnterName = findViewById(R.id.txtEnterName);
        EditText txtEmail = findViewById(R.id.txtEmail);
        EditText txtPassSign = findViewById(R.id.txtPassSign);
        EditText txtAddress = findViewById(R.id.txtAddress);
        EditText txtAge = findViewById(R.id.txtAge);
        Button btnUpdate = findViewById(R.id.btnUpdateUProfile);
        Button btnDelete = findViewById(R.id.btnDeletAccUProfile);
        databaseHelper = new DatabaseHelper(this);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            boolean isUpdated;

            @Override
            public void onClick(View view) {
                isUpdated = databaseHelper.UpdateAllUserInfo(txtEmail.getText().toString(),txtEnterName.getText().toString()
                        ,txtPassSign.getText().toString(),txtAddress.getText().toString(),txtAge.getText().toString());

                if (isUpdated)  {
                    Toast.makeText(SettingUp.this, Html.fromHtml("<big>Data is Updated Successfully</big>"),Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SettingUp.this, MainActivity.class));
                }
                else {
                Toast.makeText(SettingUp.this,
                        Html.fromHtml("<big>data is not updated</big>"),
                        Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            boolean isDeleted;
            @Override
            public void onClick(View view) {
                isDeleted = databaseHelper.DeleteUserProfile(txtEmail.getText().toString());
                if (isDeleted)  {
                    Toast.makeText(SettingUp.this, Html.fromHtml("<big>User Has been Removed</big>"),Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SettingUp.this, UserHomePage.class));
                }
                else {
                    Toast.makeText(SettingUp.this,
                            Html.fromHtml("<big>Could not Delete the User</big>"),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}