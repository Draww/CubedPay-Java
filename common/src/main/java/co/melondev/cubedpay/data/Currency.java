package co.melondev.cubedpay.data;

public class Currency {

    private String iso = "";
    private String name = "";
    private int decimals = 0;
    private String format = "";

    public String getCode() {
        return iso;
    }

    public String getName() {
        return name;
    }

    public int getDecimals() {
        return decimals;
    }

    public String getFormat() {
        return format;
    }

}
