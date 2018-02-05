package co.melondev.cubedpay.event;

import java.util.UUID;

public class PurchasedEvent extends CubedEvent {

    private final UUID uuid;
    private final int id;

    public PurchasedEvent(UUID uuid, int id) {
        this.uuid = uuid;
        this.id = id;
    }

    public UUID uuid() {
        return this.uuid;
    }

    public int id() {
        return this.id;
    }

    @Override
    public String name() {
        return "Purchased Event";
    }
}
