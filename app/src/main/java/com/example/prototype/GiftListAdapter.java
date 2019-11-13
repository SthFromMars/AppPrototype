package com.example.prototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class GiftListAdapter extends ArrayAdapter<Gift> {

    private static final String TAG = "PersonListAdapter";

    private GiftActivity parent;
    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    private static class ViewHolder {
        TextView name;
        TextView price;
        Button btnBuy;
        ImageView image;
    }

    public GiftListAdapter(Context context, int resource, ArrayList<Gift> objects, GiftActivity parent) {
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
        String image = getItem(position).getImage();

        Product product = new Product(id, name, image ,price);

        final View result;

        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.imageView);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.price = (TextView) convertView.findViewById(R.id.price);
            holder.btnBuy = (Button) convertView.findViewById(R.id.btnBuy);

            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        if (product.image.equals("car"))holder.image.setImageResource(R.drawable.car);
        if (product.image.equals("plane")) holder.image.setImageResource(R.drawable.plane);
        if (product.image.equals("robot")) holder.image.setImageResource(R.drawable.robot);
        if (product.image.equals("doll")) holder.image.setImageResource(R.drawable.doll);
        if(product.image.equals("tedy")) holder.image.setImageResource(R.drawable.tedy);
        holder.name.setText(product.getName());
        holder.price.setText(String.valueOf(product.getPrice()));

        holder.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "paspaustas:  " + id + " id", Toast.LENGTH_SHORT).show();
                productSelected(id);
            }
        });

        return convertView;
    }
    void productSelected(int id){
        ArrayList<Gift> gifts = ProductManager.getInstance().getGifts();
        Gift selectedGift = null;
        for(Gift gift: gifts){
            if(gift.id == id) {
                selectedGift = gift;
                break;
            }
        }
        Cart.getInstance().gifts.add(selectedGift);
        ProductManager.getInstance().selectedGift=id;
        parent.selected();
    }
}