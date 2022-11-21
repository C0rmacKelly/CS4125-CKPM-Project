package com.example.myapplication;

public class StandardSubscription extends HireableSubscription{
    @Override
    public String getSubscription() {
        return "Standard Subscription";
    }

    public double getPrice(){
        return 5.0d;
    }
}
