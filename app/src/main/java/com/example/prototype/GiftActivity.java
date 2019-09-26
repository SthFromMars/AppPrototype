package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class GiftActivity extends AppCompatActivity {

    private static final String TAG = "GiftActivity";
    private ListView giftListView;
    private ProductListAdapter adapter;
    private static Context giftContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gift_grid_layout);
        Log.d(TAG, "OncCreate");
        testList();
    }
    void testList(){
        ListView giftListView = (ListView) findViewById(R.id.listView);
        ArrayList<Gift> gifts = ProductManagerSingleton.getInstance().getGifts();

        GiftListAdapter adapter = new GiftListAdapter(this, R.layout.adapter_gift_layout, gifts, this);
        giftListView.setAdapter(adapter);
    }
    void selected(){
        Intent intent = new Intent(this, ShoppingBagActivity.class);
        startActivity(intent);

    }
}
