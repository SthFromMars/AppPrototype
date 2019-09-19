package com.example.prototype;

public class Product {
    String name;
    String image;
    double price;

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public double getPrice() {
        return price;
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

    public Product(String name, String image,double price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }
}
