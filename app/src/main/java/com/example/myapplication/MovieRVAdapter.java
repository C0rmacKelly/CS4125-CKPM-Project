package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieRVAdapter extends RecyclerView.Adapter<MovieRVAdapter.ViewHolder> {

    private ArrayList<MovieModal> movieModalArrayList;
    private Context context;

    public MovieRVAdapter(ArrayList<MovieModal> movieModalArrayList, Context context) {
        this.movieModalArrayList = movieModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MovieModal modal = movieModalArrayList.get(position);
        holder.movieTitleTV.setText(modal.getMovieTitle());
        holder.movieDurationTV.setText(modal.getMovieDuration());
        holder.movieGenreTV.setText(modal.getMovieGenre());
        holder.movieDescriptionTV.setText(modal.getMovieDescription());
        holder.moviePriceTV.setText(modal.getMoviePrice());
    }

    @Override
    public int getItemCount() {
        return movieModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView movieTitleTV, movieDurationTV, movieGenreTV, movieDescriptionTV, moviePriceTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieTitleTV = itemView.findViewById(R.id.idTVMovieTitle);
            movieDurationTV = itemView.findViewById(R.id.idTVMovieDuration);
            movieGenreTV = itemView.findViewById(R.id.idTVMovieGenre);
            movieDescriptionTV = itemView.findViewById(R.id.idTVMovieDescription);
            moviePriceTV = itemView.findViewById(R.id.idTVMoviePrice);
        }
    }
}
