package services;

import constants.OrderStatus;
import model.FoodItem;

import java.util.List;
import java.util.UUID;

public interface RestaurantService {

    void updateTiming(String startingTime, String endingTime, UUID id);
    List<FoodItem> addItems(String name, Double price, UUID id);
    void updateOrderStatus(UUID restaurantId, UUID orderId, OrderStatus orderStatus);
    boolean validateOrder(UUID fromString, List<String> foodItems);
}
