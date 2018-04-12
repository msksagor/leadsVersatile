package com.example.fondn.leadsversatile.dialpaddirectory;



import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;


import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fondn.leadsversatile.R;

public class TouchPadFragment extends Fragment implements View.OnClickListener {

    private EditText insertNumerET;
    private Button one,two,three,four,five,six,seven,eight,nine,zero,star,hash,deteleButton;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        insertNumerET = (EditText) getActivity().findViewById(R.id.insertedNumberEditTextID);
        one = (Button) getActivity().findViewById(R.id.oneID);
        two = (Button) getActivity().findViewById(R.id.twoID);
        three = (Button) getActivity().findViewById(R.id.threeID);
        four = (Button) getActivity().findViewById(R.id.fourID);
        five = (Button) getActivity().findViewById(R.id.fiveID);
        six = (Button) getActivity().findViewById(R.id.sixID);
        seven = (Button) getActivity().findViewById(R.id.sevenID);
        eight = (Button) getActivity().findViewById(R.id.eightID);
        nine = (Button) getActivity().findViewById(R.id.nineID);
        zero = (Button) getActivity().findViewById(R.id.zeroID);
        star = (Button) getActivity().findViewById(R.id.starID);
        hash = (Button) getActivity().findViewById(R.id.hashID);

        one.setOnClickListener(TouchPadFragment.this);
        two.setOnClickListener(TouchPadFragment.this);
        three.setOnClickListener(TouchPadFragment.this);
        four.setOnClickListener(TouchPadFragment.this);
        five.setOnClickListener(TouchPadFragment.this);
        six.setOnClickListener(TouchPadFragment.this);
        seven.setOnClickListener(TouchPadFragment.this);
        eight.setOnClickListener(TouchPadFragment.this);
        nine.setOnClickListener(TouchPadFragment.this);
        zero.setOnClickListener(TouchPadFragment.this);
        star.setOnClickListener(TouchPadFragment.this);
        hash.setOnClickListener(TouchPadFragment.this);


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_touch_pad, container, false);
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.oneID) {

            if(insertNumerET.getText().equals("")){
                insertNumerET.setText(""+1);
            }else {
                String str = insertNumerET.getText().toString();
                insertNumerET.setText(str+"1");
            }



        }else if(v.getId()==R.id.twoID){

            if(insertNumerET.getText().equals("")){
                insertNumerET.setText(""+2);
            }else {
                String str = insertNumerET.getText().toString();
                insertNumerET.setText(str+"2");
            }

        }





        else if(v.getId()==R.id.threeID){
            if(insertNumerET.getText().equals("")){
                insertNumerET.setText(""+3);
            }else {
                String str = insertNumerET.getText().toString();
                insertNumerET.setText(str+"3");
            }

        }else if(v.getId()==R.id.fourID){
            if(insertNumerET.getText().equals("")){
                insertNumerET.setText(""+4);
            }else {
                String str = insertNumerET.getText().toString();
                insertNumerET.setText(str+"4");
            }
        }else if(v.getId()==R.id.fiveID){
            if(insertNumerET.getText().equals("")){
                insertNumerET.setText(""+5);
            }else {
                String str = insertNumerET.getText().toString();
                insertNumerET.setText(str+"5");
            }
        }else if(v.getId()==R.id.sixID){
            if(insertNumerET.getText().equals("")){
                insertNumerET.setText(""+6);
            }else {
                String str = insertNumerET.getText().toString();
                insertNumerET.setText(str+"6");
            }
        }else if(v.getId()==R.id.sevenID){
            if(insertNumerET.getText().equals("")){
                insertNumerET.setText(""+7);
            }else {
                String str = insertNumerET.getText().toString();
                insertNumerET.setText(str+"7");
            }
        }else if(v.getId()==R.id.eightID){
            if(insertNumerET.getText().equals("")){
                insertNumerET.setText(""+8);
            }else {
                String str = insertNumerET.getText().toString();
                insertNumerET.setText(str+"8");
            }
        }else if(v.getId()==R.id.nineID){
            if(insertNumerET.getText().equals("")){
                insertNumerET.setText(""+9);
            }else {
                String str = insertNumerET.getText().toString();
                insertNumerET.setText(str+"9");
            }
        }else if(v.getId()==R.id.zeroID){
            if(insertNumerET.getText().equals("")){
                insertNumerET.setText(""+0);
            }else {
                String str = insertNumerET.getText().toString();
                insertNumerET.setText(str+"0");
            }
        }else if(v.getId()==R.id.starID){
            if(insertNumerET.getText().equals("")){
                insertNumerET.setText(""+"*");
            }else {
                String str = insertNumerET.getText().toString();
                insertNumerET.setText(str+"*");
            }
        }else if(v.getId()==R.id.hashID){
            if(insertNumerET.getText().equals("")){
                insertNumerET.setText(""+2);
            }else {
                String str = insertNumerET.getText().toString();
                insertNumerET.setText(str+"#");
            }
        }


    }
}
