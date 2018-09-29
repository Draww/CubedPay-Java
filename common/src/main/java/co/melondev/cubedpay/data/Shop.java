package co.melondev.cubedpay.data;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private String id = "";
    private String url = "";
    private String name = "";
    private UploadedImage logo = new UploadedImage();
    private boolean active = false;
    private boolean disabled = false;
    private String disabled_reason = "";
    private Game game = new Game();
    private String time_zone = "";
    private List<User> members = new ArrayList<>();
    private List<Gateway> gateways = new ArrayList<>();
    private ShopPlan plan;
    private Currency currency;

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public UploadedImage getLogo() {
        return logo;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public String getDisabledReason() {
        return disabled_reason;
    }

    public Game getGame() {
        return game;
    }

    public String getTimezone() {
        return time_zone;
    }

    public List<User> getMembers() {
        return members;
    }

    public List<Gateway> getGateways() {
        return gateways;
    }

    public ShopPlan getPlan() {
        return plan;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", logo=" + logo +
                ", active=" + active +
                ", disabled=" + disabled +
                ", disabled_reason='" + disabled_reason + '\'' +
                ", game=" + game +
                ", time_zone='" + time_zone + '\'' +
                ", members=" + members +
                ", gateways=" + gateways +
                '}';
    }
}
