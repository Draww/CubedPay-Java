package co.melondev.cubedpay.api.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseReturn {

    private boolean success = false;

    public boolean isSuccess() {
        return success;
    }
}
