package co.melondev.cubedpay.data;

/**
 * @author Clutch
 * @since 2/15/2018
 */
public class OAuthRequest {

    private String token = "";
    private String redirect_to = "";

    public String getToken() {
        return token;
    }

    public String getRedirectTo() {
        return redirect_to;
    }
}
