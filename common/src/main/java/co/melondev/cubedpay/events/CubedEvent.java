package co.melondev.cubedpay.events;

import co.melondev.cubedpay.data.Event;
import co.melondev.cubedpay.data.common.Date;

public abstract class CubedEvent {

    private Event event;
    private boolean processed = false;

    public CubedEvent(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("Event is null!");
        }

        this.event = event;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public String getEventId() {
        return event.getId();
    }

    public Date getEventDate() {
        return event.getCreated();
    }

    protected Event getEvent() {
        return event;
    }
}
