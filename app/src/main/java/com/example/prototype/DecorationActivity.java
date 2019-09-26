package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class DecorationActivity extends AppCompatActivity {

    private static final String TAG = "DecorationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decoration_grid_layout);
        Log.d(TAG, "OncCreate");
        testList();
    }
    void testList(){
        ListView decorationListView = (ListView) findViewById(R.id.DecorationListView);
        ArrayList<Decoration> gifts = ProductManagerSingleton.getInstance().getDecorations();

        DecorationListAdapter adapter = new DecorationListAdapter(this, R.layout.adapter_gift_layout, gifts, this);
        decorationListView.setAdapter(adapter);
    }
    void selected(){
        Intent intent = new Intent(this, ShoppingBagActivity.class);
        startActivity(intent);

    }
}
