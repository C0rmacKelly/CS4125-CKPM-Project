package com.example.myapplication;

public class GetPriceFactory {
    public price getPrice(String priceType){
        if(priceType == null){
            return null;
        }
        if(priceType.equalsIgnoreCase("REGULARPRICE")) {
            return new RegularPrice();
        }
        else if(priceType.equalsIgnoreCase("ONSALEPRICE")){
            return new OnSalePrice();
        }
        else if(priceType.equalsIgnoreCase("NEWRELEASEPRICE")) {
            return new NewReleasePrice();
        }
        return null;
    }
}
