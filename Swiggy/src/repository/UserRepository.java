package repository;

import model.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository {

    void addUser(User user);
    User removeUser(UUID uuid);
    User getUser(UUID id);
    List<User> getAllUser();
}
