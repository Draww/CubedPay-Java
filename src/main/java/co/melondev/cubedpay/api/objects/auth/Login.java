package co.melondev.cubedpay.api.objects.auth;

import co.melondev.cubedpay.api.objects.Base;
import co.melondev.cubedpay.api.objects.BaseDateInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
            private String[] granted_scopes = {};

            private LoginReturnExpired expires = new LoginReturnExpired();

            private LoginReturnLinks links = new LoginReturnLinks();

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

            public String[] getGrantedScopes() {
                return granted_scopes;
            }

            public LoginReturnExpired getExpires() {
                return expires;
            }

            public LoginReturnLinks getLinks() {
                return links;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public class LoginReturnExpired {

                private int in = 0;

                private BaseDateInfo on = new BaseDateInfo();

                public int getIn() {
                    return in;
                }

                public BaseDateInfo getOn() {
                    return on;
                }
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public class LoginReturnLinks {

                private String refresh = "";

                public String getRefresh() {
                    return refresh;
                }
            }
        }
    }
}
