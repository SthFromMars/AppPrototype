package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        TextView price = findViewById(R.id.OrderPrice);
        double priceDouble = Cart.getInstance().gift.price;
        if(Cart.getInstance().decoration != null) priceDouble+= Cart.getInstance().decoration.price * Cart.getInstance().decoration.numberOfpeople;
        price.setText("Kaina: " + priceDouble);
        TextView status = findViewById(R.id.OrderStatus);
        status.setText("Užsakymo būsena: Laukiama apmokėjimo");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TextView status = findViewById(R.id.OrderStatus);
                status.setText("Užsakymo būsena: Ruošiamas");
                OrderManager.getInstance().orders.get(OrderManager.getInstance().orders.size()-1).status++;
            }
        }, 3000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TextView status = findViewById(R.id.OrderStatus);
                status.setText("Užsakymo būsena: Siunčiamas");
                OrderManager.getInstance().orders.get(OrderManager.getInstance().orders.size()-1).status++;
            }
        }, 8000);
    }
}
