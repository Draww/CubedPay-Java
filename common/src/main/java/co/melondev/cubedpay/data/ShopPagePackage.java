package co.melondev.cubedpay.data;

import com.google.gson.annotations.SerializedName;

public class ShopPagePackage {

    private String id;
    @SerializedName("package")
    private ShopPackage thePackage;
    private int order;

    public String getId() {
        return id;
    }

    public ShopPackage getPackage() {
        return thePackage;
    }

    public int getOrder() {
        return order;
    }
}
