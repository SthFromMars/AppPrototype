package com.example.prototype;

import java.util.ArrayList;

public class OrganizerManager {
    private static OrganizerManager instance = new OrganizerManager();

    ArrayList<Organizer> organizers = new ArrayList<>();
    Organizer signedIn = null;

    private OrganizerManager(){
        update();
    }
    public static OrganizerManager getInstance(){
        return instance;
    }

    void update(){
        Organizer organizer = new Organizer("test", "test");
        organizers.add(organizer);
    }
    Organizer getFreeOrganizer(){
        return organizers.get(0);
    }
    Organizer logIn(String username, String password){
        for(Organizer organizer:organizers){
            if (organizer.username.equals(username) && organizer.password.equals(password)) return organizer;
        }
        return null;
    }
}
