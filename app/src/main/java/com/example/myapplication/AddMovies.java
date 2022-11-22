package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class AddMovies extends AppCompatActivity {

    // Creating variables for edittext, button and dbhandler
    private EditText movieTitleEdt, movieDurationEdt, movieGenreEdt, movieDescriptionEdt, moviePriceEdt;
    private Button addMovieBtn, readMovieBtn;
    private MovieDB dbHandler;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movies);

        // Initialising all variables.
        movieTitleEdt = findViewById(R.id.idEdtMovieTitle);
        movieDurationEdt = findViewById(R.id.idEdtMovieDuration);
        movieGenreEdt = findViewById(R.id.idEdtMovieGenre);
        movieDescriptionEdt = findViewById(R.id.idEdtMovieDescription);
        moviePriceEdt = findViewById(R.id.idEdtMoviePrice);
        addMovieBtn = findViewById(R.id.idBtnAddMovie);
        readMovieBtn = findViewById(R.id.idBtnReadMovie);

        // Creating a new dbhandler class and passing our context to it.
        dbHandler = new MovieDB(AddMovies.this);

        // Add on click listener for add movie button.
        addMovieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Getting data from all edit text fields.
                String movieTitle = movieTitleEdt.getText().toString();
                String movieDuration = movieDurationEdt.getText().toString();
                String movieGenre = movieGenreEdt.getText().toString();
                String movieDescription = movieDescriptionEdt.getText().toString();
                String moviePrice = moviePriceEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (movieTitle.isEmpty() && movieDuration.isEmpty() && movieGenre.isEmpty() && movieDescription.isEmpty() && moviePrice.isEmpty()) {
                    Toast.makeText(AddMovies.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Calling addNewMovie method to add new movie to sqlite data and pass all values to it.
                dbHandler.addNewMovie(movieTitle, movieDuration, movieGenre, movieDescription, moviePrice);

                // After adding the data, we are displaying a toast message.
                Toast.makeText(AddMovies.this, "Movie has been added.", Toast.LENGTH_SHORT).show();
                movieTitleEdt.setText("");
                movieDurationEdt.setText("");
                movieGenreEdt.setText("");
                movieDescriptionEdt.setText("");
                moviePriceEdt.setText("");
            }
        });

        readMovieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(AddMovies.this, ViewMovies.class);
                startActivity(i);
            }
        });
    }
}
