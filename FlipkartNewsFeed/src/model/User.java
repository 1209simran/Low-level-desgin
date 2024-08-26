package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private List<String> followers;
    private List<String> following;
    private boolean isActive;
    private LocalDateTime lastActiveAt;


    public User(String name) {
        this.name = name;
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDateTime getLastActiveAt() {
        return lastActiveAt;
    }

    public void setLastActiveAt(LocalDateTime lastActiveAt) {
        this.lastActiveAt = lastActiveAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFollowers() {
        return followers;
    }

    public void setFollowers(List<String> followers) {
        this.followers = followers;
    }

    public List<String> getFollowing() {
        return following;
    }

    public void setFollowing(List<String> following) {
        this.following = following;
    }

    public void addFollowers(String name) {
        this.followers.add(name);
    }

    public void addFollowing(String name) {
        this.following.add(name);
    }
}
