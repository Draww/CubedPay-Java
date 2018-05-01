package co.melondev.cubedpay.event;

import co.melondev.cubedpay.data.Order;
import co.melondev.cubedpay.data.UserProfile;

public class PurchasedEvent extends CubedEvent {

    private final String id;
    private final Order order;
    private boolean processed = false;

    public PurchasedEvent(String id, Order order) {
        this.id = id;
        this.order = order;
    }

    public String getId() {
        return this.id;
    }

    public UserProfile getProfile() {
        return order.getTransaction().getProfile();
    }

    public Order getOrder() {
        return order;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    @Override
    public String name() {
        return "Purchased Events";
    }
}
