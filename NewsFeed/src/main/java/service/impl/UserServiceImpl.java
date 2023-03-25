package service.impl;

import models.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    UserRepository userRepository = new UserRepositoryImpl();;

    @Override
    public UUID signup(String name) {
        return userRepository.signup(name);
    }

    @Override
    public String login(String name) {
        return checkIfUserExists(name);
    }

    @Override
    public String checkIfUserExists(String name) {
        return userRepository.login(name);
    }

    @Override
    public void follow(String name, String following) {
        checkIfUserExists(name);
        checkIfUserExists(following);
        System.out.println(name + " has started following " + following);
        userRepository.follow(name, following);
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.getUserByName(name);
    }
}
