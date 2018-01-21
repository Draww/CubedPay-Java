package co.melondev.cubedpay.api.objects.oauth;

import co.melondev.cubedpay.api.objects.Base;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OauthAccessTokenRequest extends Base {

    private final String token;

    public OauthAccessTokenRequest(String appID, String token) {
        super(appID);
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
