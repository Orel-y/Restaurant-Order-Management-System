import java.util.ArrayList;
import java.util.Scanner;

public class CustomerHandler {
    static ArrayList<Customer> customers = new ArrayList<>();
    static boolean loggedIn = false;

    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static boolean isCustomerExists(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isPasswordCorrect(String name, String password) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name) && customer.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void login() {
        if (loggedIn) {
            System.out.println("You are already logged in.");
            return;
        }

        System.out.print("Enter your name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        if (name.isEmpty() || password.isEmpty()) {
            System.out.println("Please Insert The requirements (name, password)");
            return;
        }

        if (isCustomerExists(name)) {
            if (isPasswordCorrect(name, password)) {
                System.out.println("Login successful!");
                loggedIn = true;

                OrderHandler.showServices();
            } else {
                System.out.println("Incorrect password. Please try again.");
            }
        } else {
            System.out.println("Customer not found. Please sign up.");
        }
    }

    public static void signUp() {
        System.out.print("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.print("Enter your password:");
        String password = scanner.nextLine();

        if (name.isEmpty() || password.isEmpty()) {
            System.out.println("Please Insert The requirements (name, password)");
            return;
        }

        if (!isCustomerExists(name)) {
            Customer newCustomer = new Customer(name, password);
            addCustomer(newCustomer);
            System.out.println("Sign up successful! You can now log in.");
        } else {
            System.out.println("Customer already exists. Please log in.");
        }
    }
    public static void logout() {
        if (loggedIn) {
            loggedIn = false;
            System.out.println("Logged out successfully.");
        } else {
            System.out.println("You are not logged in.");
        }
    }

}
