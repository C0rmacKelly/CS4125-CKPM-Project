package com.example.myapplication;

public class MovieDTO {

    // Initialising variables for movie title, duration, genre, description, price, id.
    private int id;
    private String movieTitle;
    private String movieDuration;
    private String movieGenre;
    private String movieDescription;
    private String moviePrice;
    private String priceType;

    // Creating getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMoviePrice() {
        return moviePrice;
    }
    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }
    public void setMoviePrice(String moviePrice) {
        this.moviePrice = moviePrice;
    }

    // constructor
    public MovieDTO(String movieTitle, String movieDuration, String movieGenre, String movieDescription, String moviePrice, String priceType) {
        this.movieTitle = movieTitle;
        this.movieDuration = movieDuration;
        this.movieGenre = movieGenre;
        this.movieDescription = movieDescription;
        this.moviePrice = moviePrice;
        this.priceType = priceType;
    }
}