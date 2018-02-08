package co.melondev.cubedpay;

public class TestRequests {

    private static String username = "";
    private static String password = "";
    private static String appID = "";

    public static void main(String[] args) {
        CubedPayAPI cubedPayAPI = CubedPayAPI.create(appID);
        cubedPayAPI.login(username, password, "localhost", "java").thenAccept(loginUser -> {
            cubedPayAPI.data.setOAuth(loginUser.getOAuthToken());

            cubedPayAPI.refresh().thenAccept(refreshUser -> {
                cubedPayAPI.data.setOAuth(refreshUser.getOAuthToken());
            });
        });
    }
}
