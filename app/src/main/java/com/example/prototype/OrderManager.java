package com.example.prototype;

import java.util.ArrayList;

public class OrderManager {
    ArrayList<Order> orders = new ArrayList<>();
    private static OrderManager instance = new OrderManager();

    private OrderManager(){
        update();
    }
    public static OrderManager getInstance(){
        return instance;
    }
    void update(){
        ArrayList<Gift> gifts = new ArrayList<>();
        gifts.add(ProductManager.getInstance().boyGifts.get(0));
        orders.add(new Order("test1", "1", "test1", "test1", gifts, ProductManager.getInstance().decorations.get(0), OrganizerManager.getInstance().getFreeOrganizer()));
        orders.add(new Order("test2", "2", "test2", "test2", gifts, ProductManager.getInstance().decorations.get(0), OrganizerManager.getInstance().getFreeOrganizer()));
        orders.add(new Order("test3", "3", "test3", "test3", gifts, null, OrganizerManager.getInstance().getFreeOrganizer()));
        orders.add(new Order("test4", "4", "test4", "test4", gifts, ProductManager.getInstance().decorations.get(0), OrganizerManager.getInstance().getFreeOrganizer()));
        orders.add(new Order("test5", "5", "test5", "test5", gifts, null, OrganizerManager.getInstance().getFreeOrganizer()));

        orders.get(0).status=0;
        orders.get(1).status=1;
        orders.get(2).status=1;
        orders.get(3).status=2;
        orders.get(4).status=2;

        orders.get(0).paymentType=1;
        orders.get(1).paymentType=1;
        orders.get(2).paymentType=2;
        orders.get(3).paymentType=1;
        orders.get(4).paymentType=2;

    }
    ArrayList<Order> getSpecificOrders(Organizer organizer, int state){
        ArrayList<Order> ordersNew = new ArrayList<>();
        for(Order order: orders){
            if(order.organizer.equals(organizer) && order.status == state) ordersNew.add(order);
        }
        return ordersNew;
    }
}
