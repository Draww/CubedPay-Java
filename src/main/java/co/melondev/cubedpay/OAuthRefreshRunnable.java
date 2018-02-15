package co.melondev.cubedpay;

/**
 * @author Clutch
 * @since 2/15/2018
 */
public class OAuthRefreshRunnable implements Runnable {

    private final CubedPayAPI cubedPayAPI;

    OAuthRefreshRunnable(CubedPayAPI cubedPayAPI) {
        this.cubedPayAPI = cubedPayAPI;
    }

    @Override
    public void run() {
        cubedPayAPI.refreshOAuth().thenAccept(loginUser -> {
            cubedPayAPI.data.setOAuth(loginUser.getOAuthToken());
        }).exceptionally(throwable -> {
            throwable.printStackTrace();
            return null;
        });
    }
}
