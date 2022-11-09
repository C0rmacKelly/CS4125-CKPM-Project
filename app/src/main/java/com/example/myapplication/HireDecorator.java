package com.example.myapplication;

public abstract class HireDecorator extends HireableMovie {
    HireableMovie hireableMovie;

    public HireDecorator(HireableMovie hireableMovie){
        this.hireableMovie = hireableMovie;
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
        return hireableMovie.getPrice();
    }
}
