package com.example.prototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class OrderListAdapter extends ArrayAdapter<Order> {

    private static final String TAG = "PersonListAdapter";

    private OrderListActivity parent;
    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    private static class ViewHolder {
        TextView name;
        TextView phoneNr;
        TextView address;
        TextView email;
        TextView gift;
        TextView decoration;
        TextView paymentType;
    }

    public OrderListAdapter(Context context, int resource, ArrayList<Order> objects, OrderListActivity parent) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        this.parent = parent;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String name = getItem(position).getName();
        String phoneNr = getItem(position).getPhoneNr();
        String address = getItem(position).getAddress();
        String email = getItem(position).getEmail();
        //Gift gift = getItem(position).getGift().get(0);
        //Decoration decoration = getItem(position).getDecoration();
        int paymentType = getItem(position).getPaymentType();
        Organizer organizer = getItem(position).getOrganizer();

        //ArrayList<Gift> gifts = getItem(position).gifts;
        //gifts.add(gift);
        ArrayList<Gift> gifts = getItem(position).cart.gifts;

        //Order order = new Order(name, phoneNr, address, email, gifts, decoration, organizer);
        Order order = new Order(name, phoneNr, address, email, Cart.getInstance(), organizer);
        order.paymentType = paymentType;

        final View result;

        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.OrderName);
            holder.phoneNr = (TextView) convertView.findViewById(R.id.OrderPhone);
            holder.address = (TextView) convertView.findViewById(R.id.OrderAddress);
            holder.email = (TextView) convertView.findViewById(R.id.OrderEmail);
            holder.gift = (TextView) convertView.findViewById(R.id.OrderGift);
            holder.decoration = (TextView) convertView.findViewById(R.id.OrderDecoration);
            holder.paymentType = (TextView) convertView.findViewById(R.id.OrderPayment);

            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        holder.name.setText("Vardas: " + order.name);
        holder.phoneNr.setText("Tel. nr.: " + order.phoneNr);
        holder.address.setText("Adresas: " + order.address);
        holder.email.setText("El. paštas: " + order.Email);
        String giftText = "";
        for (Gift tempGift: gifts) {
            if(!giftText.equals("")) giftText = giftText + ", ";
            giftText = giftText + tempGift.name;
        }
        holder.gift.setText("Dovanų pavadinimai: " + giftText);
        if (order.cart.decoration !=null )holder.decoration.setText("Dekoracijų temos pavadinimas: " + order.cart.decoration.name);
        if(paymentType == 1) holder.paymentType.setText("Mokėjimas grynais.");
        else holder.paymentType.setText("Mokėjimas pavedimu.");

        return convertView;
    }
}