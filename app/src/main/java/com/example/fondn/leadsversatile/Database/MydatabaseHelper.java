package com.example.fondn.leadsversatile.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MydatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASENAME = "Student";
    private static final String TABLE_NAME = "Student_Details";
    private static final String NAME = "Name";
    private static final String ID = "_id";
    private static final String MAIL = "mail";
    private static final String USERNAME = "userName";
    private static final String PASSWORS = "password";
    private static final int VERSION = 1;
    private static final String CREATEDATABASE = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VERCHAR(255)," + USERNAME + " VERCHAR(255),"+MAIL+" VERCHAR(255), " + PASSWORS + " VERCHAR);";
    private static final String DROPTABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String SELECTDATA = "SELECT * FROM " + TABLE_NAME;
    private Context context;


    public MydatabaseHelper(Context context) {
        super(context, DATABASENAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       // Toast.makeText(context, "on Create Database", Toast.LENGTH_SHORT).show();
       // Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
        try {
            db.execSQL(CREATEDATABASE);
            Toast.makeText(context, "Successfully Database Created ..", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
           // Toast.makeText(context, "Exception Found : " + e, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Toast.makeText(context, "On Upgrade Call", Toast.LENGTH_SHORT).show();
            Toast.makeText(context, "Its Updated", Toast.LENGTH_SHORT).show();
            db.execSQL(DROPTABLE);
            onCreate(db);




        } catch (Exception e) {
            Toast.makeText(context, "Exception : " + e, Toast.LENGTH_SHORT).show();
        }

    }


    public long insertData(String name, String userName,String mail, String password) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(USERNAME,userName);
        contentValues.put(MAIL, mail);
        contentValues.put(PASSWORS, password);
        long rowid = database.insert(TABLE_NAME, null, contentValues);
        return rowid;
    }

    public Cursor showDataFromDatabase() {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(SELECTDATA, null);
        return cursor;
    }



    public int deleteData(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(TABLE_NAME,ID+" = ?",new String[] {id});

    }


    public Boolean findpasswordanduserName(String userNameP,String passowrdP){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from "+TABLE_NAME,null);
        Boolean result = false;

        if(cursor.getCount()==0){
            Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                //String useName = cursor.getString(2);
                //String pass = cursor.getString(4);
                String useName = cursor.getString(cursor.getColumnIndex(MydatabaseHelper.USERNAME));
                String pass = cursor.getString(cursor.getColumnIndex(MydatabaseHelper.PASSWORS));


                if(useName.equals(userNameP) && pass.equals(passowrdP)){
                    result = true;
                    break;
                }
            }

        }

        return result;
    }




}
