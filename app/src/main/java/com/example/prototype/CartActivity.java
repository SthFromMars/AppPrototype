package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private static final String TAG = "CartActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        final Cart cart = Cart.getInstance();

        final Button chooseDecorations = findViewById(R.id.SBDecorations);
        chooseDecorations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToDecorations();
            }
        });
        Button buy = findViewById(R.id.SBBuy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchPurchase();
            }
        });
        final TextView fullPriceText = findViewById(R.id.SBFullPrice);
        Button addGift = findViewById(R.id.SBGift);
        addGift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToGifts();
            }
        });

        //deal with GiftList
        Log.d(TAG, "OncCreate");
        testList();

        //deal with decorations
        double fullPrice = cart.getFullPrice();
        Button removeDecoration;
        final LinearLayout decorationLayout = findViewById(R.id.DecorationLayout);
        if(cart.decoration == null){
            decorationLayout.setVisibility(View.INVISIBLE);
        }
        else{
            final EditText number = findViewById(R.id.SBDecorationNumber);
            number.setText(String.valueOf(cart.decoration.numberOfPeople));
            number.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(number.getText().toString().equals("")) return;
                cart.decoration.numberOfPeople = Integer.parseInt(number.getText().toString());
                double changedPrice = cart.getFullPrice();
                fullPriceText.setText("Viso: " +String.format("%1$,.2f", changedPrice) );
            }
            });
            TextView decorationName = findViewById(R.id.SBDecorationName);
            decorationName.setText(cart.decoration.name);
            TextView decorationPrice = findViewById(R.id.SBDecorationPrice);
            decorationPrice.setText("Kaina vienam: " + cart.decoration.getPrice() + " Kiekis: ");
            //fullPrice += cart.decoration.price*cart.decoration.numberOfPeople;
            removeDecoration = findViewById(R.id.SBRemoveDecoration);
            removeDecoration.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeDecoration(cart, decorationLayout, chooseDecorations);
                }
            });
        }
        fullPriceText.setText("Viso: " + String.format("%1$,.2f", fullPrice));

    }

    private void removeDecoration(Cart cart, LinearLayout decorationLayout, Button chooseDecorations) {
        cart.decoration = null;
        decorationLayout.setVisibility(View.INVISIBLE);
        chooseDecorations.setText("Pasirinkti dekoracijas");
        double changedPrice = Cart.getInstance().getFullPrice();
        ((TextView)findViewById(R.id.SBFullPrice)).setText("Viso: " +String.format("%1$,.2f", changedPrice) );
    }

    void switchToGifts(){
        Intent intent = new Intent(this, GenderActivity.class);
        startActivity(intent);
    }

    void switchToDecorations(){
        Intent intent = new Intent(this, DecorationActivity.class);
        startActivity(intent);
    }

    void switchPurchase(){
        if(Cart.getInstance().gifts.size()<1) return;
        Intent intent = new Intent(this, PurchaseActivity.class);
        startActivity(intent);
    }
    void testList(){
        ListView giftListView = (ListView) findViewById(R.id.SBGiftList);
        ArrayList<Gift> gifts = Cart.getInstance().gifts;

        GiftCartAdapter adapter = new GiftCartAdapter(this, R.layout.adapter_gift_cart_layout, gifts, this);
        giftListView.setAdapter(adapter);
    }
    void updateGifts(){
        ListView giftListView = (ListView) findViewById(R.id.SBGiftList);
        ArrayList<Gift> gifts = Cart.getInstance().gifts;

        GiftCartAdapter adapter = new GiftCartAdapter(this, R.layout.adapter_gift_cart_layout, gifts, this);
        giftListView.setAdapter(adapter);
        double changedPrice = Cart.getInstance().getFullPrice();
        ((TextView)findViewById(R.id.SBFullPrice)).setText("Viso: " +String.format("%1$,.2f", changedPrice) );
    }
}
