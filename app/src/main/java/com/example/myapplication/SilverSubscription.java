package com.example.myapplication;

public class SilverSubscription extends HireableSubscription{
    @Override
    public String getSubscription() {
        return "Silver Subscription";
    }

    public double getPrice(){
        return 10.0d;
    }
}
