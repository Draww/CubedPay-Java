package co.melondev.cubedpay.events.shop.transaction;

import co.melondev.cubedpay.data.Event;
import co.melondev.cubedpay.data.Transaction;
import co.melondev.cubedpay.events.CubedEvent;

/**
 * @author theminecoder
 */
public class TransactionEvent extends CubedEvent {

    public TransactionEvent(Event event) {
        super(event);
    }

    public Transaction getTransaction() {
        return getEvent().getObj().getObject(Transaction.class);
    }

}
