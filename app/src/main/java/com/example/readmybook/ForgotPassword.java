package com.example.readmybook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        databaseHelper = new DatabaseHelper(this);
        EditText fpEmail = findViewById(R.id.txtemailForgot);
        EditText fpNewPass = findViewById(R.id.txtEnterNewPass);
        EditText fpReEnterNewPass = findViewById(R.id.txtReenterNewPass);
        Button btnConfirm = findViewById(R.id.btnChangePass);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            boolean isUpdated;
            @Override
            public void onClick(View view) {
                String email = fpEmail.getText().toString();
                String newPass = fpNewPass.getText().toString();
                String repNewPass = fpReEnterNewPass.getText().toString();

                if(newPass.equals("") || repNewPass.equals("")) {
                    Toast.makeText(ForgotPassword.this, "None of the fields cannot be blank", Toast.LENGTH_SHORT).show();
                } else if(newPass == repNewPass){
                    isUpdated = databaseHelper.UpdateUserInfo(email, newPass);
                    if(isUpdated) {
                        Toast.makeText(ForgotPassword.this, "Password Changed", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ForgotPassword.this, "Password not changed", Toast.LENGTH_SHORT).show();
                    }

                } else if(newPass != repNewPass){
                    Toast.makeText(ForgotPassword.this, "The Password does not match", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}