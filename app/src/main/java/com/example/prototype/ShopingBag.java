package com.example.prototype;

import java.util.ArrayList;

public class ShopingBag {
    public static ShopingBag instance = new ShopingBag();
    Gift gift = null;
    Product decoration = null;
    private ShopingBag(){}
    public static ShopingBag getInstance() {return instance;}
}
