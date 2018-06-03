package co.melondev.cubedpay.data;

import co.melondev.cubedpay.data.common.Date;

import java.util.HashMap;
import java.util.Map;

public class LoginUser {

    private String access_token = "";
    private String oauth_token = "";
    private String refresh_token = "";
    private Date last_used = new Date();
    private int status = 0;
    private Map<String, String> scopes = new HashMap<>();
    private Map<String, String> scope = new HashMap<>();
    private Expires expires = new Expires();
    private int expires_in = 0;
    private Links links = new Links();

    public String getAccessToken() {
        return access_token;
    }

    public String getOAuthToken() {
        return oauth_token;
    }

    public String getRefreshToken() {
        return refresh_token;
    }

    public Date getLastUsed() {
        return last_used;
    }

    public int getStatus() {
        return status;
    }

    public Map<String, String> getScopes() {
        return scopes;
    }

    public Map<String, String> getScope() {
        return scope;
    }

    public Expires getExpires() {
        return expires;
    }

    public int getExpiresIn() {
        return expires_in;
    }

    public Links getLinks() {
        return links;
    }
}
