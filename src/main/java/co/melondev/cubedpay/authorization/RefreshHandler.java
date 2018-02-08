package co.melondev.cubedpay.authorization;

import co.melondev.cubedpay.CubedPayAPI;

/**
 * @author Clutch
 * @since 02/07/2018
 */
public class RefreshHandler extends Thread {

    public volatile String authToken;

    private volatile int sleepTime;
    private volatile boolean refreshing = false;
    private volatile boolean running = true;

    private ExponentialBackoff backoff = new ExponentialBackoff();
    private CubedPayAPI api;

    public RefreshHandler(int sleepTime, String authToken, CubedPayAPI api) {
        this.sleepTime = sleepTime;
        this.authToken = authToken;

        this.api = api;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep((this.sleepTime - 10) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                continue;
            }

            refreshing = true;

            boolean[] waitingToNailIt = {true};
            while (waitingToNailIt[0]) {
                // Attempt to get the new token.
                this.api.refresh().thenAccept(data -> {
                    if (data.getOAuthToken() != null && !data.getOAuthToken().isEmpty()) {
                        System.out.println("Refreshed authentication successfully.");
                        this.authToken = data.getOAuthToken();
                        this.sleepTime = data.getExpires().getIn();

                        waitingToNailIt[0] = false; // TODO: Yuck #ThanksLambdas
                        return;
                    }
                    int next = this.backoff.next();
                    System.out.printf("Unable to refresh authentication. Trying again in %s seconds.\n", next);
                    try {
                        Thread.sleep(next * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
            refreshing = false;
        }
    }

    public void end() {
        this.running = false;
        try {
            this.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isRefreshing() {
        return refreshing;
    }
}
