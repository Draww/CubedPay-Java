package co.melondev.cubedpay.event;

import co.melondev.cubedpay.data.OrderObject;

public class PurchasedEvent extends CubedEvent {

    private final int id;
    private final OrderObject order;

    public PurchasedEvent(int id, OrderObject order) {
        this.id = id;
        this.order = order;
    }

    public int getId() {
        return this.id;
    }

    public OrderObject getOrder() {
        return order;
    }

    @Override
    public String name() {
        return "Purchased Event";
    }
}
