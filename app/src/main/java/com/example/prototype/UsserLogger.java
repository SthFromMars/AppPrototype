package com.example.prototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class UsserLogger extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logger);
        try {
            FileInputStream fileIn = new FileInputStream("/data/user/0/com.example.prototype/files/userinfo.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            UserInfo userinfo =(UserInfo)objectIn.readObject();
            fileIn.close();
            objectIn.close();
            userinfo.loggedIn = false;
            userinfo.WriteToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Button btnLogin = (Button) findViewById(R.id.login_button);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToClass(LoginUser.class);
            }
        });
        Button btnNoLogin = (Button) findViewById(R.id.continue_button);
        btnNoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToClass(GenderActivity.class);
            }
        });
        Button btnRegister = (Button) findViewById(R.id.register_button);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                    sendToClass(user_register.class);
                }
        });
    }

    private void sendToClass(Class whereTo){
        Intent intent = new Intent(this, whereTo);
        startActivity(intent);
    }
}
