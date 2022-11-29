package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RateMovie extends AppCompatActivity {

    //declaring the variables

    //textViews
    private TextView RateMovieHeading, MessageHeading,  RateBarHeading ;

    //EditText
     EditText MessageEdt;
    //RatingBar
    private RatingBar ratingStars;

    //float
    float Rating = 0;
    //Buttons

    private Button RateMovieButton;


    //creating the activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setting the content view to layout activity_booking xml
        setContentView(R.layout.activity_rate_movie);

        //Initilaising the variables created earlier

        //TextViews
        RateMovieHeading = (TextView) findViewById(R.id.rate_movieHeading);
        MessageHeading = (TextView) findViewById(R.id.messageHeading);
        RateBarHeading = (TextView) findViewById(R.id.ratebarHeading);

        //EditText
        MessageEdt = (EditText) findViewById(R.id.message);

        //RatingStar
        ratingStars = findViewById(R.id.ratingBar);

        //buttons
        RateMovieButton = (Button) findViewById(R.id.rate_button);


        ratingStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean fromUser) {
                int rating = (int) v;
                String message = null;

                Rating = ratingBar.getRating();
                switch (rating) {
                    case 1:
                        message = "So sorry to hear that!";
                        break;
                    case 2:
                        message = "Hope next time you have a better experience a movie";
                        break;
                    case 3:
                        message = "There is always another time for another movie!";
                        break;
                    case 4:
                        message = "Great Choice, that movie must've been good";
                        break;
                    case 5:
                        message = "That's amazing, im glad you liked the movie";
                        break;
                }
                Toast.makeText(RateMovie.this,message, Toast.LENGTH_SHORT).show();
            }
        });

//buttons
        RateMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ViewMoviesUser.class);
                Toast.makeText(RateMovie.this,String.valueOf(Rating), Toast.LENGTH_SHORT).show();
                startActivity(i);
            }

        });

    }
}



