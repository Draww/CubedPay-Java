package co.melondev.cubedpay.api.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown =  true)
public class BaseReturnObject {

    private boolean success = false;
    @JsonProperty("return")
    private ReturnObject returnObj = null;

    public boolean didSucceed() {
        return success;
    }

    public ReturnObject getReturn() {
        return returnObj;
    }
}
