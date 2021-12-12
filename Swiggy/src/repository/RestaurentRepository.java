package repository;

import model.Restaurant;

import java.util.List;
import java.util.UUID;

public interface RestaurentRepository {

    void addRestaurant(Restaurant r);

    Restaurant getRestaurant(UUID id);

    List<Restaurant> getAllRestaurant();

    Restaurant removeRestaurant(UUID id);
}
