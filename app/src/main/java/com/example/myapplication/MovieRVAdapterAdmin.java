package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieRVAdapterAdmin extends RecyclerView.Adapter<MovieRVAdapterAdmin.ViewHolder> {

    // variable for array list and context
    private ArrayList<MovieModal> movieModalArrayList;
    private Context context;

    // constructor
    public MovieRVAdapterAdmin(ArrayList<MovieModal> movieModalArrayList, Context context) {
        this.movieModalArrayList = movieModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflating layout file for the recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Setting data to the views of recycler view item.
        MovieModal modal = movieModalArrayList.get(position);
        holder.movieTitleTV.setText(modal.getMovieTitle());
        holder.movieDurationTV.setText(modal.getMovieDuration());
        holder.movieGenreTV.setText(modal.getMovieGenre());
        holder.movieDescriptionTV.setText(modal.getMovieDescription());
        holder.moviePriceTV.setText(modal.getMoviePrice());

        // Add on click listener to the recycler view item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, UpdateMovies.class);

                // Passing all the values.
                i.putExtra("title", modal.getMovieTitle());
                i.putExtra("duration", modal.getMovieDuration());
                i.putExtra("genre", modal.getMovieGenre());
                i.putExtra("description", modal.getMovieDescription());
                i.putExtra("price", modal.getMoviePrice());

                // starting the activity.
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of the array list
        return movieModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for the text views.
        private TextView movieTitleTV, movieDurationTV, movieGenreTV, movieDescriptionTV, moviePriceTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initialising the text views
            movieTitleTV = itemView.findViewById(R.id.idTVMovieTitle);
            movieDurationTV = itemView.findViewById(R.id.idTVMovieDuration);
            movieGenreTV = itemView.findViewById(R.id.idTVMovieGenre);
            movieDescriptionTV = itemView.findViewById(R.id.idTVMovieDescription);
            moviePriceTV = itemView.findViewById(R.id.idTVMoviePrice);
        }
    }
}
