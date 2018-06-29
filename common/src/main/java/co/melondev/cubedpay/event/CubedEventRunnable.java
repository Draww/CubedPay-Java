package co.melondev.cubedpay.event;

import co.melondev.cubedpay.CubedPayAPI;

public class CubedEventRunnable implements Runnable {

    private final CubedPayAPI cubedPayAPI;
    private final String shopID;

    private boolean isRunning = false;

    public CubedEventRunnable(CubedPayAPI cubedPayAPI, String shopID) {
        this.cubedPayAPI = cubedPayAPI;
        this.shopID = shopID;
    }

    @Override
    public void run() {
        if (isRunning) return;
        isRunning = true;
        cubedPayAPI.getEvents(shopID).thenAccept(event -> {
            event.getData().forEach(data -> {
                if (data.getObj() != null && data.getObj().getType() != null && data.getObj().getType().equalsIgnoreCase("order")) {
                    if (cubedPayAPI.emitEvent(new PurchasedEvent(data.getId(), data.getObj().getObj()))) {
                        cubedPayAPI.acceptEvent(shopID, data.getId()).exceptionally(throwable -> {
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
