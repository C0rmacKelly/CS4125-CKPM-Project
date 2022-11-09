package com.example.myapplication;

public abstract class HireableMovie {
    private String title;
    private String duration;
    private String genre;
    private String description;
    private double price;

    public abstract String getTitle();
    public abstract String getDuration();
    public abstract String getGenre();
    public abstract String getDescription();
    public abstract double getPrice();
}
