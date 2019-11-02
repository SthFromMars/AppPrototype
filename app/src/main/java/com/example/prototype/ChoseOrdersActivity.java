package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoseOrdersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_orders);

        Button state0 = findViewById(R.id.State0);
        state0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToOrderList(0);
            }
        });
        Button state1 = findViewById(R.id.State1);
        state1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToOrderList(1);
            }
        });
        Button state2 = findViewById(R.id.State2);
        state2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToOrderList(2);
            }
        });
        Button toMessage = findViewById(R.id.Messages);
        toMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToMessages();
            }
        });
    }
    void switchToOrderList(int state){
        Intent intent = new Intent(this, OrderListActivity.class);
        intent.putExtra("state", state);
        startActivity(intent);
    }
    void switchToMessages(){
        Intent intent = new Intent(this, MessageListActivity.class);
        startActivity(intent);
    }
}
