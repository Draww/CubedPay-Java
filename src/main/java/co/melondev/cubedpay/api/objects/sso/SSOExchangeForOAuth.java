package co.melondev.cubedpay.api.objects.sso;

import co.melondev.cubedpay.api.objects.Base;
import co.melondev.cubedpay.api.objects.BaseID;
import co.melondev.cubedpay.api.objects.BaseReturn;
import co.melondev.cubedpay.api.objects.BaseTokens;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SSOExchangeForOAuth extends Base {

    @JsonProperty("sso_token")
    private final String ssoToken;

    public SSOExchangeForOAuth(String appID, String ssoToken) {
        super(appID);
        this.ssoToken = ssoToken;
    }

    public String getSSOToken() {
        return ssoToken;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class SSOExchangeForOAuthReturn extends BaseReturn {

        @JsonProperty("return")
        private SSOExchangeForOAuthReturnObject returnObject = new SSOExchangeForOAuthReturnObject();

        public SSOExchangeForOAuthReturnObject getReturn() {
            return returnObject;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public class SSOExchangeForOAuthReturnObject {

            private BaseTokens tokens = new BaseTokens();

            private BaseID sso = new BaseID();

            public BaseTokens getTokens() {
                return tokens;
            }

            public BaseID getSSO() {
                return sso;
            }
        }
    }
}
