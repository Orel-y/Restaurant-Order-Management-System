public class Menu {
    private int id;
    private String foodName;
    private int price;

    public Menu(int id, String foodName, int price){
        this.id = id;
        this.foodName = foodName;
        this.price = price;
    }

    public int getId() { return (this.id); }
    public String getFoodName() { return (this.foodName);}
    public int getPrice() { return (this.price);}
    public void setId(int id) { this.id = id; }
    public void setFoodName(String foodName) { this.foodName = foodName; }
    public void setPrice(int price) { this.price = price; }

}
