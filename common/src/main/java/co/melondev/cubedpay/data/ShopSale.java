package co.melondev.cubedpay.data;


public class ShopSale {

    private String id;
    private String name;
    private String starts;
    private String ends;
    private boolean active;
    private double amount;
    private boolean percent;
    private boolean visible;
    private String banner;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStarts() {
        return starts;
    }

    public String getEnds() {
        return ends;
    }

    public boolean isActive() {
        return active;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPercent() {
        return percent;
    }

    public boolean isVisible() {
        return visible;
    }

    public String getBanner() {
        return banner;
    }

    @Override
    public String toString() {
        return "ShopSale{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", starts='" + starts + '\'' +
                ", ends='" + ends + '\'' +
                ", active=" + active +
                ", amount=" + amount +
                ", percent=" + percent +
                ", visible=" + visible +
                ", banner='" + banner + '\'' +
                '}';
    }
}
