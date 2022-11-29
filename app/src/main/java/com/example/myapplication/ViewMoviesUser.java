package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewMoviesUser extends AppCompatActivity {

    // creating variables for the array list, dbhandler, adapter and recycler view.
    private ArrayList<MovieDTO> movieDTOArrayList;
    private MovieDB dbHandler;
    private MovieRVAdapterUser movieRVAdapterUser;
    private RecyclerView moviesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_movies);

        // initialising all variables.
        movieDTOArrayList = new ArrayList<>();
        dbHandler = new MovieDB(ViewMoviesUser.this);

        // getting the movie array list from db handler class.
        movieDTOArrayList = dbHandler.readMovies();

        // Passing the array list to the adapter class.
        movieRVAdapterUser = new MovieRVAdapterUser(movieDTOArrayList, ViewMoviesUser.this );
        moviesRV = findViewById(R.id.idRVMovies);

        // setting layout manager for the recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewMoviesUser.this, RecyclerView.VERTICAL, false);
        moviesRV.setLayoutManager(linearLayoutManager);

        // setting adapter to recycler view.
        moviesRV.setAdapter(movieRVAdapterUser);
    }
}
