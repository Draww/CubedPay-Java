package co.melondev.cubedpay;

import java.util.Arrays;

public class TestRequests {

    private static String username = "";
    private static String password = "";
    private static String appID = "";

    public static void main(String[] args) {
        CubedPayAPI cubedPayAPI = CubedPayAPI.create(appID);
        final String[] oauthToken = {""};
        cubedPayAPI.requestOAuth(Arrays.asList("oauth", "user-manage")).thenAccept(oauth -> {
            oauthToken[0] = oauth.getToken();
        }).thenCompose(oauth -> cubedPayAPI.getAccessToken(oauthToken[0]).thenAccept(loginUser -> {
            cubedPayAPI.data.setOAuth(loginUser.getOAuthToken());
        })).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
    }
}
