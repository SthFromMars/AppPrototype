package com.example.prototype;

public class Organizer {
    String username;
    String password;

    public Organizer(String username, String password) {
        this.username = username;
        this.password = password;
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
