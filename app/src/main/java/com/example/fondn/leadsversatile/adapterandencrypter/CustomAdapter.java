package com.example.fondn.leadsversatile.adapterandencrypter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fondn.leadsversatile.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<StoreEncryp> arrayList = new ArrayList<>();

    private static LayoutInflater layoutInflater = null;

    public CustomAdapter() {
    }

    public CustomAdapter(Context context, ArrayList<StoreEncryp> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.customlayoutforlistview,null);
        StoreEncryp store = arrayList.get(position);
        TextView textView ;
        textView = (TextView) convertView.findViewById(R.id.listviewdesigntextViewID);
        textView.setText(store.getName());
        return convertView;
    }
}
