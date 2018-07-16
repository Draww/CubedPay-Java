package co.melondev.cubedpay.event;

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
        shopAPI.getEvents(shopID).thenAccept(event -> {
            event.getData().forEach(data -> {
                //TODO Restore this after completing the event class.
//                if (data.getObj() != null && data.getObj().getType() != null && data.getObj().getType().equalsIgnoreCase("order")) {
//                    if (cubedPayAPI.emitEvent(new PurchasedEvent(data.getId(), data.getObj().getObj()))) {
//                        shopAPI.acceptEvent(shopID, data.getId()).exceptionally(throwable -> {
//                            throwable.printStackTrace();
//                            return null;
//                        });
//                    }
//                }
            });
            isRunning = false;
        }).exceptionally(throwable -> {
            throwable.printStackTrace();
            isRunning = false;
            return null;
        });
    }
}
