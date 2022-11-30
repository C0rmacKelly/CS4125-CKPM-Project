package com.example.myapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

abstract class Price{
    protected double price;
    abstract void getCharge();

    public void calculatePrice(int daysRented){
        System.out.println(daysRented*price);
    }
}

class RegularPrice extends Price{
    public void getCharge(){
        price=3.50;
    }
}
class ChildrensPrice extends Price{
    public void getCharge(){
        price=5;
    }
}
class NewReleasePrice extends Price{
    public void getCharge(){
        price=7;
    }
}

class GetPriceFactory{
    public Price getPrice(String priceType){
        if(priceType == null){
            return null;
        }
        if(priceType.equalsIgnoreCase("REGULARPRICE")) {
            return new RegularPrice();
        }
        else if(priceType.equalsIgnoreCase("CHILDRENSPRICE")){
            return new ChildrensPrice();
        }
        else if(priceType.equalsIgnoreCase("NEWRELEASEPRICE")) {
            return new NewReleasePrice();
        }
        return null;
    }
}

class GeneratePrice{
    public static void main(String args[]) {
        GetPriceFactory priceFactory = new GetPriceFactory();

        System.out.print("Enter the name of type of price for which the bill will be generated: ");
        Scanner priceTypeInput = new Scanner(System.in);

        String priceName= priceTypeInput.next();
        System.out.print("Enter the number of days for which you are renting the movie for: ");
        Scanner daysRentInput = new Scanner(System.in);

        int daysRented=Integer.parseInt(daysRentInput.next());

        Price p = priceFactory.getPrice(priceName);

        System.out.print("Movie price amount for "+priceName+" of  "+daysRented+" units is: ");

        p.getCharge();
        p.calculatePrice(daysRented);
    }
}