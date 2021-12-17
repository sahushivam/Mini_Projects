package model;

import java.util.UUID;

public class User {

    private String name;
    private UUID id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    public User() {
        this.id = UUID.randomUUID();
    }
}
