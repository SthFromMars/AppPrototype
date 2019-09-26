package com.example.prototype;

import android.widget.ImageView;

import java.util.ArrayList;

public class Gift extends Product {
    ArrayList<Decoration> decorations;
    public Gift(int id,String name, String image, double price, ArrayList<Decoration> decorations) {
        super(id,name, image, price);
        this.decorations=decorations;
    }
}
