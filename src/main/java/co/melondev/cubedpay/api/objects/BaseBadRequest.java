package co.melondev.cubedpay.api.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseBadRequest extends BaseReturn {

    @JsonProperty("return")
    private BadRequestReturn returnObject = new BadRequestReturn();

    public BadRequestReturn getReturn() {
        return returnObject;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class BadRequestReturn {

        private int code = 0;

        private String message = "";

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
