package com.example.fondn.leadsversatile.logINandlogOut;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fondn.leadsversatile.Database.MydatabaseHelper;
import com.example.fondn.leadsversatile.R;
import com.example.fondn.leadsversatile.Start;

public class LoggedIn extends AppCompatActivity {
    private TextView welcome,nameTextView,userNameTV,passwordTV,mailTV;
    private Button nameEditButton,userNameEditButton,passwordEditButton,emailEditButton;

    MydatabaseHelper mydatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        welcome = (TextView) findViewById(R.id.welcomeTOIDTextViewID);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String WelcomeUsername = bundle.getString("username");
        welcome.setText("Welcome to "+WelcomeUsername);

        mydatabaseHelper = new MydatabaseHelper(this);
        SQLiteDatabase database = mydatabaseHelper.getWritableDatabase();


        nameTextView = (TextView) findViewById(R.id.nametextViewID);
        userNameTV = (TextView) findViewById(R.id.userNametextViewID);
        passwordTV = (TextView) findViewById(R.id.passwordtextViewID);
        mailTV = (TextView) findViewById(R.id.emailtextViewID);

        nameEditButton = (Button) findViewById(R.id.nameEditButtonID);
        userNameEditButton = (Button) findViewById(R.id.userNameEditButtonID);
        passwordEditButton = (Button) findViewById(R.id.passwordEditButtonID);
        emailEditButton = (Button) findViewById(R.id.emailEditButtonID);


        //



        Cursor cursor = mydatabaseHelper.showDataFromDatabase(WelcomeUsername);
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Not Data Found", Toast.LENGTH_SHORT).show();
            return;
        } else {
            while (cursor.moveToNext()) {
                nameTextView.setText(cursor.getString(1));
                userNameTV.setText(cursor.getString(2));
                mailTV.setText(cursor.getString(3));
                passwordTV.setText(cursor.getString(4));

            }

        }



        ///




        nameEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoggedIn.this, "Name Change Activity Open", Toast.LENGTH_SHORT).show();
            }
        });
        userNameEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoggedIn.this, "UserName Change Request", Toast.LENGTH_SHORT).show();
            }
        });

        passwordEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoggedIn.this, "Password Cng Request", Toast.LENGTH_SHORT).show();
            }
        });

        emailEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoggedIn.this, "Mail Cng Request", Toast.LENGTH_SHORT).show();
            }
        });



    }


    void setTextFromDataToTextView(){

    }

    public void BackToHome(View view) {
        Intent i = new Intent(LoggedIn.this, Start.class);
    }
}
