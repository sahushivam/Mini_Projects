package services.impl;

import model.Restaurant;
import model.User;
import repository.RestaurentRepository;
import repository.UserRepository;
import repository.impl.InMemoryRestaurantRepositoryImpl;
import repository.impl.InMemoryUserRepository;
import services.AdminService;

import java.util.List;
import java.util.UUID;

public class AdminServiceImpl implements AdminService {

    UserRepository userRepository = new InMemoryUserRepository();
    RestaurentRepository restaurentRepository = new InMemoryRestaurantRepositoryImpl();

    @Override
    public UUID addUser(String name) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setName(name);
        userRepository.addUser(user);
        return user.getId();
    }

    @Override
    public User removeUser(UUID id) {
        return userRepository.removeUser(id);
    }

    @Override
    public UUID addRestaurant(String name, String location) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(UUID.randomUUID());
        restaurant.setLocation(location);
        restaurant.setName(name);
        restaurentRepository.addRestaurant(restaurant);
        return restaurant.getId();
    }

    @Override
    public Restaurant removeRestaurant(UUID id) {
        return restaurentRepository.removeRestaurant(id);
    }

    @Override
    public void getAllUser() {
        List<User> allUser = userRepository.getAllUser();
        allUser.forEach(user -> System.out.println(user.getId()+ " " + user.getName() + " "));
    }

    @Override
    public void getDetailsOfRestaurant(UUID restaurantId) {
        Restaurant restaurant = restaurentRepository.getRestaurant(restaurantId);
        System.out.println(restaurant.getName());
        System.out.println("Getting Menu of the restaurant");
        restaurant.getMenu().forEach(item -> System.out.print(item.getName() + " "));
        System.out.println("\n Getting Orders");
        restaurant.getOrderList().forEach(item-> System.out.print(userRepository.getUser(item.getUserId()).getName() + " "
                + item.getTotalPrice()));
    }
}
