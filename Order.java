public class Order {
    private int orderId;
    private int customerId;
    private int foodId;
    private String orderStatus;

    public Order(int orderId, int customerId, int foodId, String orderStatus) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.foodId = foodId;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() { return orderId; }
    public int getCustomerId() { return customerId; }
    public int getFoodId() { return foodId; }
    public String getOrderStatus() { return orderStatus; }

    public void setOrderId(int orderId) { this.orderId = orderId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public void setFoodId(int foodId) { this.foodId = foodId; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }
}
