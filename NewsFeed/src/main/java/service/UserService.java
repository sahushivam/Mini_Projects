package service;

import models.User;

import java.util.UUID;

public interface UserService {

    UUID signup(String name);
    String login(String name);

    String checkIfUserExists(String name);
    void follow(String name, String following);

    User getUserByName(String name);
}
