package services;

import model.FoodItem;
import model.Restaurant;
import model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User getUser(UUID id);
    UUID orderFood(UUID userId, UUID restaurantId, List<String> foodItemList);
    List<Restaurant> showRestaurants(String location);

}
