package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        setContentView(R.layout.gift_type_select);
        giftContext = this;

        Button btnBoySelect = (Button) findViewById(R.id.boySelect);
        btnBoySelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAvailableGifts();
            }
        });
        Button btnGirlSelect = (Button) findViewById(R.id.girlSelect);
        btnGirlSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAvailableGifts();
            }
        });
    }
    private void showAvailableGifts(){
        setContentView(R.layout.gift_grid_layout);
        Log.d(TAG, "OncCreate");
        testList();
    }
    public static void goToCart(){
        Intent intent = new Intent(giftContext, CartActivity.class);
        giftContext.startActivity(intent);
    }
    void testList(){
        giftListView = (ListView) findViewById(R.id.listView);
        Gift robot = new Gift(1,"Robotas", "1",10);
        Gift doll = new Gift(2,"Lėlė", "1",15);
        Gift lektuvas = new Gift(3,"Lektuvas", "1",15);
        Gift masina = new Gift(4,"Masina", "1",10);
        Gift meskinas = new Gift(5,"Pliusinis meskinas", "1",50);

        ArrayList<Product> giftList = new ArrayList<>();
        giftList.add(robot);
        giftList.add(doll);
        giftList.add(lektuvas);
        giftList.add(masina);
        giftList.add(meskinas);

        adapter = new ProductListAdapter(this, R.layout.adapter_gift_layout, giftList);
        giftListView.setAdapter(adapter);
    }
}
