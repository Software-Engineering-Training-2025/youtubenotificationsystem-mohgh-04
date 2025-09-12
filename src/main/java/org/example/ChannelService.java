package org.example;

import org.example.observer.Observer;
import org.example.subject.Channel;

import java.util.*;

public class ChannelService {
    private final Map<String, Channel> channels = new HashMap<>();

    public boolean createChannel(String name) {
        if (name == null || name.isBlank() || this.channels.containsKey(name)) {
            return false;
        }
        this.channels.put(name, new Channel(name));
        return true;
    }

    public boolean deleteChannel(String name) {
        if (name == null || !channels.containsKey(name)) {
            return false;
        }
        this.channels.remove(name);
        return true;
    }

    public Optional<Channel> getChannel(String name) {
        if (name == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(channels.get(name));
    }

    public boolean subscribe(String channelName, Observer user) {
        if (channelName == null || user == null) {
            return false;
        }
        Channel channel = channels.get(channelName);
        if (channel == null) {
            return false;
        }
        channel.subscribe(user);
        return true;
    }

    public boolean unsubscribe(String channelName, Observer user) {
        if (channelName == null || user == null) {
            return false;
        }
        Channel channel = this.channels.get(channelName);
        if (channel == null) {
            return false;
        }
        channel.unsubscribe(user);
        return true;
    }

    public boolean upload(String channelName, String videoTitle) {
        if (channelName == null || videoTitle == null) {
            return false;
        }
        Channel channel = this.channels.get(channelName);
        if (channel == null) {
            return false;
        }
        channel.uploadVideo(videoTitle);
        return true;
    }

    public Set<String> listChannels() {
        return new HashSet<>(this.channels.keySet());
    }
}
