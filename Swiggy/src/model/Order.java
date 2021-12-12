package model;

import constants.OrderStatus;

import java.util.List;
import java.util.UUID;

public class Order {

    UUID orderId;
    UUID userId;
    UUID restaurantId;
    List<FoodItem> foodItems;
    OrderStatus orderStatus;

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    Double totalPrice;

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(UUID restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order(UUID userId, UUID restaurantId, List<FoodItem> foodItems) {
        this.orderId = UUID.randomUUID();
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.foodItems = foodItems;
        this.orderStatus = OrderStatus.NOT_ACCEPTED;
    }
}
