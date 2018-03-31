package co.melondev.cubedpay.data.common;

public class Date {

    private int numeric = 0;
    private String timestamp = "";
    private String datetime = "";
    private String date = "";
    private String relative = "";
    private String timezone = "";

    public int getNumeric() {
        return numeric;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getDate() {
        return date;
    }

    public String getRelative() {
        return relative;
    }

    public String getTimezone() {
        return timezone;
    }
}
