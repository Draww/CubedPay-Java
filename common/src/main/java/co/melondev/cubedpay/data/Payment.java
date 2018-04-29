package co.melondev.cubedpay.data;

import co.melondev.cubedpay.data.common.Date;

import java.util.ArrayList;
import java.util.List;

public class Payment {

    private String id = "";
    private List<Item> items = new ArrayList<>();
    private int amount = 0;
    private boolean completed = false;
    private UserProfile profile = new UserProfile();
    private Shop shop = new Shop();
    private Date expire_at = new Date();
    private Authorize authorize = new Authorize();

    public String getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isCompleted() {
        return completed;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public Shop getShop() {
        return shop;
    }

    public Date getExpireAt() {
        return expire_at;
    }

    public Authorize getAuthorize() {
        return authorize;
    }
}
