package co.melondev.cubedpay.api.objects.oauth;

import co.melondev.cubedpay.api.objects.Base;
import co.melondev.cubedpay.api.objects.BaseReturn;
import co.melondev.cubedpay.api.objects.BaseTokens;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OAuthRefreshToken extends Base {

    @JsonProperty("access_token")
    private final String accessToken;

    public OAuthRefreshToken(String appID, String accessToken) {
        super(appID);
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class OAuthRefreshTokenReturn extends BaseReturn {

        @JsonProperty("return")
        private BaseTokens returnObject = new BaseTokens();

        public BaseTokens getReturn() {
            return returnObject;
        }
    }
}
