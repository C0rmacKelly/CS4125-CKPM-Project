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

public class MovieRVAdapterUser extends RecyclerView.Adapter<MovieRVAdapterUser.ViewHolder> {

    // variable for array list and context
    private ArrayList<MovieDTO> movieDTOArrayList;
    private Context context;

    // constructor
    public MovieRVAdapterUser(ArrayList<MovieDTO> movieModalArrayList, Context context) {
        this.movieDTOArrayList = movieModalArrayList;
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
        MovieDTO DTO = movieDTOArrayList.get(position);
        holder.movieTitleTV.setText(DTO.getMovieTitle());
        holder.movieDurationTV.setText(DTO.getMovieDuration());
        holder.movieGenreTV.setText(DTO.getMovieGenre());
        holder.movieDescriptionTV.setText(DTO.getMovieDescription());
        holder.moviePriceTV.setText(DTO.getMoviePrice());
        holder.moviePriceType.setText(DTO.getPriceType());

        // Add on click listener to the recycler view item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, MovieOptions.class);

                // Passing all the values.
                i.putExtra("title", DTO.getMovieTitle());
                i.putExtra("duration", DTO.getMovieDuration());
                i.putExtra("genre", DTO.getMovieGenre());
                i.putExtra("description", DTO.getMovieDescription());
                i.putExtra("price", DTO.getMoviePrice());
                i.putExtra("priceType",DTO.getPriceType());

                // starting the activity.
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of the array list
        return movieDTOArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for the text views.
        private TextView movieTitleTV, movieDurationTV, movieGenreTV, movieDescriptionTV, moviePriceTV, moviePriceType;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initialising the text views
            movieTitleTV = itemView.findViewById(R.id.idTVMovieTitle);
            movieDurationTV = itemView.findViewById(R.id.idTVMovieDuration);
            movieGenreTV = itemView.findViewById(R.id.idTVMovieGenre);
            movieDescriptionTV = itemView.findViewById(R.id.idTVMovieDescription);
            moviePriceTV = itemView.findViewById(R.id.idTVMoviePrice);
            moviePriceType = itemView.findViewById(R.id.idTVPriceType);
        }
    }
}
