import constants.Commands;
import constants.OrderStatus;
import services.AdminService;
import services.RestaurantService;
import services.UserService;
import services.impl.AdminServiceImpl;
import services.impl.RestaurantServiceImpl;
import services.impl.UserServiceImpl;

import java.util.*;

public class Driver {

    /*
     *  Entry point
     *  Accept Input
     */
    private static RestaurantService restaurantService;
    private static UserService userService;
    private static AdminService adminService;

    static void init() {
        restaurantService = new RestaurantServiceImpl();
        userService = new UserServiceImpl();
        adminService = new AdminServiceImpl();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome buddy !!!!");
        init();
        while(true) {
            System.out.println("Enter the command");
            String commands = sc.nextLine();
            String command[]= commands.split(" ");
            executeCommand(command);
        }
    }

    private static void executeCommand(String[] command) {
        switch (command[0]) {
            //Admin Commands
            case Commands.ADD_RESTAURANT:
                System.out.println(adminService.addRestaurant(command[1], command[2]));
                break;
            case Commands.DELETE_RESTAURANT:
                adminService.removeRestaurant(UUID.fromString(command[1]));
                break;
            case Commands.ADD_USER:
                System.out.println(adminService.addUser(command[1]));
                break;
            case Commands.REMOVE_USER:
                adminService.removeUser(UUID.fromString(command[1]));
                break;
            case Commands.GET_ALL_USERS:
                adminService.getAllUser();
                break;
            //Restaurant Commands
            case Commands.UPDATE_TIMING:
                restaurantService.updateTiming(command[1], command[2],UUID.fromString(command[3]));
                break;
            case Commands.UPDATE_MENU:
                restaurantService.addItems(command[1], Double.parseDouble(command[2]),UUID.fromString(command[3]));
                break;
            case Commands.UPDATE_ORDER_STATUS:
                OrderStatus orderStatus = OrderStatus.valueOf(command[3]);
                restaurantService.updateOrderStatus(UUID.fromString(command[1]), UUID.fromString(command[2]), orderStatus);
                break;
            //User Commands
            case Commands.SHOW_RESTAURANTS:
                userService.showRestaurants(command[1]);
                break;
            case Commands.ORDER_FOOD:
                String[] foodItems = Arrays.copyOfRange(command, 3, command.length);
                if(restaurantService.validateOrder(UUID.fromString(command[2]), List.of(foodItems))) {
                    userService.orderFood(UUID.fromString(command[1]), UUID.fromString(command[2]), List.of(foodItems));
                }
                else {
                    System.out.println("Order was not accepted by Restaurant. Food Item is not available");
                }
                break;
            case Commands.EXIT:
                System.exit(0);
                break;
        }
    }
}
