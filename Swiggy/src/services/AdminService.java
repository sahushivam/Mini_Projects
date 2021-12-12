package services;

import model.Restaurant;
import model.User;

import java.util.UUID;

public interface AdminService {

    UUID addUser(String name);
    User removeUser(UUID id);
    UUID addRestaurant(String location, String name);
    Restaurant removeRestaurant(UUID id);
    void getAllUser();
    void getDetailsOfRestaurant(UUID restaurantId);
}
