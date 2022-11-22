package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Login_RegisterDBHelper extends SQLiteOpenHelper {

    private static final String DBName = "login-Register.db";

    private static final String Table_Name = "users";

    private static final String ID_COL = "id";

    private static final String user_Name = "username";

    private static final String user_Type = "usertype";

    private static final String Password = "password";

    private static final String Email = "email";

    private static final String Membership_Type = "membership";


    public Login_RegisterDBHelper(Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String queryCreateTable = "CREATE TABLE " + Table_Name + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + user_Name + " TEXT, "
                + user_Type + " TEXT, "
                + Password + " TEXT, "
                + Email + " TEXT, "
                + Membership_Type + " TEXT)";

        sqLiteDatabase.execSQL(queryCreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists users");
        onCreate(sqLiteDatabase);
    }


    public Boolean inputData (String username, String password, String mail, String membership) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();


        ContentValues value = new ContentValues();

        value.put(user_Name, username);
        value.put(user_Type, "Customer");
        value.put(Password, password);
        value.put(Email,mail);
        value.put(Membership_Type,membership);

        long result = sqLiteDatabase.insert(Table_Name,null, value);

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
