package com.example.myapplication;

public class SubscriptionsOffersMain {
    // testing
    public static void main(String[] args){

        // testing here.
        // need to add if statements and will use the membership variables after implementing the decorators
        // membership variables from here will be displayed on register page after 'decorating' them
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
