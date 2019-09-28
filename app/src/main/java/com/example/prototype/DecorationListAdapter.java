package com.example.prototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
        EditText number;
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

        final ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.name = convertView.findViewById(R.id.name);
            holder.price = convertView.findViewById(R.id.price);
            holder.number = convertView.findViewById(R.id.number);
            holder.btnBuy = convertView.findViewById(R.id.btnBuy);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(product.getName());
        holder.price.setText("Kaina vienam: " + (product.getPrice()) + " Kiekis: ");

        holder.btnBuy.setTag(id);
        holder.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productSelected(id, holder.number.getText().toString());
            }
        });

        return convertView;
    }
    void productSelected(int id, String numberOfPeople){
        Cart cart = Cart.getInstance();
        cart.decoration= ProductManager.getInstance().decorations.get(id);
        if(numberOfPeople.equals("")) cart.decoration.numberOfpeople = 1;
        else cart.decoration.numberOfpeople = Integer.parseInt(numberOfPeople);
        parent.selected();
    }
}
