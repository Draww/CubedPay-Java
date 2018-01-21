package co.melondev.cubedpay.api.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseTokens {

    @JsonProperty("oauth_token")
    private String oauthToken = "";

    @JsonProperty("refresh_token")
    private String refreshToken = "";

    @JsonProperty("last_used")
    private BaseDateInfo lastUsed = new BaseDateInfo();

    private int status = 0;

    @JsonProperty("granted_scopes")
    private List<String> grantedScopes = new ArrayList<>();

    private BaseExpires expires = new BaseExpires();

    private BaseLinks links = new BaseLinks();

    public String getOauthToken() {
        return oauthToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public BaseDateInfo getLastUsed() {
        return lastUsed;
    }

    public int getStatus() {
        return status;
    }

    public List<String> getGrantedScopes() {
        return grantedScopes;
    }

    public BaseExpires getExpires() {
        return expires;
    }

    public BaseLinks getLinks() {
        return links;
    }
}
