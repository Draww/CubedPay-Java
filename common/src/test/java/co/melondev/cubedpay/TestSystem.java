package co.melondev.cubedpay;

import co.melondev.cubedpay.data.Item;
import co.melondev.cubedpay.events.CubedEventHandler;
import co.melondev.cubedpay.events.shop.transaction.TransactionCompletedEvent;

public class TestSystem {

    public static class EventTester {

        @CubedEventHandler
        public void onTransactionComplete(TransactionCompletedEvent event) {
            System.out.println("Event ID: " + event.getEventId());
            System.out.println("Purchased: " + event.getTransaction().getId());
            event.setProcessed(true);
        }
    }

    public static void main(String[] args) {
        String appID = "";
        String accessToken = "";
        String shopID = "";

        CubedPayAPI api = new CubedPayAPI(appID, accessToken);
        api.registerListener(new EventTester());
        api.startEvents(shopID);

        api.getShopAPI().getPackages(shopID, 1, 10)
                .thenCompose(packages -> api.getShopAPI().createTransaction(shopID, "user@user.com",
                        new Item(packages.getData().get(0).getId(), 1)))
                .thenAccept(transaction -> System.out.println("Payment Url: https://app.cubedpay.com/checkout/" + transaction.getId()))
                .exceptionally(throwable -> {
                    throwable.printStackTrace();
                    return null;
                });
    }
}
