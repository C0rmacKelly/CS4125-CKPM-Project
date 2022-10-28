package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewMovies extends AppCompatActivity {

    private ArrayList<MovieModal> movieModalArrayList;
    private MovieDB dbHandler;
    private MovieRVAdapter movieRVAdapter;
    private RecyclerView moviesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_movies);

        movieModalArrayList = new ArrayList<>();
        dbHandler = new MovieDB(ViewMovies.this);

        movieModalArrayList = dbHandler.readMovies();

        movieRVAdapter = new MovieRVAdapter(movieModalArrayList, ViewMovies.this);
        moviesRV = findViewById(R.id.idRVMovies);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewMovies.this, RecyclerView.VERTICAL, false);
        moviesRV.setLayoutManager(linearLayoutManager);

        moviesRV.setAdapter(movieRVAdapter);
    }
}
