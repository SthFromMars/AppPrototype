package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_grid_layout);

        Intent intent = getIntent();
        int state = intent.getIntExtra("state", 0);
        testList(state);
    }
    void testList(int state){
        ListView orderListView = findViewById(R.id.listView);
        ArrayList<Order> orders = OrderManager.getInstance().getSpecificOrders(OrganizerManager.getInstance().signedIn, state);

        OrderListAdapter adapter = new OrderListAdapter(this, R.layout.adapter_order_layout, orders, this);
        orderListView.setAdapter(adapter);
    }
}
