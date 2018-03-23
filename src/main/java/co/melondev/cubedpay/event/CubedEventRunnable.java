package co.melondev.cubedpay.event;

import co.melondev.cubedpay.CubedPayAPI;
import co.melondev.cubedpay.data.EventData;

public class CubedEventRunnable implements Runnable {

    private final CubedPayAPI cubedPayAPI;
    private boolean isRunning = false;
    private String shopID;

    public CubedEventRunnable(CubedPayAPI cubedPayAPI, String shopID) {
        this.cubedPayAPI = cubedPayAPI;
        this.shopID = shopID;
    }

    @Override
    public void run() {
        if (isRunning) return;
        isRunning = true;
        cubedPayAPI.getEvent(shopID).thenAccept(event -> {
            for (EventData data : event.getData()) {
                cubedPayAPI.emitEvent(new PurchasedEvent(data.getId(), data.getObj().getObj()));
                cubedPayAPI.acceptEvent(shopID, data.getId());
            }
            isRunning = false;
        });
    }
}
