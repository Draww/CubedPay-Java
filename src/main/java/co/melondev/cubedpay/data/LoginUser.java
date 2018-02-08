package co.melondev.cubedpay.data;

import co.melondev.cubedpay.data.common.Date;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Clutch
 * @since 2/7/2018
 */
public class LoginUser {

    private String oauth_token = "";
    private String refresh_token = "";

    private Date last_used = new Date();
    private String status = "";
    private List<String> granted_scopes = new ArrayList<>();

    private Expires expires = new Expires();
    private Links links = new Links();

    public String getOAuthToken() {
        return oauth_token;
    }

    public String getRefreshToken() {
        return refresh_token;
    }

    public Date getLastUsed() {
        return last_used;
    }

    public String getStatus() {
        return status;
    }

    public List<String> getGrantedScopes() {
        return granted_scopes;
    }

    public Expires getExpires() {
        return expires;
    }

    public Links getLinks() {
        return links;
    }

    public class Expires {
        private int in = 0;
        private Date on = new Date();

        public int getIn() {
            return in;
        }

        public Date getOn() {
            return on;
        }
    }

    public class Links {
        private String refresh = "";

        public String getRefresh() {
            return refresh;
        }
    }
}
