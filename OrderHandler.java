import java.util.Scanner;
import java.util.ArrayList;

public class OrderHandler {
    static ArrayList<Order> orders = new ArrayList<>();
    static int nextOrderID = 1;

    public static void showServices() {
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);

        while (isRunning) {
            Decorator.lineBraker();
            System.out.println("Please choose one number from the following option:");
            Decorator.lineBraker();

            System.out.println("1. View Menu");
            System.out.println("2. Order Food");

            System.out.println("0. Exit");
            Decorator.lineBraker();

            int option = -1;
            try {
                option = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                sc.next();
                continue;
            }

            switch (option) {
                case 1:
                    MenuOrganizer.showMenu();
                    break;
                case 2:
                    orderFood();
                    break;
                case 0:
                    exit();
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


    public static void orderFood() {
        MenuOrganizer.showMenu();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the food ID to order: ");
            int foodId = sc.nextInt();

            int price = MenuOrganizer.getPrice(foodId);
            if (price != -1) {
                int customerId = CustomerHandler.loggedIn ? 1 : 0;
                Order order = new Order(nextOrderID++, customerId, foodId, "Ordered");

                orders.add(order);
                if (customerId == 1) {
                    price -= 10;
                }
                System.out.println("You ordered food with ID " + order.getOrderId() + " for $" + price);
            } else {
                System.out.println("Invalid food ID.");
            }
        } catch (Exception e) {
            System.out.println("Error ordering food: " + e.getMessage());
        }
    }

    public static void cancelOrder() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter the order ID to cancel: ");
            int orderId = sc.nextInt();

            for(Order order : orders) {
                if(order.getOrderId() == orderId) {
                    if (!order.getOrderStatus().equals("Cancelled")) {
                        order.setOrderStatus("Cancelled");
                        System.out.println("Order with ID " + orderId + " has been cancelled.");
                    } else {
                        System.out.println("Order with ID " + orderId + " is already cancelled.");
                    }
                    return;
                }
            }
            System.out.println("Order Id not Found");
        } catch (Exception e) {
            System.out.println("Error cancelling the order: " + e.getMessage());
        }
    }

    public static void updateOrder() {
        Scanner sc = new Scanner(System.in);
        try {
            Decorator.lineBraker();
            System.out.print("Enter your order ID to update: ");
            Decorator.lineBraker();
            int orderId = sc.nextInt();

            for (Order order : orders) {
                if (order.getOrderId() == orderId && !order.getOrderStatus().equals("Cancelled")) {
                    MenuOrganizer.showMenu();
                    System.out.print("Enter new food ID: ");
                    int newFoodId = sc.nextInt();
                    int newPrice = MenuOrganizer.getPrice(newFoodId);

                    if (newPrice != -1) {
                        order.setFoodId(newFoodId);
                        System.out.println("Order updated! New food ID: " + newFoodId + ", New price: $" + newPrice);
                    } else {
                        System.out.println("Invalid food ID.");
                    }
                    return;
                }
            }

            System.out.println("❌ Order ID not found or already cancelled.");
        } catch (Exception e) {
            System.out.println("Error updating the order: " + e.getMessage());
        }
    }

    public static void showAllOrders() {
        if (orders.isEmpty()) {
            Decorator.lineBraker();
            System.out.println("No orders yet.");
            return;
        }

        Decorator.lineBraker();
        System.out.println("\nOrder List:");
        Decorator.lineBraker();

        for (Order order : orders) {
            String foodName = MenuOrganizer.getFoodNameById(order.getFoodId());
            System.out.println("Order ID: " + order.getOrderId() +
                    ", Food: " + foodName +
                    ", Status: " + order.getOrderStatus());
        }
    }



    public static void exit() {
        System.out.println("Thanks for using our service. Goodbye!");
    }
}
