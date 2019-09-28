package com.example.prototype;

public class Cart {
    public static Cart instance = new Cart();
    Gift gift = null;
    Decoration decoration = null;
    private Cart(){}
    public static Cart getInstance() {return instance;}
}
