package co.melondev.cubedpay.data;

import co.melondev.cubedpay.data.common.Date;

public class Payment {

    private String id = "";
    private String items = "";
    private String amount = "";
    private boolean completed = false;
    private Shop shop = new Shop();
    private Date expire_at = new Date();
    private Authorize authorize = new Authorize();

    public String getId() {
        return id;
    }

    public String getItems() {
        return items;
    }

    public String getAmount() {
        return amount;
    }

    public boolean isCompleted() {
        return completed;
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
