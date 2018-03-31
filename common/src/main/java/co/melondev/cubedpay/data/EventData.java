package co.melondev.cubedpay.data;

import co.melondev.cubedpay.data.common.Date;

public class EventData {

    private int id = 0;
    private EventObject obj = new EventObject();
    private Date accepted = new Date();

    public int getId() {
        return id;
    }

    public EventObject getObj() {
        return obj;
    }

    public Date getAccepted() {
        return accepted;
    }
}
