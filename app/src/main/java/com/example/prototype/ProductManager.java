package com.example.prototype;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductManager {
    private static ProductManager instance = new ProductManager();
    ArrayList<Gift> boyGifts;
    ArrayList<Gift> girlGifts;
    ArrayList<Decoration> decorations;
    int selectedGender=0;
    int selectedGift=0;

    public static ProductManager getInstance() {
        return instance;
    }


    private ProductManager() {
        this.update();
    }

    public void update(){
        this.decorations = getDecorationsFromDatabase();
        this.boyGifts = getBoyGiftsFromDatabase();
        this.girlGifts = getGirlGiftsFromDatabase();
    }
    public ArrayList<Gift> getGifts(){
        if (selectedGender == 0) return boyGifts;
        else return girlGifts;
    }
    public ArrayList<Decoration> getDecorations(){
        if(selectedGender == 0) return boyGifts.get(selectedGift).decorations;
        else return girlGifts.get(selectedGift).decorations;
    }
    private ArrayList<Gift> getBoyGiftsFromDatabase(){
        ArrayList<Gift> gifts = new ArrayList<>();
        Gift robot = new Gift(0,"Robotas", "1",10, new ArrayList<>(
                Arrays.asList(
                        decorations.get(0),
                        decorations.get(2),
                        decorations.get(3))));
        Gift plane = new Gift(1,"Lektuvas", "1",15,new ArrayList<>(
                Arrays.asList(
                        decorations.get(0),
                        decorations.get(1),
                        decorations.get(4))));
        Gift car = new Gift(2,"Masina", "1",10, new ArrayList<>(
                Arrays.asList(
                        decorations.get(1),
                        decorations.get(2),
                        decorations.get(5))));
        gifts.add(robot);
        gifts.add(plane);
        gifts.add(car);
        return gifts;
    }

    private ArrayList<Gift> getGirlGiftsFromDatabase(){
        ArrayList<Gift> gifts = new ArrayList<>();
        Gift doll = new Gift(0,"Lėlė", "1",15, new ArrayList<>(
                Arrays.asList(
                        decorations.get(6),
                        decorations.get(7))));
        Gift teddyBear = new Gift(1,"Pliusinis meskinas", "1",50, new ArrayList<>(
                Arrays.asList(
                        decorations.get(6),
                        decorations.get(8))));
        gifts.add(doll);
        gifts.add(teddyBear);
        return gifts;
    }

    private ArrayList<Decoration> getDecorationsFromDatabase(){
        ArrayList<Decoration> decorations = new ArrayList<>();
        Decoration robotPlane = new Decoration(0,"robotPlane", "1", 15.42);
        Decoration planeCar = new Decoration(1,"planeCar", "1", 15.42);
        Decoration robotCar = new Decoration(2,"robotCar", "1", 15.42);
        Decoration robot = new Decoration(3,"robot", "1", 15.42);
        Decoration plane = new Decoration(4,"plane", "1", 15.42);
        Decoration car = new Decoration(5,"car", "1", 15.42);
        Decoration dollTeddyBear = new Decoration(6,"dollTeddyBear", "1", 15.42);
        Decoration doll = new Decoration(7,"doll", "1", 15.42);
        Decoration teddyBear = new Decoration(8,"teddyBear", "1", 15.42);
        decorations.add(robotPlane);
        decorations.add(planeCar);
        decorations.add(robotCar);
        decorations.add(robot);
        decorations.add(plane);
        decorations.add(car);
        decorations.add(dollTeddyBear);
        decorations.add(doll);
        decorations.add(teddyBear);
        return decorations;
    }
}
