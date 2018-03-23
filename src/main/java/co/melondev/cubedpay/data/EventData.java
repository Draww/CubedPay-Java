package co.melondev.cubedpay.data;

public class EventData {

    private int id = 0;
    private EventObject obj = new EventObject();
    private String accepted = "";

    public int getId() {
        return id;
    }

    public EventObject getObj() {
        return obj;
    }

    public String getAccepted() {
        return accepted;
    }
}
