package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        final Cart cart = Cart.getInstance();

        TextView giftName = findViewById(R.id.SBGiftName);
        TextView giftPrice = findViewById(R.id.SBGiftPrice);
        giftName.setText(cart.gift.name);
        giftPrice.setText(String.valueOf(cart.gift.price));

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
        final TextView fullPriceText = findViewById(R.id.SBFullPrice);
        double fullPrice = cart.gift.price;
        if(cart.decoration == null){
            LinearLayout decorationLayout = findViewById(R.id.DecorationLayout);
            decorationLayout.setVisibility(View.INVISIBLE);
        }
        else{
            final EditText number = findViewById(R.id.SBDecorationNumber);
            number.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(number.getText().toString().equals("")) return;
                cart.decoration.numberOfpeople = Integer.parseInt(number.getText().toString());
                double changedPrice = cart.gift.price + (cart.decoration.price * cart.decoration.numberOfpeople);
                fullPriceText.setText("Viso: " +String.format("%1$,.2f", changedPrice) );
            }
            });
            TextView decorationName = findViewById(R.id.SBDecorationName);
            decorationName.setText(cart.decoration.name);
            TextView decorationPrice = findViewById(R.id.SBDecorationPrice);
            decorationPrice.setText("Kaina vienam: " + cart.decoration.getPrice() + " Kiekis: ");
            chooseDecorations.setVisibility(View.INVISIBLE);
            fullPrice += cart.decoration.price*cart.decoration.numberOfpeople;
        }
        fullPriceText.setText("Viso: " + String.format("%1$,.2f", fullPrice));

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
