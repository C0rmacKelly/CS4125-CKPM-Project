package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class AddMovies extends AppCompatActivity {

    private EditText movieTitleEdt, movieDurationEdt, movieGenreEdt, movieDescriptionEdt, moviePriceEdt;
    private Button addMovieBtn, readMovieBtn;
    private MovieDB dbHandler;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieTitleEdt = findViewById(R.id.idEdtMovieTitle);
        movieDurationEdt = findViewById(R.id.idEdtMovieDuration);
        movieGenreEdt = findViewById(R.id.idEdtMovieGenre);
        movieDescriptionEdt = findViewById(R.id.idEdtMovieDescription);
        moviePriceEdt = findViewById(R.id.idEdtMoviePrice);
        addMovieBtn = findViewById(R.id.idBtnAddMovie);
        readMovieBtn = findViewById(R.id.idBtnReadMovie);

        dbHandler = new MovieDB(AddMovies.this);

        addMovieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String movieTitle = movieTitleEdt.getText().toString();
                String movieDuration = movieDurationEdt.getText().toString();
                String movieGenre = movieGenreEdt.getText().toString();
                String movieDescription = movieDescriptionEdt.getText().toString();
                String moviePrice = moviePriceEdt.getText().toString();

                if (movieTitle.isEmpty() && movieDuration.isEmpty() && movieGenre.isEmpty() && movieDescription.isEmpty() && moviePrice.isEmpty()) {
                    Toast.makeText(AddMovies.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addNewMovie(movieTitle, movieDuration, movieGenre, movieDescription, moviePrice);

                Toast.makeText(AddMovies.this, "Movie has been added.", Toast.LENGTH_SHORT).show();
                movieTitleEdt.setText("");
                movieDurationEdt.setText("");
                movieGenreEdt.setText("");
                movieDescriptionEdt.setText("");
                moviePriceEdt.setText("€");
            }
        });

        readMovieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddMovies.this, ViewMovies.class);
                startActivity(i);
            }
        });
    }
}
