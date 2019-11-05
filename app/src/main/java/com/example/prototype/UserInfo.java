package com.example.prototype;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class UserInfo implements java.io.Serializable{
    String name;
    String surname;
    String phoneNr;
    String address;
    String city;
    String postCode;
    String email;
    String password;
    boolean loggedIn;
    public UserInfo(String name, String surname, String phoneNr, String address, String city, String postCode, String email, String password){
        this.name = name;
        this.phoneNr = phoneNr;
        this.address = address;
        this.email = email;
        this.surname = surname;
        this.city  = city;
        this.postCode = postCode;
        this.password = password;
        this.loggedIn = false;
    }
    void WriteToFile(){
        try {
            FileOutputStream fileOut = new FileOutputStream( "/data/user/0/com.example.prototype/files/userinfo.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.close();
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
