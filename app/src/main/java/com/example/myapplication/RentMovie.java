package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Scanner;

public class RentMovie extends AppCompatActivity {
    //declaring the variables
    //TextViews
    private TextView MovieName;
    private TextView Total_cost;
    private TextView rentDuration;

    private String MovieNametxt;
    private String pricetxt, total_costtxt, priceTypetxt, rentDurationtxt;
    //Buttons
    private Button checkoutbutton;
    //MovieDB
    private MovieDB dbHandler;
    //creating the activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setting the content view to layout activity_booking xml
        setContentView(R.layout.activity_rent_movie);

        //Initilaising the variables created earlier

        //TextViews
        MovieName = (TextView) findViewById(R.id.Movie_Name);
        rentDuration = (TextView) findViewById(R.id.rent_duration);
        Total_cost = (TextView) findViewById(R.id.total_cost);

        //button
        checkoutbutton = (Button) findViewById(R.id.checkout);

        // initialising the dbhandler class.
        dbHandler = new MovieDB(RentMovie.this );


        // Getting data which was passed in the adapter class.
        MovieNametxt = getIntent().getStringExtra("title3");
       // pricetxt = getIntent().getStringExtra("price2");
        priceTypetxt = getIntent().getStringExtra("priceType3");
        rentDurationtxt = getIntent().getStringExtra("rentDuration");

        //business logic
        //price of the movie that the Admin specified without charges still
        //double priceAllocated = Double.parseDouble(pricetxt);

        GetPriceFactory priceFactory = new GetPriceFactory();

        // use priceFactory to getPrice of depending on priceType
        price p = priceFactory.getPrice(priceTypetxt);

        //getting the rent duration from the edtbutton to integer
        int daysRented = Integer.parseInt(rentDurationtxt);

        //calculate Charge based on the daysRented
        p.getCharge(daysRented);

        //Calculate the total cost as per the days rented with charges applied.
        //input total_cost to display
        total_costtxt = String.valueOf(p.calculatePrice(daysRented));

        // setting the ids with the results to show to user
        MovieName.setText(MovieNametxt);
        Total_cost.setText(total_costtxt);
        rentDuration.setText(rentDurationtxt);


        //checkout button
        checkoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Calling the update rental method and passing all the edit text values.
                dbHandler.updateDBwithRentalDetails(rentDurationtxt, total_costtxt);

                // displaying a toast message that the rental has been completed
                Toast.makeText(RentMovie.this, "Movie Has been rented..", Toast.LENGTH_SHORT).show();

                Intent Activity = new Intent( RentMovie.this, PaymentActivity.class);
                startActivity(Activity);
            }

        });
    }
}
