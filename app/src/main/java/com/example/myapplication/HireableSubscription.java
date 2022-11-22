package com.example.myapplication;

public abstract class HireableSubscription {
    private String subscription;
    private double price;

    public abstract String getSubscription();
    public abstract double getPrice();
}
