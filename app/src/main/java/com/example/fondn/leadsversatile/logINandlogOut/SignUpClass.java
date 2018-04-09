package com.example.fondn.leadsversatile.logINandlogOut;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fondn.leadsversatile.Database.MydatabaseHelper;
import com.example.fondn.leadsversatile.R;

public class SignUpClass extends AppCompatActivity {
    EditText fullname,userName,password,mail;
    Button registerButton,backButton;
    MydatabaseHelper mydatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        fullname = (EditText) findViewById(R.id.fullnameEditTextID);
        userName = (EditText) findViewById(R.id.userNameEditTextID);
        password = (EditText) findViewById(R.id.passwordEditTextID);
        mail = (EditText) findViewById(R.id.mailEditTextID);
        registerButton = (Button) findViewById(R.id.registerButtonID);
        backButton = (Button) findViewById(R.id.backButtonID);

        mydatabaseHelper = new MydatabaseHelper(this);
        mydatabaseHelper.getWritableDatabase();


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullNameString = fullname.getText().toString();
                String userNameString = userName.getText().toString();
                String passwordString = password.getText().toString();
                String mailString = mail.getText().toString();



                    long r = mydatabaseHelper.insertData(fullNameString, userNameString, mailString,passwordString);
                    if (r == -1) {

                        Toast.makeText(SignUpClass.this, "Failded", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignUpClass.this, "Successfully Inserted . row id: " + r, Toast.LENGTH_SHORT).show();
                    }




            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpClass.this,SignInClass.class);
                startActivity(i);

            }
        });
    }



}
