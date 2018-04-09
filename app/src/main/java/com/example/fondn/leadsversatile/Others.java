package com.example.fondn.leadsversatile;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fondn.leadsversatile.adapterandencrypter.CustomAdapter;
import com.example.fondn.leadsversatile.adapterandencrypter.StoreEncryp;

import java.util.ArrayList;

public class Others extends AppCompatActivity {
    Button okButton;
    EditText editText;
    ListView listView;
    ArrayList<StoreEncryp> arrayList = new ArrayList<>();
    CustomAdapter adapter;
    Context context;
    StoreEncryp storeEncryp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);
        okButton = (Button) findViewById(R.id.okbuttonID);
        editText = (EditText) findViewById(R.id.firstnameEditTextID);
        listView = (ListView) findViewById(R.id.listviewID);


        adapter = new CustomAdapter(getApplicationContext(), arrayList);
        listView.setAdapter(adapter);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                storeEncryp = new StoreEncryp(text);
                arrayList.add(storeEncryp);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                TextView textView = (TextView) view.findViewById(R.id.listviewdesigntextViewID);
                String name = textView.getText().toString();
                Toast.makeText(getBaseContext(), "Clicked: "+name, Toast.LENGTH_LONG).show();





            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,final int position, long id) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Others.this);
                builder.setTitle("Warning..");
                builder.setMessage("Do You Want To Delete?");
                builder.setIcon(R.drawable.icon);
                builder.setCancelable(true);

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        arrayList.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


                AlertDialog sh = builder.create();
                sh.show();

                return false;
            }
        });
    }
}
