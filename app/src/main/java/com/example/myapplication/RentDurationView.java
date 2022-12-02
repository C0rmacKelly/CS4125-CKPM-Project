package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RentDurationView extends AppCompatActivity {

    //declaring the variables
    //TextViews
    private TextView MovieName;
    private TextView pricePerMovie;

    //EditText
    private EditText RentDurationEdt;

    //button
    private Button rentMoviebutton;
    //Strings
    String RentDurationtxt, MovieNametxt, pricetxt,priceTypetxt;

    //creating the activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setting the content view to layout activity_booking xml
        setContentView(R.layout.activity_rent_duration);

        //Initilaising the variables created earlier

        //TextViews
        MovieName = (TextView) findViewById(R.id.Movie_Name);
        pricePerMovie = (TextView) findViewById(R.id.pricePerMovie);
        //editText
        RentDurationEdt = (EditText) findViewById(R.id.rent_duration);
        //button
        rentMoviebutton = (Button) findViewById(R.id.rent_button);

        // Getting data which was passed in the adapter class.
        MovieNametxt = getIntent().getStringExtra("title2");
        pricetxt = getIntent().getStringExtra("price2");
        priceTypetxt = getIntent().getStringExtra("priceType2");



        // setting the ids with the results to show to user
        MovieName.setText(MovieNametxt);
        pricePerMovie.setText(pricetxt);

        //brb


        //checkout button
        rentMoviebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RentDurationtxt = RentDurationEdt.getText().toString();

                // displaying a toast message that the rental has been completed
                Toast.makeText(RentDurationView.this, "Rent Duration chosen..", Toast.LENGTH_SHORT).show();

                Intent Activity = new Intent( RentDurationView.this, RentMovie.class);
                Activity.putExtra("rentDuration", RentDurationtxt );
                Activity.putExtra("title3", MovieNametxt);
                Activity.putExtra("priceType3", priceTypetxt);


                startActivity(Activity);
            }

        });
    }





}
