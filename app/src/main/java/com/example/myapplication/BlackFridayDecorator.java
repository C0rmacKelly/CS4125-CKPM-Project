package com.example.myapplication;

public class BlackFridayDecorator extends SubscribeDecorator {
    public BlackFridayDecorator(HireableSubscription hireableSubscription) {
        super(hireableSubscription);
    }

    public String getSubscription() {
        return hireableSubscription.getSubscription();
    }

    public double getPrice() {
        // calc for self: 1000*.3 =  300 = 70% discount
        // 70% discount for black Friday deals
        return hireableSubscription.getPrice() * .30;
    }
}
