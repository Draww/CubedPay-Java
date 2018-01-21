package co.melondev.cubedpay.api.objects.sso;

import co.melondev.cubedpay.api.objects.Base;
import co.melondev.cubedpay.api.objects.BaseID;
import co.melondev.cubedpay.api.objects.BaseReturn;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SSOTokenRequest extends Base {

    @JsonProperty("access_token")
    private final String accessToken;

    public SSOTokenRequest(String appID, String accessToken) {
        super(appID);
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class SSOTokenRequestReturn extends BaseReturn {

        @JsonProperty("return")
        private BaseID returnObject = new BaseID();

        public BaseID getReturn() {
            return returnObject;
        }
    }
}
