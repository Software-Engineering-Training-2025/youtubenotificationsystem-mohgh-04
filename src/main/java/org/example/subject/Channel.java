package org.example.subject;

import org.example.observer.Observer;
import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {
    private final String name;
    private final List<Observer> subscribers = new ArrayList<>();

    public Channel(String name) {
        this.name = name;
    }

    public void uploadVideo(String title) {
        if (title == null || title.isBlank()) {
            return;
        }
        String message = this.name + " uploaded a new video: " + title;
        this.notifyObservers(message);
    }

    @Override
    public void subscribe(Observer observer) {
        if (observer != null && !this.subscribers.contains(observer)) {
            this.subscribers.add(observer);
        }
        subscribers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        if (observer != null) {
            this.subscribers.remove(observer);
        }
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for(Observer subscriber : this.subscribers) {
            subscriber.update(message);
        }
    }

    public String getName() {
        return this.name;
    }
}
