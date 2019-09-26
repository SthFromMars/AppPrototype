package com.example.prototype;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Cart {
        public static Cart userCart = new Cart();

        List<Integer> ids;
        List<String> names;
        List<Double> prices;
        int size = 0;

        public Cart(){
            this.ids = new ArrayList<>();
            this.names = new ArrayList<>();
            this.prices = new ArrayList<>();
        }
        public Cart(List ids, List name, List price) {
            this.ids = ids;
            this.names = name;
            this.prices = price;
        }

        public void addToUserCart(int id, String name, double price){
            userCart.ids.add(id);
            userCart.names.add(name);
            userCart.prices.add(price);
            userCart.size++;
        }
}
