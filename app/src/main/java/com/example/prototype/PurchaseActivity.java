package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PurchaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        Button purchaseNext = findViewById(R.id.PurchaseNext);
        purchaseNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToPayment();
            }
        });
    }
    void switchToPayment(){
        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
    }
}
