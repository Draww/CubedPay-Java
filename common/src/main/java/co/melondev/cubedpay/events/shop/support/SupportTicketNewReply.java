package co.melondev.cubedpay.events.shop.support;

import co.melondev.cubedpay.data.Event;
import co.melondev.cubedpay.data.SupportTicket;

/**
 * @author theminecoder
 */
public class SupportTicketNewReply extends SupportTicketEvent {

    public SupportTicketNewReply(Event event) {
        super(event);
    }

    public SupportTicket.Reply getReply() {
        return getTicket().getConversation().get(getTicket().getConversation().size() - 1);
    }
}
