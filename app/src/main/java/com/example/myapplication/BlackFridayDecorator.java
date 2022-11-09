package com.example.myapplication;

public class BlackFridayDecorator extends HireDecorator{
    public BlackFridayDecorator(HireableMovie hireableMovie) {
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
        // calc for self: 1000*.3 =  300 = 70% discount
        // 70% discount for black Friday deals
        return hireableMovie.getPrice() * .30d;
    }
}
