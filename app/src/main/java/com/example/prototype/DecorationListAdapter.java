package com.example.prototype;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class DecorationListAdapter extends ArrayAdapter<Decoration> {

    private static final String TAG = "PersonListAdapterTAG";

    private DecorationActivity parent;
    private Context mContext;
    private int mResource;

    private static class ViewHolder {
        TextView name;
        TextView price;
        Button btnBuy;
    }

    public DecorationListAdapter(Context context, int resource, ArrayList<Decoration> objects, DecorationActivity parent) {
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

        final Product product = new Product(id, name,"1",price);

        final View result;

        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
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

        holder.name.setText(product.getName());
        holder.price.setText(String.valueOf(product.getPrice()));

        holder.btnBuy.setTag(id);
        final int tmpId = product.getId();
        final String tmpName = product.getName();
        final double tmpPrice = product.getPrice();
        holder.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productSelected(id);
            }
        });

        return convertView;
    }
    void productSelected(int id){
        ShopingBag.getInstance().decoration=ProductManagerSingleton.getInstance().decorations.get(id);
        parent.selected();
    }
}
