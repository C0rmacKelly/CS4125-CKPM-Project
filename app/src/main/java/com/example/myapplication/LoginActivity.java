package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {
    // Variables declared
    MaterialButton loginbtn;
    TextView username, password, registerHere;
    ImageView ckpm;
    Login_RegisterDBHelper DB;
    // test


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initializing variables
        username =(TextView) findViewById(R.id.username);
        password =(TextView) findViewById(R.id.password);
        loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
        ckpm = (ImageView) findViewById(R.id.ckpm);

        DB = new Login_RegisterDBHelper(LoginActivity.this);


        // Pressing LOGIN button will bring user to new page
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Checking username and password
                String user = username.getText().toString();
                String pass = password.getText().toString();

                // Will check for user in database later
                Boolean check_user = DB.checkUsernamePassword(user,pass);
                Boolean check_user_type = DB.checkUserTypeAdmin(user);

                 if(check_user_type == true)
                 {
                     // If login details provided are correct  display message to user
                     Toast.makeText(LoginActivity.this,"Login Successful! - Admin",Toast.LENGTH_SHORT).show();
                     openViewAddMovieActivity();
                 }

                 else {
                     if(check_user == true) {
                         Toast.makeText(LoginActivity.this,"Login Successful! - User",Toast.LENGTH_SHORT).show();
                         Intent addActivityIntent = new Intent(getBaseContext(), UserView.class);
                         startActivity(addActivityIntent);
                     }

                     else
                         // If login details provided are incorrect display message to user
                         Toast.makeText(LoginActivity.this,"Credentials Entered Incorrect!!",Toast.LENGTH_SHORT).show();
                 }

            }
        });
    }

    // this class will open the new register activity which holds the register form
    public void openRegisterActivity() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void openViewAddMovieActivity() {
        Intent intent = new Intent(this, AddMovies.class);
        startActivity(intent);
    }

    // Bring user to register page after clicking 'register here'
    public void registerClick (View view) {
        openRegisterActivity();
    }
}