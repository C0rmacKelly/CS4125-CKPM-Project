package com.example.myapplication;

abstract class price {
    abstract double getCharge(int daysRented);

    public  Double calculatePrice(int daysRented){
        return daysRented*getCharge(daysRented);
    }
}
