package com.example.myapplication;

public class PeakSeasonDecorator extends HireDecorator {
    public PeakSeasonDecorator(HireableMovie hireableMovie) {
        super(hireableMovie);
    }

    public String getTitle() {
        return hireableMovie.getTitle();
    }

    public String getDuration() {
        return hireableMovie.getDuration();
    }

    public String getGenre() {
        return hireableMovie.getGenre();
    }

    public String getDescription() {
        return hireableMovie.getDescription();
    }

    public double getPrice() {
        // increasing the price during peak season
        return hireableMovie.getPrice()  + hireableMovie.getPrice() * .15;
    }
}
