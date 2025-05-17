import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isRunning = true;

        while(isRunning) {
            Decorator.lineBraker();
            System.out.println("\uD83C\uDF7D\uFE0F Restaurant Order Manager \uD83C\uDF7D\uFE0F ");
            Decorator.lineBraker();

            System.out.println("Please Choose One Option");
            System.out.println("1, LOGIN - (i am  a customer)" );
            System.out.println("2, SIGNUP - (get service as a guest) ");
            System.out.println("3, LOGOUT");
            System.out.println("4, GET THE SERVICES AS A GUEST");
            System.out.println("5, ADMIN LOGIN");
            System.out.println("0, EXIT - (i am not interested in this service) ");



            Scanner  sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    CustomerHandler.login();
                    break;
                case 2:
                    CustomerHandler.signUp();
                    break;
                case 3:
                    CustomerHandler.logout();
                    break;
                case 4:
                    OrderHandler.showServices();
                    break;
                 case 5:
                    AdminHandler.login();
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }
}
