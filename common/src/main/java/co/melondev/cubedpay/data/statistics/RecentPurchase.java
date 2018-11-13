package co.melondev.cubedpay.data.statistics;

import co.melondev.cubedpay.data.PublicUser;
import co.melondev.cubedpay.data.ShopPackage;

import java.util.List;

public class RecentPurchase {

    private PublicUser user;
    private List<ShopPackage> items;
    private String date;

    public PublicUser getUser() {
        return user;
    }

    public List<ShopPackage> getItems() {
        return items;
    }

    public String getDate() {
        return date;
    }

}
