package co.melondev.cubedpay.data;

import java.util.List;

public class PublicShop {

    public class PublicGateway {
        private String type;
        private double fee;
        private boolean feePercentage;

        public String getType() {
            return type;
        }

        public double getFee() {
            return fee;
        }

        public boolean isFeePercentage() {
            return feePercentage;
        }
    }

    private String id;
    private String url;
    private String custom_url;
    private String name;
    private UploadedImage logo;
    private boolean sandbox_mode;
    private ShopTheme theme;
    private String template;
    private String homeText;
    private ShopPlan plan;
    private List<PublicGateway> activeGateways;
    private List<ShopSale> activeSales;
    private ShopColors colors;
    private Currency currency;

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getCustomUrl() {
        return custom_url;
    }

    public String getName() {
        return name;
    }

    public UploadedImage getLogo() {
        return logo;
    }

    public boolean isSandboxMode() {
        return sandbox_mode;
    }

    public ShopTheme getTheme() {
        return theme;
    }

    public String getTemplate() {
        return template;
    }

    public String getHomeText() {
        return homeText;
    }

    public ShopPlan getPlan() {
        return plan;
    }

    public List<PublicGateway> getActiveGateways() {
        return activeGateways;
    }

    public List<ShopSale> getActiveSales() {
        return activeSales;
    }

    public Currency getCurrency() {
        return currency;
    }

}
