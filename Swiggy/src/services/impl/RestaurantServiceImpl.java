package services.impl;

import constants.OrderStatus;
import model.FoodItem;
import model.Restaurant;
import repository.RestaurentRepository;
import repository.impl.InMemoryRestaurantRepositoryImpl;
import services.RestaurantService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static util.RestaurantUtility.convertStringDateToLocalDateTime;

public class RestaurantServiceImpl implements RestaurantService {

    RestaurentRepository restaurentRepository = new InMemoryRestaurantRepositoryImpl();

    @Override
    public void updateTiming(String startingTime, String endingTime, UUID id) {
        Restaurant restaurant = restaurentRepository.getRestaurant(id);
        restaurant.setOpeningTime(convertStringDateToLocalDateTime(startingTime));
        restaurant.setClosingTime(convertStringDateToLocalDateTime(endingTime));
    }

    @Override
    public List<FoodItem> addItems(String name, Double price, UUID id) {
        Restaurant restaurant = restaurentRepository.getRestaurant(id);
        List<FoodItem> menu = restaurant.getMenu();
        menu.add(new FoodItem(name,price));
        restaurant.setMenu(menu);
        return menu;
    }

    @Override
    public void updateOrderStatus(UUID restaurantId, UUID orderId, OrderStatus orderStatus) {
        Restaurant restaurant = restaurentRepository.getRestaurant(restaurantId);
        restaurant.getOrderList().stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .forEach(order -> order.setOrderStatus(orderStatus));
    }

    @Override
    public boolean validateOrder(UUID restaurantId, List<String> foodItems) {
        Restaurant restaurant = restaurentRepository.getRestaurant(restaurantId);
        List<FoodItem> menu = restaurant.getMenu();
        List<String> menuItems = menu.stream().map(FoodItem::getName).collect(Collectors.toList());
        return menuItems.containsAll(foodItems);
    }

}
