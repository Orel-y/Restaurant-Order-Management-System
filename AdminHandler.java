import java.util.ArrayList;
import java.util.Scanner;

public class AdminHandler {
    static ArrayList<Admin> admins = new ArrayList<>();
    static boolean isLoggedIn = false;

    static {
        admins.add(new Admin("admin", "admin123"));
    }

    public static void login() {
        if (isLoggedIn) {
            System.out.println("You are already logged in as Admin.");
            return;
        }
        Decorator.lineBraker();
        Scanner sc = new Scanner(System.in);
        System.out.print("Admin Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        Decorator.lineBraker();

        for (Admin admin : admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                isLoggedIn = true;
                System.out.println("Admin login successful!");
                showAdminDashboard();
                return;
            }
        }

        System.out.println("Incorrect credentials. Try again or type 'exit' to go back");
        System.out.print("Retry login? (yes/exit)");
        String retry = sc.nextLine().trim().toLowerCase();
        if (retry.equals("exit")) {
            System.out.println("Exiting admin login.");
        } else if (retry.equals("yes")) {
            login();
        } else {
            System.out.println("Invalid option. Exiting admin login.");
        }
    }

    public static void logout() {
        if (isLoggedIn) {
            isLoggedIn = false;
            System.out.println("Admin logged out.");
        } else {
            System.out.println("No admin is logged in.");
        }
    }

    public static void showAdminDashboard() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            Decorator.lineBraker();
            System.out.println("===== Admin Dashboard =====");
            Decorator.lineBraker();

            System.out.println("1. View All Orders");
            System.out.println("2. Cancel Order");
            System.out.println("3. Update Order");
            System.out.println("4. Logout");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    OrderHandler.showAllOrders();
                    break;
                case 2:
                    OrderHandler.cancelOrder();
                    break;
                case 3:
                    OrderHandler.updateOrder();
                    break;
                case 4:
                    logout();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
