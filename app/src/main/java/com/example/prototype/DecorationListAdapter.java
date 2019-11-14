package com.example.prototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
        ImageView image;
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
        String image = getItem(position).getImage();
        final Product product = new Product(id, name,image,price);

        final ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.imageView);
            holder.name = convertView.findViewById(R.id.name);
            holder.price = convertView.findViewById(R.id.price);
            holder.number = convertView.findViewById(R.id.number);
            holder.btnBuy = convertView.findViewById(R.id.btnBuy);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        if (product.image.equals("robotPlane"))holder.image.setImageResource(R.drawable.robotplane);
        if (product.image.equals("planeCar")) holder.image.setImageResource(R.drawable.planecar);
        if (product.image.equals("robotCar")) holder.image.setImageResource(R.drawable.robotcar);
        if (product.image.equals("robots")) holder.image.setImageResource(R.drawable.robots);
        if(product.image.equals("planes")) holder.image.setImageResource(R.drawable.planes);
        if(product.image.equals("cars")) holder.image.setImageResource(R.drawable.cars);

        if (product.image.equals("dollTeddyBear")) holder.image.setImageResource(R.drawable.dollteddybear);
        if (product.image.equals("dolls")) holder.image.setImageResource(R.drawable.dolls);
        if(product.image.equals("teddyBears")) holder.image.setImageResource(R.drawable.teddybears);


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
        if(numberOfPeople.equals("")) cart.decoration.numberOfPeople = 1;
        else cart.decoration.numberOfPeople = Integer.parseInt(numberOfPeople);
        parent.selected();
    }
}
