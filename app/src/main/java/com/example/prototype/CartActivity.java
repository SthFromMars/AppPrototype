package com.example.prototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        TextView name = (TextView) findViewById(R.id.cartItemName);
        TextView price = (TextView) findViewById(R.id.cartItemPrice);
        TextView wholePrice = (TextView) findViewById(R.id.wholePrice);

        price.setText(Double.toString(Cart.userCart.prices.get(0)));
        wholePrice.setText("Viso: " + Cart.userCart.prices.get(0));

        Button btnDeconation = (Button) findViewById(R.id.btnGoToDecorations);
        btnDeconation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSelectDecorations();
            }
        });
        Button btnBuy = (Button) findViewById(R.id.btnGoToBuy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBuy();
            }
        });
    }
    void goToBuy(){
        Intent intent = new Intent(this, PurchaseActivity.class);
        startActivity(intent);
    }
    void goToSelectDecorations(){
        Intent intent = new Intent(this, DecorationActivity.class);
        startActivity(intent);
    }
}
