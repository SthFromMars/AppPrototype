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
        setContentView(R.layout.activity_gift);

        Button button6 = (Button) findViewById(R.id.button6);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectGift();
            }
        };
        button6.setOnClickListener(onClickListener);
    }
    void selectGift(){
        Intent intent = new Intent(this, DecorationActivity.class);
        startActivity(intent);
    }
}
