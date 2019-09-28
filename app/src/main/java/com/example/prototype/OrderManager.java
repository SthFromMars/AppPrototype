package com.example.prototype;

import java.util.ArrayList;

public class OrderManager {
    ArrayList<Order> orders = new ArrayList<>();
    private static OrderManager instance = new OrderManager();

    private OrderManager(){}
    public static OrderManager getInstance(){
        return instance;
    }
}
