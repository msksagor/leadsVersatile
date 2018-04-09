package com.example.fondn.leadsversatile.logINandlogOut;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fondn.leadsversatile.Database.MydatabaseHelper;
import com.example.fondn.leadsversatile.R;

public class SignInClass extends AppCompatActivity {
    private EditText userName,password;
    private Button loginBUtton;
    MydatabaseHelper mydatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        mydatabaseHelper = new MydatabaseHelper(this);
        SQLiteDatabase sqLiteOpenHelper = mydatabaseHelper.getWritableDatabase();

        userName  =(EditText) findViewById(R.id.userNameSignINEditTextID);
        password = (EditText) findViewById(R.id.passwordSignINEditTextID);
        loginBUtton = (Button) findViewById(R.id.logInButtonID);
        loginBUtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameString  = userName.getText().toString();
                String passwordString = password.getText().toString();
            Boolean result = mydatabaseHelper.findpasswordanduserName(userNameString,passwordString);
                if(result==true){
                    Intent i = new Intent(SignInClass.this,LoggedIn.class);
                    startActivity(i);
                }else{

                    Toast.makeText(SignInClass.this, "Not Match", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
