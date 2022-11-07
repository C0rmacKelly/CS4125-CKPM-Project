package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserView extends AppCompatActivity {
    //declaring the variables

    //Buttons
    Button viewMovies;
    Button Subscriptions;


    //creating the activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setting the content view to layout activity_booking xml
        setContentView(R.layout.activity_user_view);

        //Initilaising the variables created earlier

        //buttons
        viewMovies = (Button) findViewById(R.id.view_movie);
        Subscriptions = (Button) findViewById(R.id.subscriptions);

        //Making the buttons
        viewMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addActivityIntent = new Intent(getBaseContext(), ViewMovies.class);
                startActivity(addActivityIntent);
            }

        });
    }

}
