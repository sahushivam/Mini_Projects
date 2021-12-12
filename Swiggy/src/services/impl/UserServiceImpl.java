package services.impl;

import model.FoodItem;
import model.Order;
import model.Restaurant;
import model.User;
import repository.RestaurentRepository;
import repository.UserRepository;
import repository.impl.InMemoryRestaurantRepositoryImpl;
import repository.impl.InMemoryUserRepository;
import services.UserService;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    UserRepository userRepository = new InMemoryUserRepository();
    RestaurentRepository restaurentRepository= new InMemoryRestaurantRepositoryImpl();

    @Override
    public List<Restaurant> showRestaurants(String location) {
        LocalTime currentTime = LocalTime.now();

        List<Restaurant> restaurants = restaurentRepository.getAllRestaurant()
                .stream()
                .filter(restaurant -> restaurant.getLocation().equalsIgnoreCase(location))
                .filter(restaurant -> restaurant.getClosingTime().isAfter(currentTime))
                .filter(restaurant -> restaurant.getOpeningTime().isBefore(currentTime))
                .collect(Collectors.toList());

        for (Restaurant restaurent : restaurants) {
            System.out.println("Menu at" + restaurent.getId() + "   " + restaurent.getName());
            restaurent.getMenu().forEach(menu-> System.out.println(menu.getName()));
        }

        for (Restaurant restaurent : restaurants) {
            System.out.println("Food Order received at " + restaurent.getName());
            restaurent.getOrderList().forEach(menu-> System.out.print(menu.getOrderId()));
        }
        System.out.println();
        return restaurants;
    }

    @Override
    public User getUser(UUID id) {
        return userRepository.getUser(id);
    }

    @Override
    public UUID orderFood(UUID userId, UUID restaurantId, List<String> foodItemList) {
        Restaurant restaurant = restaurentRepository.getRestaurant(restaurantId);
        List<FoodItem> menuList = restaurant.getMenu(); //Price
        List<FoodItem> foodItems = generateOrder(foodItemList,menuList);
        Order order = new Order(userId, restaurantId, foodItems);
        order.setTotalPrice(generateBill(foodItems));
        List<Order> orderList = restaurant.getOrderList();
        orderList.add(order);
        restaurant.setOrderList(orderList);
        System.out.println("Order Placed.  " + order.getOrderId());
        return order.getOrderId();
    }

    private Double generateBill(List<FoodItem> foodItems) {
        Double sum =0.0;
        for(FoodItem foodItem:foodItems) {
            sum += foodItem.getPrice()*foodItem.getQuantity();
        }
        System.out.println("Total Price of Order is " + sum);
        return sum;
    }

    private List<FoodItem> generateOrder(List<String> foodItemList, List<FoodItem> menuList) {
        HashMap<String, Integer> foodOrder = new HashMap<>();
        for(String item:foodItemList) {
           if(foodOrder.containsKey(item)) {
               foodOrder.put(item,foodOrder.get(item)+1);
           }
           else {
               foodOrder.put(item,1);
           }
        }
        Map<String, FoodItem> map =
                menuList.stream().collect(Collectors.toMap(FoodItem::getName, item -> item));

        List<FoodItem> foodItems = new ArrayList<>();
        for(Map.Entry<String,Integer> item: foodOrder.entrySet()){
            FoodItem foodItem = new FoodItem(item.getKey(),map.get(item.getKey()).getPrice(),item.getValue());
            foodItems.add(foodItem);
        }
        return foodItems;
    }
}
