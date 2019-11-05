package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LoginUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        Button button = (Button) findViewById(R.id.logInButton);
        final EditText email = findViewById(R.id.email);
        final EditText password = findViewById(R.id.Password);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userSender(email.getText().toString(),password.getText().toString())){
                    sendToClass(GenderActivity.class);
                }
            }
        });
    }
    private void sendToClass(Class whereTo){
        Intent intent = new Intent(this, whereTo);
        startActivity(intent);
    }
    boolean userSender(String email,String password ){
        try {
            FileInputStream fileIn = new FileInputStream("/data/user/0/com.example.prototype/files/userinfo.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            UserInfo userinfo =(UserInfo)objectIn.readObject();
            fileIn.close();
            objectIn.close();
            if(userinfo.password.equals(password)&& userinfo.email.equals(email)){
                userinfo.loggedIn = true;
                userinfo.WriteToFile();
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
