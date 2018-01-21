package co.melondev.cubedpay.api.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Base {

    private final String appID;

    public Base(String appID) {
        this.appID = appID;
    }

    @JsonIgnore
    public String getAppID() {
        return appID;
    }
}
