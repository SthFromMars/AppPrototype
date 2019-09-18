package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GiftActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gift_type_select);


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
        setContentView(R.layout.activity_gift);
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTheme();
            }
        });
    }
    void selectTheme(){
        Intent intent = new Intent(this, ThemeActivity.class);
        startActivity(intent);
    }
}
