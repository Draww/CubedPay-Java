package co.melondev.cubedpay.api.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseDateInfo {

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
