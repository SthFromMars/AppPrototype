package com.example.prototype;

import java.util.ArrayList;

public class Organizer {
    String username;
    String password;
    ArrayList<Message> messageList = new ArrayList<Message>();

    public Organizer(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void addMessage(Message message){
        this.messageList.add(message);
    }
    public ArrayList<Message> getMessageList(){
        return this.messageList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organizer organizer = (Organizer) o;
        return username.equals(organizer.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
