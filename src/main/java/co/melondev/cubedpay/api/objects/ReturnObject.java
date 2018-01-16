package co.melondev.cubedpay.api.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown =  true)
public class ReturnObject {

    private int code = 404;
    private String message = "";

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
