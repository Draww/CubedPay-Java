package co.melondev.cubedpay.data;

import java.util.ArrayList;

public class Order {

    private int id = 0;
    private Shop shop = new Shop();
    private Payment transaction = new Payment();
    private User user = new User();
    private int total = 0;
    private PaymentInfo payment = new PaymentInfo();
    private ArrayList<Item> items = new ArrayList<>();
    private boolean status = false;

    public int getId() {
        return id;
    }

    public Shop getShop() {
        return shop;
    }

    public Payment getTransaction() {
        return transaction;
    }

    public User getUser() {
        return user;
    }

    public int getTotal() {
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
}
