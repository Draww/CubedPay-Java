package co.melondev.cubedpay.api.objects.auth;

import co.melondev.cubedpay.api.objects.Base;
import co.melondev.cubedpay.api.objects.BaseDateInfo;
import co.melondev.cubedpay.api.objects.BaseExpires;
import co.melondev.cubedpay.api.objects.BaseLinks;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Login extends Base {

    private final String username;
    private final String password;
    private final String ip;
    private final String fingerprint;

    public Login(String appID, String username, String password, String ip, String fingerprint) {
        super(appID);
        this.username = username;
        this.password = password;
        this.ip = ip;
        this.fingerprint = fingerprint;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getIp() {
        return ip;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class LoginReturn {

        @JsonProperty("return")
        private LoginReturnObject returnObject = new LoginReturnObject();

        public LoginReturnObject getReturn() {
            return returnObject;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public class LoginReturnObject {

            @JsonProperty("oauth_token")
            private String oauthToken = "";

            @JsonProperty("refresh_token")
            private String refreshToken = "";

            @JsonProperty("last_used")
            private BaseDateInfo lastUsed = new BaseDateInfo();

            private boolean status = false;

            // String array? null?
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

            public boolean isStatus() {
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
    }
}
