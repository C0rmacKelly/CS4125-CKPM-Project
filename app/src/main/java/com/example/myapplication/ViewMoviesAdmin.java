package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewMoviesAdmin extends AppCompatActivity {

    // creating variables for the array list, dbhandler, adapter and recycler view.
    private ArrayList<MovieModal> movieModalArrayList;
    private MovieDB dbHandler;
    private MovieRVAdapterAdmin movieRVAdapterAdmin;
    private RecyclerView moviesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_movies);

        // initialising all variables.
        movieModalArrayList = new ArrayList<>();
        dbHandler = new MovieDB(ViewMoviesAdmin.this);

        // getting the movie array list from db handler class.
        movieModalArrayList = dbHandler.readMovies();

        // Passing the array list to the adapter class.
        movieRVAdapterAdmin = new MovieRVAdapterAdmin(movieModalArrayList, ViewMoviesAdmin.this );
        moviesRV = findViewById(R.id.idRVMovies);

        // setting layout manager for the recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewMoviesAdmin.this, RecyclerView.VERTICAL, false);
        moviesRV.setLayoutManager(linearLayoutManager);

        // setting adapter to recycler view.
        moviesRV.setAdapter(movieRVAdapterAdmin);
    }
}
