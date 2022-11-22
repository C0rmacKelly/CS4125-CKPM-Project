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
    private TextView MovieName, AgeRating,  Description, MovieDuration, MovieGenre, MoviePrice;
    private String MovieNametxt,AgeRatingtxt,Descriptiontxt, MovieDurationtxt,MovieGenretxt,MoviePricetxt;


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

        // Getting data which was passed in the adapter class.
        MovieNametxt = getIntent().getStringExtra("title");
        MovieDurationtxt = getIntent().getStringExtra("duration");
        MovieGenretxt = getIntent().getStringExtra("genre");
        Descriptiontxt = getIntent().getStringExtra("description");
        MoviePricetxt = getIntent().getStringExtra("price");


        // setting data to edit text of the update activity.

        MovieName.setText(MovieNametxt);
        //AgeRating.setText(MovieDurationtxt);
        Description.setText(Descriptiontxt);
        MovieDuration.setText(MovieDurationtxt);
        MovieGenre.setText(MovieGenretxt);
        MoviePrice.setText(MoviePricetxt);




//buttons
        rentMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), RentMovie.class);
                // Passing all the values to go from this activity to another (Note: this information is being passed to the third activity, rent_activity)
                i.putExtra("title2", MovieNametxt );
                i.putExtra("price2", MoviePricetxt );
                startActivity(i);
            }

        });
        returnMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ActivityIntent = new Intent(getBaseContext(), ReturnMovie.class);
                startActivity(ActivityIntent);
            }

        });
       rateMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ActivityIntent = new Intent(getBaseContext(), RateMovie.class);
                startActivity(ActivityIntent);
            }

        });

    }
}
