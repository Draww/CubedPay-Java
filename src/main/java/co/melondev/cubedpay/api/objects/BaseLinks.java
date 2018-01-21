package co.melondev.cubedpay.api.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseLinks {

    private String refresh = "";

    public String getRefresh() {
        return refresh;
    }
}