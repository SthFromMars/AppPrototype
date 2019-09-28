package com.example.prototype;

public class Order {
    String name;
    String phoneNr;
    String address;
    String Email;
    Gift gift;
    Decoration decoration;
    int status = 0;
    int paymentType = -1;
    Organizer organizer;

    public Order(String name, String phoneNr, String address, String email, Gift gift, Decoration decoration, Organizer organizer) {
        this.name = name;
        this.phoneNr = phoneNr;
        this.address = address;
        Email = email;
        this.gift = gift;
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

    public Gift getGift() {
        return gift;
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
