package co.melondev.cubedpay.api.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseID {

    private String id = "";

    private boolean valid = false;

    private BaseExpires expire = new BaseExpires();

    public String getId() {
        return id;
    }

    public boolean isValid() {
        return valid;
    }

    public BaseExpires getExpire() {
        return expire;
    }
}
