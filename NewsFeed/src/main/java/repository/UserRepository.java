package repository;

import models.User;

import java.util.UUID;

public interface UserRepository {

    UUID signup(String name);
    String login(String name);
    void follow(String name, String following);
    User getUserByName(String name);
}
