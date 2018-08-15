package co.melondev.cubedpay.events;

import co.melondev.cubedpay.CubedPayAPI;
import co.melondev.cubedpay.api.CubedPayShopAPI;

public class CubedEventRunnable implements Runnable {

    private final CubedPayAPI cubedPayAPI;
    private final CubedPayShopAPI shopAPI;
    private final String shopID;

    private boolean isRunning = false;

    public CubedEventRunnable(CubedPayAPI cubedPayAPI, String shopID) {
        this.cubedPayAPI = cubedPayAPI;
        this.shopAPI = cubedPayAPI.getShopAPI();
        this.shopID = shopID;
    }

    @Override
    public void run() {
        if (isRunning) return;
        isRunning = true;
        shopAPI.getEvents(shopID).thenAccept(events -> {
            events.getData().forEach(data -> {
                if (data.getType() != null) {
                    CubedEvent event = data.getType().getCreator().apply(data);
                    if (cubedPayAPI.emitEvent(event)) {
                        shopAPI.acceptEvent(shopID, data.getId()).exceptionally(throwable -> {
                            throwable.printStackTrace();
                            return null;
                        });
                    }
                }
            });
            isRunning = false;
        }).exceptionally(throwable -> {
            throwable.printStackTrace();
            isRunning = false;
            return null;
        });
    }
}
