package co.melondev.cubedpay.events.transaction;

import co.melondev.cubedpay.data.Event;

public class TransactionCompletedEvent extends TransactionEvent {

    public TransactionCompletedEvent(Event event) {
        super(event);
    }

}
