package co.melondev.cubedpay;

import org.bukkit.configuration.file.FileConfiguration;

public class CubedPaySettings {

    private String appID = "";
    private String accessToken = "";
    private String shopID = "";

    public void load(FileConfiguration conf) {
        this.appID = conf.getString("appID");
        this.accessToken = conf.getString("accessToken");
        this.shopID = conf.getString("shopID");
    }

    public String getAppID() {
        return appID;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getShopID() {
        return shopID;
    }
}
