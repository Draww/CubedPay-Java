package co.melondev.cubedpay.api.objects.oauth;

import co.melondev.cubedpay.api.objects.Base;
import co.melondev.cubedpay.api.objects.BaseReturn;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OAuthRequest extends Base {

    private String scopes = "";

    public OAuthRequest(String appID) {
        super(appID);
    }

    public String getScopes() {
        return scopes;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class OAuthRequestReturn extends BaseReturn {

        @JsonProperty("return")
        private OAuthRequestReturnObject returnObject = new OAuthRequestReturnObject();

        public OAuthRequestReturnObject getReturn() {
            return returnObject;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public class OAuthRequestReturnObject {

            private String token = "";

            @JsonProperty("redirect_to")
            private String redirectTo = "";

            public String getToken() {
                return token;
            }

            public String getRedirectTo() {
                return redirectTo;
            }
        }
    }
}
