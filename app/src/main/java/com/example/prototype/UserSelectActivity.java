package com.example.prototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UserSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);
        Button btnClientLogin = (Button) findViewById(R.id.clientLogin);
        btnClientLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToClass(UsserLogger.class);
            }
        });
        Button btnWorkerLogin = (Button) findViewById(R.id.workerLogin);
        btnWorkerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToClass(LogInActivity.class);
            }
        });
    }

    private void sendToClass(Class whereTo){
        Intent intent = new Intent(this, whereTo);
        startActivity(intent);
    }
}
