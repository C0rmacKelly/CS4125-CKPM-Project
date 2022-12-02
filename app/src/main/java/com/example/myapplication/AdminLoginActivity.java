package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class AdminLoginActivity extends AppCompatActivity {
    // Variables declared
    MaterialButton loginbtn;
    TextView username, password;
    ImageView ckpm;
    Login_RegisterDBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        // Initializing variables
        username =(TextView) findViewById(R.id.username);
        password =(TextView) findViewById(R.id.password);
        loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
        ckpm = (ImageView) findViewById(R.id.ckpm);


        db = new Login_RegisterDBHelper(AdminLoginActivity.this);

        // Pressing LOGIN button will bring user to new page
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Checking username and password
                String user = username.getText().toString();
                String pass = password.getText().toString();


                Boolean check_user = db.checkUserAdmin(user,pass);

                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    // If login details provided are correct  display message to user
                    openViewAddMovieActivity();
                }
                else
                    // If login details provided are incorrect display message to user
                    Toast.makeText(AdminLoginActivity.this,"Credentials Entered Incorrect!!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openViewAddMovieActivity() {
        Intent intent = new Intent(this, AddMovies.class);
        startActivity(intent);
    }


}

