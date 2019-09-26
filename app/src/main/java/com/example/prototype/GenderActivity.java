package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        Button boySelect = findViewById(R.id.boySelect);
        boySelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectBoy();
            }
        });
        Button girlSelect = findViewById(R.id.girlSelect);
        girlSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectGirl();
            }
        });
    }
    void selectBoy(){
        ProductManagerSingleton.getInstance().selectedGender=0;
        Intent intent = new Intent(this, GiftActivity.class);
        startActivity(intent);
    }
    void selectGirl(){
        ProductManagerSingleton.getInstance().selectedGender=1;
        Intent intent = new Intent(this, GiftActivity.class);
        startActivity(intent);
    }
}
