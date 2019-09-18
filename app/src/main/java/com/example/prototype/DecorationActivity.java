package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DecorationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoration);

        Button button4 = (Button) findViewById(R.id.button4);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDecoration();
            }
        };
        button4.setOnClickListener(onClickListener);
    }
    void selectDecoration(){
        Intent intent = new Intent(this, PurchaseActivity.class);
        startActivity(intent);
    }
}
