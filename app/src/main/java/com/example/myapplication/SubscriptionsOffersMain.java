package com.example.myapplication;

public class SubscriptionsOffersMain {
    // testing
    public static void main(String[] args){
        HireableSubscription standardSubscription = new StandardSubscription();

        standardSubscription = new BlackFridayDecorator(standardSubscription);

        System.out.println("Black Friday" + standardSubscription.getPrice());

        standardSubscription = new BlackFridayDecorator(new PeakSeasonDecorator(new StandardSubscription()));
        System.out.println("Black Friday offer during peak season" + standardSubscription.getPrice());

        HireableSubscription goldSubscription = new GoldSubscription();
        goldSubscription = new PeakSeasonDecorator(new RegularDayDecorator(goldSubscription));
        System.out.println("Subscribing during peak season on regular day " + goldSubscription.getPrice());


    }
}
