package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class AddMovies extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // Creating variables for edittext, button and dbhandler
    private EditText movieTitleEdt, movieDurationEdt, movieGenreEdt, movieDescriptionEdt, moviePriceEdt;
    private Button addMovieBtn, readMovieBtn, customersInfo;
    private MovieDB dbHandler;

    private String priceType;


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
        customersInfo = findViewById(R.id.idCustomersInfo);

        // Creating a new dbhandler class and passing our context to it.
        dbHandler = new MovieDB(AddMovies.this);

        Spinner dropdown = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.priceTypes_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);

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
                dbHandler.addNewMovie(movieTitle, movieDuration, movieGenre, movieDescription, moviePrice, priceType);

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

        customersInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(AddMovies.this, ViewCustomerInfo.class);
                startActivity(i);
                Toast.makeText(AddMovies.this,"Login Successful!",Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //this String holds the itemSelected value (PriceType)
         priceType = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}