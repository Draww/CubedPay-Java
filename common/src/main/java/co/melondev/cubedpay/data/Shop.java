package co.melondev.cubedpay.data;

import co.melondev.cubedpay.data.common.Date;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private String id = "";
    private String url = "";
    private String name = "";
    private Logo logo = new Logo();
    private boolean active = false;
    private boolean disabled = false;
    private String disabled_reason = "";
    private Game game = new Game();
    private String time_zone = "";
    private List<User> members = new ArrayList<>();
    private List<Gateway> gateways = new ArrayList<>();

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public Logo getLogo() {
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
}
