import java.util.ArrayList;

public class MenuOrganizer {
    static ArrayList<MenuContent> foodsList = new ArrayList<>();

    static {
        foodsList.add(new MenuContent(1, "Pizza \uD83C\uDF55", 450));
        foodsList.add(new MenuContent(2, "Ayinet \uD83E\uDD58", 60));
        foodsList.add(new MenuContent(3, "Pasta \uD83C\uDF5C", 60));
        foodsList.add(new MenuContent(4, "Shiro \uD83C\uDF5D", 70));
        foodsList.add(new MenuContent(5, "Miser \uD83C\uDF5D", 60));
    }

    public static void showMenu() {
        Decorator.lineBraker();
        System.out.println("\uD83C\uDF7D\uFE0F Food Menu \uD83C\uDF7D\uFE0F");
        Decorator.lineBraker();

        for (MenuContent food : foodsList) {
            System.out.println(food.getId() + ". " + food.getFoodName() + " - $" + food.getPrice());
        }
        Decorator.lineBraker();
    }

    public static int getPrice(int id) {
        for (MenuContent food : foodsList) {
            if (food.getId() == id) {
                return food.getPrice();
            }
        }
        return -1;
    }

    public static String getFoodNameById(int id) {
        for (MenuContent food : foodsList) {
            if (food.getId() == id) {
                return food.getFoodName();
            }
        }
        return "Unknown Food";
    }
}
