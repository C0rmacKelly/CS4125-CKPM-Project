package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Login_RegisterDBHelper extends SQLiteOpenHelper {

    public static final String DBName = "login2.db";

    public Login_RegisterDBHelper(Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table users(username TEXT primary key, password TEXT, email TEXT, membership_type TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists users");
        onCreate(sqLiteDatabase);
    }


     public Boolean inputData (String username, String password, String mail, String membership) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues value = new ContentValues();

        value.put("username", username);
        value.put("password", password);
        value.put("email",mail);
         value.put("membership_type",membership);


        long result = sqLiteDatabase.insert("users",null, value);

        if(result == 1)
            return false;
        else
            return true;
    }


    public Boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from users where username=? and password=?", new String[] {username,password});
        if (cursor.getCount() > 0){
            return true;
        }
        else
            return false;
    }

}
