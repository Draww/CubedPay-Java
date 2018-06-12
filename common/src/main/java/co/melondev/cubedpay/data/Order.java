package co.melondev.cubedpay.data;

import java.util.ArrayList;

public class Order {

    private String id = "";
    private Shop shop = new Shop();
    private Transaction transaction = new Transaction();
    private User user = new User();
    private double total = 0;
    private PaymentInfo payment = new PaymentInfo();
    private ArrayList<Item> items = new ArrayList<>();
    private boolean status = false;

    public String getId() {
        return id;
    }

    public Shop getShop() {
        return shop;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public User getUser() {
        return user;
    }

    public double getTotal() {
        return total;
    }

    public PaymentInfo getPayment() {
        return payment;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", shop=" + shop +
                ", transaction=" + transaction +
                ", user=" + user +
                ", total=" + total +
                ", payment=" + payment +
                ", items=" + items +
                ", status=" + status +
                '}';
    }
}
