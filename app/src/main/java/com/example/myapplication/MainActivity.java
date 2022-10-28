package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    // Variables declared
    MaterialButton loginbtn;
    TextView username, password, registerHere;
    ImageView ckpm;
    // get rid later
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing variables
        username =(TextView) findViewById(R.id.username);
        password =(TextView) findViewById(R.id.password);
        loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
        ckpm = (ImageView) findViewById(R.id.ckpm);

        // Press LOGIN button will bring user to new page
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Checking username and password
                // Will check for user in database later
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    // ignore for now just adding so can test
                    i++;
                }else
                    // ignore for now just adding so can test
                    i++;
            }
        });
    }
}