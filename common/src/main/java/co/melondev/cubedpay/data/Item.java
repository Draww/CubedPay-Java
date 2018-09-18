package co.melondev.cubedpay.data;

import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("package")
    private String id = "";
    private Integer quantity = 0;

    public Item(String id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public String getPackage() {
        return id;
    }

    @Deprecated
    public String getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

}
