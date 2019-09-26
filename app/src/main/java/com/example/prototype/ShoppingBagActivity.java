package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShoppingBagActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_bag);
        ShopingBag shopingBag = ShopingBag.getInstance();

        TextView giftName = findViewById(R.id.SBGiftName);
        TextView giftPrice = findViewById(R.id.SBGiftPrice);
        giftName.setText(shopingBag.gift.name);
        giftPrice.setText(String.valueOf(shopingBag.gift.price));

        Button chooseDecorations = findViewById(R.id.SBDecorations);
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
        TextView fullPriceText = findViewById(R.id.SBFullPrice);
        double fullprice = shopingBag.gift.price;
        if(shopingBag.decoration == null){
            LinearLayout decorationLayout = findViewById(R.id.DecorationLayout);
            decorationLayout.setVisibility(View.INVISIBLE);
        }
        else{
            TextView decorationName = findViewById(R.id.SBDecorationName);
            decorationName.setText(shopingBag.decoration.name);
            TextView decorationPrice = findViewById(R.id.SBDecorationPrice);
            decorationPrice.setText(String.valueOf(shopingBag.decoration.price));
            chooseDecorations.setVisibility(View.INVISIBLE);
            fullprice += shopingBag.decoration.price;
        }
        fullPriceText.setText("Viso: " + String.valueOf(fullprice));

    }

    void switchToDecorations(){
        Intent intent = new Intent(this, DecorationActivity.class);
        startActivity(intent);
    }

    void switchPurchase(){
        Intent intent = new Intent(this, PurchaseActivity.class);
        startActivity(intent);
    }
}
