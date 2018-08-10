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
    private String name;
    private UploadedImage logo;
    private boolean sandboxMode;
    private ShopTheme theme;
    private String homeText;
    private List<PublicGateway> activeGateways;
    private List<ShopSale> activeSales;

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

    public boolean isSandboxMode() {
        return sandboxMode;
    }

    public ShopTheme getTheme() {
        return theme;
    }

    public String getHomeText() {
        return homeText;
    }

    public List<PublicGateway> getActiveGateways() {
        return activeGateways;
    }

    public List<ShopSale> getActiveSales() {
        return activeSales;
    }
}
