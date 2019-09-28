package com.example.prototype;

public class Order {
    String name;
    String phoneNr;
    String address;
    String Email;
    Gift gift;
    Decoration decoration;

    public Order(String name, String phoneNr, String address, String email, Gift gift, Decoration decoration) {
        this.name = name;
        this.phoneNr = phoneNr;
        this.address = address;
        Email = email;
        this.gift = gift;
        this.decoration = decoration;
    }

}
