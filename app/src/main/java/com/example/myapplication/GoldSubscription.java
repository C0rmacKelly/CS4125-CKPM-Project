package com.example.myapplication;

public class GoldSubscription extends HireableSubscription{
    @Override
    public String getSubscription() {
        return "Gold Subscription";
    }

    public double getPrice(){
        return 15.0d;
    }
}
