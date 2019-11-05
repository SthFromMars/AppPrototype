package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class PurchaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(checkIfUserLoggedIn())
        {
            switchToPayment();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        Button purchaseNext = findViewById(R.id.PurchaseNext);
        purchaseNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if(gatherInfo()) switchToPayment();
            }
        });
    }
    void switchToPayment(){

        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
    }
    boolean gatherInfo(){
        String name = ((TextInputEditText) findViewById(R.id.PName)).getText().toString();
        String surname = ((TextInputEditText) findViewById(R.id.PSurname)).getText().toString();
        String phoneNr = ((TextInputEditText) findViewById(R.id.PPhoneNr)).getText().toString();
        String address = ((TextInputEditText) findViewById(R.id.PAddress)).getText().toString();
        String city = ((TextInputEditText) findViewById(R.id.PCity)).getText().toString();
        String postalCode = ((TextInputEditText) findViewById(R.id.PPostalCode)).getText().toString();
        String email = ((TextInputEditText) findViewById(R.id.PEmail)).getText().toString();
        if(name.equals("")) return false;
        if(surname.equals("")) return false;
        if(phoneNr.equals("")) return false;
        if(address.equals("")) return false;
        if(city.equals("")) return false;
        if(postalCode.equals("")) return false;
        if(email.equals("")) return false;
        Order order = new Order(
                name + " " +surname,
                 phoneNr,
                address + ", " + city + ", " + postalCode,
                 email,
                 Cart.getInstance(),
                 //Cart.getInstance().gifts,
                 //Cart.getInstance().decoration,
                 OrganizerManager.getInstance().getFreeOrganizer());
        OrderManager.getInstance().orders.add(order);
        return true;
    }
    boolean checkIfUserLoggedIn()
    {
        try {
            FileInputStream fileIn = new FileInputStream("/data/user/0/com.example.prototype/files/userinfo.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            UserInfo userinfo =(UserInfo)objectIn.readObject();
            fileIn.close();
            objectIn.close();
            if(userinfo.loggedIn == true)
            {
                Order order = new Order(
                        userinfo.name + " " +userinfo.surname,
                        userinfo.phoneNr,
                        userinfo.address + ", " + userinfo.city + ", " + userinfo.postCode,
                        userinfo.email,
                        Cart.getInstance(),
                        //Cart.getInstance().gifts,
                        //Cart.getInstance().decoration,
                        OrganizerManager.getInstance().getFreeOrganizer());
                OrderManager.getInstance().orders.add(order);
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
