package com.example.myapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class Price{
    abstract double getCharge(int daysRented);
}

class RegularPrice extends Price{
    double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }
}
class ChildrensPrice extends Price{
    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }
}
class NewReleasePrice extends Price{
    double getCharge(int daysRented) {
        return daysRented * 3;
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
    public static void main(String args[])throws IOException {
        GetPriceFactory priceFactory = new GetPriceFactory();

        System.out.print("Enter the name of type of price for which the bill will be generated: ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String priceName=br.readLine();
        System.out.print("Enter the quantity for which the bill will be calculated: ");
        int units=Integer.parseInt(br.readLine());

        Price p = priceFactory.getPrice(priceName);

        System.out.print("Movie price amount for "+priceName+" of  "+units+" units is: ");

        p.getCharge();

        p.calculateBill(units);
    }
}