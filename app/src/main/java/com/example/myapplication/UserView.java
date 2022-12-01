package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class UserView extends AppCompatActivity {
    //declaring the variables

    //Buttons
    Button viewMovies;
    Button Subscriptions;
    Button customerView;

    //creating the activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setting the content view to layout activity_booking xml
        setContentView(R.layout.activity_user_view);

        //buttons
        viewMovies = (Button) findViewById(R.id.view_movie);
        Subscriptions = (Button) findViewById(R.id.subscriptions);

        //Making the buttons
        viewMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewMoviesActivity();
            }

        });

        Subscriptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSubscriptionActivity();
            }

        });
    }

    public void openViewMoviesActivity() {
        Intent intent = new Intent(this, ViewMoviesUser.class);
        startActivity(intent);
    }


    public void openSubscriptionActivity() {
        Intent intent = new Intent(this, SubscriptionView.class);
        startActivity(intent);
    }


}

