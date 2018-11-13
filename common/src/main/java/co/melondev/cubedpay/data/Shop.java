package co.melondev.cubedpay.data;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private String id = "";
    private String url = "";
    private String customUrl = "";
    private String name = "";
    private UploadedImage logo = new UploadedImage();
    private boolean active = false;
    private boolean disabled = false;
    private boolean sandbox_mode = true;
    private String disabled_reason = "";
    private Game game = new Game();
    private String time_zone = "";
    private String template = "";
    private String home_text = "";
    private List<User> members = new ArrayList<>();
    private List<Gateway> gateways = new ArrayList<>();
    private List<ShopMedia> assets = new ArrayList<>();
    private ShopTemplateMeta template_meta;
    private ShopTheme theme;
    private ShopColors colors;
    private ShopPlan plan;
    private Currency currency;

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getCustomUrl() {
        return customUrl;
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

    public boolean isSandboxMode() {
        return sandbox_mode;
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

    public String getTemplate() {
        return template;
    }

    public String getHomeText() {
        return home_text;
    }

    public List<User> getMembers() {
        return members;
    }

    public ShopTemplateMeta getTemplateMeta() {
        return template_meta;
    }

    public List<ShopMedia> getAssets() {
        return assets;
    }

    public ShopTheme getTheme() {
        return theme;
    }

    public ShopColors getColors() {
        return colors;
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
