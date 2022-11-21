package com.example.myapplication;

public class RegularDayDecorator extends SubscribeDecorator{
    public RegularDayDecorator(HireableSubscription hireableSubscription) {
        super(hireableSubscription);
    }

    @Override
    public String getSubscription() {
        return super.getSubscription();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }
}
