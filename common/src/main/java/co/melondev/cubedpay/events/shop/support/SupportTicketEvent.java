package co.melondev.cubedpay.events.shop.support;

import co.melondev.cubedpay.data.Event;
import co.melondev.cubedpay.data.SupportTicket;
import co.melondev.cubedpay.events.CubedEvent;

/**
 * @author theminecoder
 */
public class SupportTicketEvent extends CubedEvent {

    public SupportTicketEvent(Event event) {
        super(event);
    }

    public SupportTicket getTicket() {
        return getEvent().getObj().getObject(SupportTicket.class);
    }
}
