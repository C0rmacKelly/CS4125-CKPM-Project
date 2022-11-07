package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

public class MovieOptions extends AppCompatActivity {
    //declaring the variables

    //TextViews
    TextView MovieName;
    TextView AgeRating;
    TextView Description;

    //Buttons
    Button rentMovieButton;
    Button returnMovieButton;
    Button rateMovieButton;
    Button BackButton;

    //creating the activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setting the content view to layout activity_booking xml
        setContentView(R.layout.activity_movie_options);

        //Initilaising the variables created earlier

        //TextViews
        MovieName = (TextView) findViewById(R.id.movie_name);
        AgeRating = (TextView) findViewById(R.id.age_rating);
        Description = (TextView) findViewById(R.id.description);

        //buttons
        rentMovieButton = (Button) findViewById(R.id.rent_movie);
        returnMovieButton = (Button) findViewById(R.id.return_movie);
        rateMovieButton = (Button) findViewById(R.id.rate_movie);
        BackButton = (Button) findViewById(R.id.back_button);


        BackButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addActivityIntent = new Intent(getBaseContext(), UserView.class);
                startActivity(addActivityIntent);
            }

        });
    }
}
