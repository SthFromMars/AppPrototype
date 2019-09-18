package com.example.prototype;

import java.util.ArrayList;

public class User {
    String name;
    String password;
    ArrayList<Product> cart;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
