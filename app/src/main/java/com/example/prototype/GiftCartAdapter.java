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

public class GiftCartAdapter extends ArrayAdapter<Gift> {

    private static final String TAG = "PersonListAdapter";

    private CartActivity parent;
    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    private static class ViewHolder {
        TextView name;
        TextView price;
        Button remove;
    }

    public GiftCartAdapter(Context context, int resource, ArrayList<Gift> objects, CartActivity parent) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        this.parent = parent;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int id = getItem(position).getId();
        String name = getItem(position).getName();
        double price = getItem(position).getPrice();

        Product product = new Product(id, name,"1",price);

        final View result;

        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.price = (TextView) convertView.findViewById(R.id.price);
            holder.remove = (Button) convertView.findViewById(R.id.remove);

            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        holder.name.setText(product.getName());
        holder.price.setText(String.valueOf(product.getPrice()));

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "paspaustas:  " + id + " id", Toast.LENGTH_SHORT).show();
                productSelected(id);
            }
        });

        return convertView;
    }
    void productSelected(int id){
        ArrayList<Gift> gifts = Cart.getInstance().gifts;
        for(Gift gift: gifts){
            if(gift.id == id) {
                gifts.remove(gift);
                break;
            }
        }
        //.add(ProductManager.getInstance().getGifts().get(id));
        //ProductManager.getInstance().selectedGift=id;
        parent.updateGifts();
    }
}