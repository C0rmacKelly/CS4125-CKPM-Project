package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Login_RegisterDBHelper extends SQLiteOpenHelper {

    private static final String DBName = "login.db";

//    private static final String Table_Name = "users";
//
//    private static final String ID_COL = "id";
//
//    private static final String User = "username";
//
//    private static final String User_Type = "usertype";
//
//    private static final String Password = "password";
//
//    private static final String Email = "email";
//
//    private static final String Membership_Type = "membership";


    public Login_RegisterDBHelper(Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

//       String queryCreateTable = "CREATE TABLE " + Table_Name + " ("
//               + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//               + User + " TEXT, "
//               + User_Type + " TEXT, "
//               + Password + " TEXT, "
//               + Email + " TEXT, "
//               + Membership_Type + " TEXT)";
//
//       sqLiteDatabase.execSQL(queryCreateTable);

        sqLiteDatabase.execSQL("create table users(username TEXT primary key, user_type TEXT, password TEXT, email TEXT, membership_type TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists users");
        onCreate(sqLiteDatabase);
    }


     public Boolean inputData (String username, String user_type, String password, String mail, String membership) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues value = new ContentValues();

        value.put("username", username);
        value.put("user_type", user_type);
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
