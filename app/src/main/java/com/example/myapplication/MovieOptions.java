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
    TextView MovieDuration;
    TextView MovieGenre;
    TextView MoviePrice;

    //Buttons
    Button rentMovieButton;
    Button returnMovieButton;
    Button rateMovieButton;

    //creating the activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setting the content view to layout activity_booking xml
        setContentView(R.layout.activity_movie_options);

        //Initilaising the variables created earlier

        //TextViews
        MovieName = (TextView) findViewById(R.id.idTVMovieTitle);
        AgeRating = (TextView) findViewById(R.id.age_rating);
        Description = (TextView) findViewById(R.id.idTVMovieDescription);
        MovieDuration =(TextView) findViewById(R.id.idTVMovieDuration);
        MovieGenre =(TextView) findViewById(R.id.idTVMovieGenre);
        MoviePrice =(TextView) findViewById(R.id.idTVMoviePrice);

        //buttons
        rentMovieButton = (Button) findViewById(R.id.rent_movie);
        returnMovieButton = (Button) findViewById(R.id.return_movie);
        rateMovieButton = (Button) findViewById(R.id.rate_movie);


    }
}
