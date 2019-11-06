package com.example.prototype;

import java.util.ArrayList;

public class Order {
    String name;
    String phoneNr;
    String address;
    String Email;
    Cart cart;
    //ArrayList<Gift> gifts;
    //Decoration decoration;
    int status = 0;
    int paymentType = -1;
    Organizer organizer;

    public Order(String name, String phoneNr, String address, String email, Cart cart, Organizer organizer) {
        this.name = name;
        this.phoneNr = phoneNr;
        this.address = address;
        Email = email;
        this.cart = cart;
        //this.gifts = gifts;
        //this.decoration = decoration;
        this.organizer = organizer;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return Email;
    }

    public int getStatus() {return status;}

    public void setStatus(int status) {this.status = status;}

    /*public ArrayList<Gift> getGift() {
        return gifts;
    }

    //public Decoration getDecoration() {
        return decoration;
    }*/

    public Cart getCart() {
        return cart;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public Organizer getOrganizer() {
        return organizer;
    }
}
