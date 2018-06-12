package co.melondev.cubedpay.data;

import co.melondev.cubedpay.data.common.Date;

public class Event {

    private String id = "";
    private EventObject obj = new EventObject();
    private Date accepted = new Date();

    public String getId() {
        return id;
    }

    public EventObject getObj() {
        return obj;
    }

    public Date getAccepted() {
        return accepted;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", obj=" + obj +
                ", accepted=" + accepted +
                '}';
    }
}
