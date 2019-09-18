package com.example.prototype;

import java.util.ArrayList;

public class ProductManagerSingleton {
    private static ProductManagerSingleton instance = new ProductManagerSingleton();
    ArrayList<Gift> gifts;
    ArrayList<Decoration> decorations;

    public static ProductManagerSingleton getInstance() {
        return instance;
    }

    public ArrayList<Gift> getGifts() {
        return gifts;
    }

    public ArrayList<Decoration> getDecorations() {
        return decorations;
    }

    private ProductManagerSingleton() {
        this.update();
    }

    public void update(){
        this.gifts = getGiftsFromDatabase();
        this.decorations = getDecorationsFromDatabase();

    }

    private ArrayList<Gift> getGiftsFromDatabase(){
        ArrayList<Gift> gifts = new ArrayList<>();
        Gift gift = new Gift("test1", 1.05);
        gifts.add(gift);
        return gifts;
    }

    private ArrayList<Decoration> getDecorationsFromDatabase(){
        ArrayList<Decoration> decorations = new ArrayList<>();
        Decoration decoration = new Decoration("test2", 15.42);
        decorations.add(decoration);
        return decorations;
    }
}
