package com.example.prototype;

import java.util.ArrayList;

public class Cart {
    public static Cart instance = new Cart();
    ArrayList<Gift> gifts = new ArrayList<>();
    Decoration decoration = null;
    private Cart(){}
    public static Cart getInstance() {return instance;}
    public double getFullPrice(){
        double price = 0;
        for(Gift gift: gifts){
            price+= gift.price;
        }
        if(decoration!=null) price += decoration.price*decoration.numberOfPeople;
        return price;
    }
}
