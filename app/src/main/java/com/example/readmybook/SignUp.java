package com.example.readmybook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
   /* DatabaseHelper databaseHelper;
EditText txtEnterName= findViewById(R.id.txtEnterName);
EditText txtEmail= findViewById(R.id.txtEmail);
EditText txtPassSign = findViewById(R.id.txtPassSign);
EditText txtAddress = findViewById(R.id.txtAddress);
EditText txtAge = findViewById(R.id.txtAge);
Button btnRegister = findViewById(R.id.btnRegister);
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        /*databaseHelper = new DatabaseHelper(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            boolean isInserted;
            @Override

            public void onClick(View v) {
                RadioButton rdBtnAdmin = findViewById(R.id.rdBtnAdmin);
                RadioButton rdBtnUser = findViewById(R.id.rdBtnUser);

                Integer admin=0;
                if(rdBtnAdmin.isSelected()){
                    admin=1;
                    isInserted = databaseHelper.addRecord(txtEnterName.getText().toString(), txtEmail.getText().toString(),
                            txtPassSign.getText().toString(), txtAddress.getText().toString(), txtAge.getText().toString() ,admin);
                }
                else
                if(rdBtnUser.isSelected()){
                    admin=0;
                    isInserted = databaseHelper.addRecord(txtEnterName.getText().toString(), txtEmail.getText().toString(),
                            txtPassSign.getText().toString(), txtAddress.getText().toString(), txtAge.getText().toString() ,admin);
                }



                if (isInserted) {
                    Toast.makeText(SignUp.this,
                            Html.fromHtml("<big>data is inserted successfully</big>"),
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUp.this,
                            Html.fromHtml("<big>data is not inserted</big>"),
                            Toast.LENGTH_SHORT).show();
                }

            }
        });*/
    }
}