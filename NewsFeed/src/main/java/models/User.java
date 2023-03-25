package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {

    private UUID userID;
    private String name;
    private List<UUID> followersId;
    private List<UUID> followingId;

    public User(String name) {
        setUserID();
       setName(name);
       followingId = new ArrayList<>();
       followersId = new ArrayList<>();
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID() {
        this.userID = UUID.randomUUID();
    }

    public List<UUID> getFollowersId() {
        return followersId;
    }

    public void setFollowersId(List<UUID> followersId) {
        this.followersId = followersId;
    }

    public List<UUID> getFollowingId() {
        return followingId;
    }

    public void setFollowingId(List<UUID> followingId) {
        this.followingId = followingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
