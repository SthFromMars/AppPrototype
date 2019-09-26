package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Button order = findViewById(R.id.Order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToOrder();
            }
        });

    }
    void switchToOrder(){
        Intent intent = new Intent(this, ThankSplashActivity.class);
        startActivity(intent);
    }
}
