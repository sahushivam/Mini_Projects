package repository.impl;

import exception.RestaurentNotFound;
import model.Restaurant;
import repository.RestaurentRepository;

import java.util.*;

public class InMemoryRestaurantRepositoryImpl implements RestaurentRepository {

    public static HashMap<UUID, Restaurant> restaurantHashMap = new HashMap<>();

    @Override
    public void addRestaurant(Restaurant r) {
        restaurantHashMap.put(r.getId(), r);
    }

    @Override
    public Restaurant getRestaurant(UUID id) {
        if(restaurantHashMap.containsKey(id)) {
            return restaurantHashMap.get(id);
        }
        throw new RestaurentNotFound();
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        Collection<Restaurant> values = restaurantHashMap.values();
        return new ArrayList<>(values);
    }

    @Override
    public Restaurant removeRestaurant(UUID id) {
        if(restaurantHashMap.containsKey(id)) {
            return restaurantHashMap.remove(id);
        }
        throw new RestaurentNotFound();
    }
}
