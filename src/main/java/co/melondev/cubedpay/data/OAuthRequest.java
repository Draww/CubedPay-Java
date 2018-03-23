package co.melondev.cubedpay.data;

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
