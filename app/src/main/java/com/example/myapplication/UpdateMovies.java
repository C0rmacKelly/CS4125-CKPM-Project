package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateMovies extends AppCompatActivity {

    private EditText movieTitleEdt, movieDurationEdt, movieGenreEdt, movieDescriptionEdt, moviePriceEdt;
    private Button updateMovieBtn, deleteMovieBtn;
    private MovieDB dbHandler;
    String movieTitle, movieDuration, movieGenre, movieDescription, moviePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_movie);

        movieTitleEdt = findViewById(R.id.idEdtMovieTitle);
        movieDurationEdt = findViewById(R.id.idEdtMovieDuration);
        movieGenreEdt = findViewById(R.id.idEdtMovieGenre);
        movieDescriptionEdt = findViewById(R.id.idEdtMovieDescription);
        moviePriceEdt = findViewById(R.id.idEdtMoviePrice);
        updateMovieBtn = findViewById(R.id.idBtnUpdateMovie);
        deleteMovieBtn = findViewById(R.id.idBtnDeleteMovie);

        dbHandler = new MovieDB(UpdateMovies.this);

        movieTitle = getIntent().getStringExtra("title");
        movieDuration = getIntent().getStringExtra("duration");
        movieGenre = getIntent().getStringExtra("genre");
        movieDescription = getIntent().getStringExtra("description");
        moviePrice = getIntent().getStringExtra("price");

        movieTitleEdt.setText(movieTitle);
        movieDurationEdt.setText(movieDuration);
        movieGenreEdt.setText(movieGenre);
        movieDescriptionEdt.setText(movieDescription);
        moviePriceEdt.setText(moviePrice);

        updateMovieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHandler.updateMovie(movieTitle, movieTitleEdt.getText().toString(), movieDurationEdt.getText().toString(), movieGenreEdt.getText().toString(), movieDescriptionEdt.getText().toString(), moviePriceEdt.getText().toString());

                Toast.makeText(UpdateMovies.this, "Movie Updated..", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(UpdateMovies.this, AddMovies.class);
                startActivity(i);
            }
        });

        deleteMovieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHandler.deleteMovie(movieTitle);
                Toast.makeText(UpdateMovies.this, "Deleted the movie", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateMovies.this, AddMovies.class);
                startActivity(i);
            }
        });
    }
}
