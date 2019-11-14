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
        this.decorations = generateDecorations();
        this.boyGifts = generateBoyGifts();
        this.girlGifts = generateGirlGifts();
    }
    public ArrayList<Gift> getGifts(){
        if (selectedGender == 0) return boyGifts;
        else return girlGifts;
    }
    public ArrayList<Decoration> getDecorations(){
        if(selectedGender == 0) return boyGifts.get(selectedGift).decorations;
        else return girlGifts.get(selectedGift).decorations;
    }
    private ArrayList<Gift> generateBoyGifts(){
        ArrayList<Gift> gifts = new ArrayList<>();
        Gift robot = new Gift(0,"Robotas", "robot",10, new ArrayList<>(
                Arrays.asList(
                        decorations.get(0),
                        decorations.get(2),
                        decorations.get(3))));
        Gift plane = new Gift(1,"Lektuvas", "plane",15,new ArrayList<>(
                Arrays.asList(
                        decorations.get(0),
                        decorations.get(1),
                        decorations.get(4))));
        Gift car = new Gift(2,"Masina", "car",10, new ArrayList<>(
                Arrays.asList(
                        decorations.get(1),
                        decorations.get(2),
                        decorations.get(5))));
        gifts.add(robot);
        gifts.add(plane);
        gifts.add(car);
        return gifts;
    }

    private ArrayList<Gift> generateGirlGifts(){
        ArrayList<Gift> gifts = new ArrayList<>();
        Gift doll = new Gift(0,"Lėlė", "doll",15, new ArrayList<>(
                Arrays.asList(
                        decorations.get(6),
                        decorations.get(7))));
        Gift teddyBear = new Gift(1,"Pliusinis meskinas", "tedy",50, new ArrayList<>(
                Arrays.asList(
                        decorations.get(6),
                        decorations.get(8))));
        gifts.add(doll);
        gifts.add(teddyBear);
        return gifts;
    }

    private ArrayList<Decoration> generateDecorations(){
        ArrayList<Decoration> decorations = new ArrayList<>();
        Decoration robotPlane = new Decoration(0,"robotPlane", "robotPlane", 15.42);
        Decoration planeCar = new Decoration(1,"planeCar", "planeCar", 15.42);
        Decoration robotCar = new Decoration(2,"robotCar", "robotCar", 15.42);
        Decoration robot = new Decoration(3,"robot", "robots", 15.42);
        Decoration plane = new Decoration(4,"plane", "planes", 15.42);
        Decoration car = new Decoration(5,"car", "cars", 15.42);
        Decoration dollTeddyBear = new Decoration(6,"dollTeddyBear", "dollTeddyBear", 15.42);
        Decoration doll = new Decoration(7,"doll", "dolls", 15.42);
        Decoration teddyBear = new Decoration(8,"teddyBears", "teddyBears", 15.42);
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
