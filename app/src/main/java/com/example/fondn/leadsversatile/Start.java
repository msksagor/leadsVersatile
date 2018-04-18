package com.example.fondn.leadsversatile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fondn.leadsversatile.dialpaddirectory.CallingActivity;
import com.example.fondn.leadsversatile.logINandlogOut.SignInClass;
import com.example.fondn.leadsversatile.logINandlogOut.SignUpClass;

public class Start extends AppCompatActivity implements View.OnClickListener{
    private Button singINButton,signUpButton,othersButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        singINButton = (Button) findViewById(R.id.signInButtonID);
        signUpButton = (Button) findViewById(R.id.signUpButtonID);
        othersButton = (Button) findViewById(R.id.othersButtonID);
        othersButton.setOnClickListener(this);
        singINButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.signInButtonID){
            //Toast.makeText(this, "SignIN ", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Start.this,SignInClass.class);
            startActivity(i);
        }else if(v.getId()==R.id.signUpButtonID){
           // Toast.makeText(this, "Create Account", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Start.this,SignUpClass.class);
            startActivity(i);
        }else if(v.getId()==R.id.othersButtonID){
           // Toast.makeText(this, "Welcome to Others Pannel", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Start.this,Others.class);
            startActivity(i);
        }


    }

    public void dialshortcut(View view) {
        Intent i = new Intent(Start.this,CallingActivity.class);
        startActivity(i);
    }
}
