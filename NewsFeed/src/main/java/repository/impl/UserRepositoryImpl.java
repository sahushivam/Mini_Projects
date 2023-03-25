package repository.impl;

import exception.UserNotFoundException;
import models.User;
import repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {

    private static HashMap<String, User>  userRepo = new HashMap<>();;


    @Override
    public UUID signup(String name) {
        User user = new User(name);
        userRepo.put(user.getName(), user);
        return user.getUserID();
    }

    @Override
    public String login(String name) {
        if(userRepo.containsKey(name)){return userRepo.get(name).getName();}
        else
            throw new UserNotFoundException();
    }

    @Override
    public void follow(String name, String followingName) {
        if(userRepo.containsKey(name) && userRepo.containsKey(followingName))
        {
            User userFollower = userRepo.get(name);
            User userFollowing = userRepo.get(followingName);

            //getting userFollower
            List<UUID> followingId = userFollowing.getFollowingId();

            followingId.add(userFollower.getUserID());
            //setting
            userFollowing.setFollowingId(followingId);

            //

            //getting userFollower
            List<UUID> followerIds = userFollower.getFollowersId();

            followerIds.add(userFollowing.getUserID());
            //setting
            userFollower.setFollowersId(followerIds);
        }
        else
            throw new UserNotFoundException();
    }

    @Override
    public User getUserByName(String name) {
        return userRepo.get(name);
    }
}
