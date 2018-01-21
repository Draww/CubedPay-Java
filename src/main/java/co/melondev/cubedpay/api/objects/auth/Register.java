package co.melondev.cubedpay.api.objects.auth;

import co.melondev.cubedpay.api.objects.Base;
import co.melondev.cubedpay.api.objects.BaseReturn;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Register extends Base {

    private final String username;
    private final String email;
    private final String password;
    private final String firstName;
    private final String lastName;

    public Register(String appID, String username, String email, String password, String firstName, String lastName) {
        super(appID);
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class RegisterReturn extends BaseReturn {

        @JsonProperty("return")
        private RegisterReturnObject returnObj = new RegisterReturnObject();

        public RegisterReturnObject getReturn() {
            return returnObj;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public class RegisterReturnObject {

            private boolean registered = false;

            @JsonProperty("needs_verification")
            private boolean needsVerification = false;

            private RegisterReturnLinks links = new RegisterReturnLinks();

            public boolean isRegistered() {
                return registered;
            }

            public boolean isNeedsVerification() {
                return needsVerification;
            }

            public RegisterReturnLinks getLinks() {
                return links;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public class RegisterReturnLinks {
                private String auth = "";

                public String getAuth() {
                    return auth;
                }
            }
        }
    }
}
