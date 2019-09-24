package com.example.prototype;

import android.widget.ImageView;

public class Product {
    int id;
    String name;
    String image;
    double price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }

    public void setId(String name) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product(int id,String name, String image, double price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
    }
}
