package co.melondev.cubedpay.data;

import co.melondev.cubedpay.data.common.Date;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private String id = "";
    private String url = "";
    private String name = "";
    private String logo = "";
    private boolean active = false;
    private boolean disabled = false;
    private String disabled_reason = "";
    private String time_zone = "";
    private List<User> members = new ArrayList<>();
    private String plan = "";
    private List<String> gateways = new ArrayList<>();
    private Date created = new Date();

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
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

    public String getTimezone() {
        return time_zone;
    }

    public List<User> getMembers() {
        return members;
    }

    public String getPlan() {
        return plan;
    }

    public List<String> getGateways() {
        return gateways;
    }

    public Date getCreated() {
        return created;
    }
}
