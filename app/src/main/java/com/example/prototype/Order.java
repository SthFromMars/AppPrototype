package com.example.prototype;

import java.util.ArrayList;

public class Order {
    String name;
    String phoneNr;
    String address;
    String Email;
    ArrayList<Gift> gifts;
    Decoration decoration;
    int status = 0;
    int paymentType = -1;
    Organizer organizer;

    public Order(String name, String phoneNr, String address, String email, ArrayList<Gift> gifts, Decoration decoration, Organizer organizer) {
        this.name = name;
        this.phoneNr = phoneNr;
        this.address = address;
        Email = email;
        this.gifts = gifts;
        this.decoration = decoration;
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

    public ArrayList<Gift> getGift() {
        return gifts;
    }

    public Decoration getDecoration() {
        return decoration;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public Organizer getOrganizer() {
        return organizer;
    }
}
