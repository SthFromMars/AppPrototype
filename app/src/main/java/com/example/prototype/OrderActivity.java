package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        TextView price = findViewById(R.id.OrderPrice);
        price.setText("Kaina: " + String.valueOf(ShopingBag.getInstance().decoration.price + ShopingBag.getInstance().gift.price));
        final TextView status = findViewById(R.id.OrderStatus);
        status.setText("Užsakymo būsena: Laukiama apmokėjimo");
        /*new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                status.setText("Užsakymo būsena: Siunčiamas");
            }
        }, 2000);
        try {
            Thread.sleep(2000);
            status.setText("Užsakymo būsena: Ruošiamas");
            Thread.sleep(2000);
        }catch (InterruptedException e){}
        status.setText("Užsakymo būsena: Siunčiamas");*/
        /*status.postDelayed(new Runnable() {
            @Override
            public void run() {
                status.setText("Užsakymo būsena: Ruošiamas");
            }
        }, 5000);*/
    }
}
