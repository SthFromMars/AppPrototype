package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Button order = findViewById(R.id.Order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkIfSelected()) switchToOrder();
            }
        });

    }
    void switchToOrder(){
        Intent intent = new Intent(this, ThankSplashActivity.class);
        startActivity(intent);
    }
    boolean checkIfSelected(){
        RadioButton cash = findViewById(R.id.Cash);
        RadioButton bank = findViewById(R.id.BankPayment);
        if(!cash.isChecked() && !bank.isChecked()) return false;
        else if(cash.isChecked()) OrderManager.getInstance().orders.get(OrderManager.getInstance().orders.size()-1).paymentType = 1;
        else if(bank.isChecked()) OrderManager.getInstance().orders.get(OrderManager.getInstance().orders.size()-1).paymentType = 2;
        return true;
    }
}
