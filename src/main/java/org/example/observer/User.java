package org.example.observer;

public class User implements Observer {
    private final String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + username + ": " + message);
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public String toString() {
        return this.username;
    }
}
