package com.example.myapplication;

// using this decorator to help add multiple offers
public abstract class SubscribeDecorator extends HireableSubscription {
    HireableSubscription hireableSubscription;

    public SubscribeDecorator(HireableSubscription hireableSubscription){
        this.hireableSubscription = hireableSubscription;
    }

    public String getSubscription() {
        return hireableSubscription.getSubscription();
    }

    public double getPrice() {
        return hireableSubscription.getPrice();
    }
}
