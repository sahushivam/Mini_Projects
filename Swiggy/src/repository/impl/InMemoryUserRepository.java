package repository.impl;

import exception.UserNotFoundException;
import model.User;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class InMemoryUserRepository implements UserRepository {

    public static HashMap<UUID, User> userHashMap = new HashMap<>();

    @Override
    public void addUser(User user) {
        userHashMap.put(user.getId(),user);
    }

    @Override
    public User removeUser(UUID uuid) {
        User user = getUser(uuid);
        userHashMap.remove(uuid);
        return user;
    }

    @Override
    public User getUser(UUID id) {
        if(userHashMap.containsKey(id)) {
            return userHashMap.get(id);
        }
        throw new UserNotFoundException();
    }

    @Override
    public List<User> getAllUser() {
        return new ArrayList<>(userHashMap.values());
    }

}
