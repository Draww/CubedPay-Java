package co.melondev.cubedpay.data;

import com.google.gson.annotations.SerializedName;

public class ShopTheme {

    private String id;
    @SerializedName("default")
    private boolean isDefault;
    private String name;
    private String css;

    public String getId() {
        return id;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public String getName() {
        return name;
    }

    public String getCss() {
        return css;
    }
}
