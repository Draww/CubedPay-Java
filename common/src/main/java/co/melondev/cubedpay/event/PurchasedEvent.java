package co.melondev.cubedpay.event;

import co.melondev.cubedpay.data.Order;

public class PurchasedEvent extends CubedEvent {

    private final int id;
    private final Order order;

    public PurchasedEvent(int id, Order order) {
        this.id = id;
        this.order = order;
    }

    public int getId() {
        return this.id;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String name() {
        return "Purchased Event";
    }
}
