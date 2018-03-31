package co.melondev.cubedpay.data;

public class EventObject {

    private String type = "";
    private Order obj = new Order();

    public String getType() {
        return type;
    }

    public Order getObj() {
        return obj;
    }
}
