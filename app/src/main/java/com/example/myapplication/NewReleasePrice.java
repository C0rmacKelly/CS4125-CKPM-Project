package com.example.myapplication;

public class NewReleasePrice extends price {
    double getCharge(int daysRented) {
        return daysRented * 3;
    }
}
