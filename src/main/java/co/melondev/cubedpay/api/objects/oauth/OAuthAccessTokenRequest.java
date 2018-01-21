package co.melondev.cubedpay.api.objects.oauth;

import co.melondev.cubedpay.api.objects.Base;
import co.melondev.cubedpay.api.objects.BaseReturn;
import co.melondev.cubedpay.api.objects.BaseTokens;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OAuthAccessTokenRequest extends Base {

    private final String token;

    public OAuthAccessTokenRequest(String appID, String token) {
        super(appID);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class OAuthAccessTokenRequestReturn extends BaseReturn {

        @JsonProperty("return")
        private BaseTokens returnObject = new BaseTokens();

        public BaseTokens getReturn() {
            return returnObject;
        }
    }
}
