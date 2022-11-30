package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RentMovie extends AppCompatActivity {
    //declaring the variables
    //TextViews
    private TextView MovieName;
    private TextView Total_cost;
    //EditText
    private EditText RentDurationEdt;
    private String MovieNametxt;
    private String pricetxt, total_costtxt;
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
        RentDurationEdt = (EditText) findViewById(R.id.rent_duration);
        Total_cost = (TextView) findViewById(R.id.total_cost);
        checkoutbutton = (Button) findViewById(R.id.checkout);


        // initialising the dbhandler class.
        dbHandler = new MovieDB(RentMovie.this );
        //showFullDatabase();

        // Getting data which was passed in the adapter class.
        MovieNametxt = getIntent().getStringExtra("title2");
        pricetxt = getIntent().getStringExtra("price2");

        double price2 = Double.parseDouble(pricetxt);
        price2 = price2*2.02 ;

        total_costtxt = String.valueOf(price2);

        // setting data to edit text of the update activity.
        MovieName.setText(MovieNametxt);
        Total_cost.setText(total_costtxt);


        //checkout button
        checkoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Calling the update rental method and passing all the edit text values.
                dbHandler.updateDBwithRentalDetails(RentDurationEdt.getText().toString(), total_costtxt);

                // displaying a toast message that the rental has been completed
                Toast.makeText(RentMovie.this, "Movie Has been rented..", Toast.LENGTH_SHORT).show();

                Intent Activity = new Intent( RentMovie.this, PaymentActivity.class);
                startActivity(Activity);
            }

        });
    }

}
