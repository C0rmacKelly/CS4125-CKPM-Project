package com.example.myapplication;

public class PeakSeasonDecorator extends SubscribeDecorator {
    public PeakSeasonDecorator(HireableSubscription hireableSubscription) {
        super(hireableSubscription);
    }

    public String getSubscription() {
        return hireableSubscription.getSubscription();
    }

    public double getPrice() {
        // increasing the price during peak season
        return hireableSubscription.getPrice()  + hireableSubscription.getPrice() * .15;
    }
}
