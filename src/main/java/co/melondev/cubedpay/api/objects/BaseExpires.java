package co.melondev.cubedpay.api.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseExpires {

    private int in = 0;

    private BaseDateInfo on = new BaseDateInfo();

    public int getIn() {
        return in;
    }

    public BaseDateInfo getOn() {
        return on;
    }
}
