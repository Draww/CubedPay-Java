package co.melondev.cubedpay.data;

import java.util.ArrayList;

public class Order {

    private int id = 0;
    private Payment transaction = new Payment();
    private User user = new User();
    private int total = 0;
    private ArrayList<Item> items = new ArrayList<>();
    private boolean status = false;

    public int getId() {
        return id;
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

    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean isStatus() {
        return status;
    }
}
