package com.example.readmybook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DatabaseHelper databaseHelper;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        databaseHelper = new DatabaseHelper(this);
        EditText txtEmail = findViewById(R.id.txtEmail);
        EditText txtNewPass = findViewById(R.id.txtEnterNewPass);
        EditText txtReEnterNewPass = findViewById(R.id.txtReenterNewPass);
        Button btnConfirm = findViewById(R.id.btnChangePass);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            boolean isUpdated;
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(txtEmail.getText().toString());
                isUpdated = databaseHelper.UpdateUserInfo(id, txtNewPass.getText().toString());

                if(txtNewPass.equals(txtReEnterNewPass)) {
                    if(isUpdated) {
                        Toast.makeText(ForgotPassword.this,"Password Updated", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ForgotPassword.this, "Password not Updated", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(ForgotPassword.this, "The password does not match",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}