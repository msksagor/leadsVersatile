package com.example.fondn.leadsversatile.others;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fondn.leadsversatile.R;
import com.example.fondn.leadsversatile.dialpaddirectory.CallingActivity;

public class OthersTools extends AppCompatActivity {
    Button dialpadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others_tools);
        dialpadButton = (Button) findViewById(R.id.dialPadButton);
        dialpadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OthersTools.this, CallingActivity.class);
                startActivity(i);
            }
        });


    }


}
