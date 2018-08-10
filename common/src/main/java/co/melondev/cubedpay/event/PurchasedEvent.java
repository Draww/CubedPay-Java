package co.melondev.cubedpay.event;

import co.melondev.cubedpay.data.Transaction;

public class PurchasedEvent extends CubedEvent {

    private final String id;
    private final Transaction transaction;
    private boolean processed = false;

    public PurchasedEvent(String id, Transaction transaction) {
        this.id = id;
        this.transaction = transaction;
    }

    public String getId() {
        return this.id;
    }

    public Transaction getTransaction() {
        return transaction;
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
