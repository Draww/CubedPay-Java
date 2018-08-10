package co.melondev.cubedpay.data;

import java.util.Date;

public class Transaction {

    public enum Status {
        PENDING,
        ABANDONED,
        COMPLETED
    }

    private String id;
    private Status status;
    private PublicUser user;
    private PublicShop shop;
    private ShopDiscount discount;
    private String amount;
    private Date created;
    private Date completed;

    public String getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public PublicUser getUser() {
        return user;
    }

    public PublicShop getShop() {
        return shop;
    }

    public ShopDiscount getDiscount() {
        return discount;
    }

    public String getAmount() {
        return amount;
    }

    public Date getCreated() {
        return created;
    }

    public Date getCompleted() {
        return completed;
    }
}
