package co.melondev.cubedpay.data;

import java.util.Date;

/**
 * @author theminecoder
 */
public class ShopDiscount {

    private String id;
    private String name;
    private Date starts;
    private Date ends;
    private boolean active;
    private double amount;
    private boolean percent;
    private String code;
    private int maxUses;
    private int uses;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStarts() {
        return starts;
    }

    public Date getEnds() {
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

    public String getCode() {
        return code;
    }

    public int getMaxUses() {
        return maxUses;
    }

    public int getUses() {
        return uses;
    }
}
