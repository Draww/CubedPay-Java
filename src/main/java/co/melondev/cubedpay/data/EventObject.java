package co.melondev.cubedpay.data;

public class EventObject {

    private String type = "";
    private OrderObject obj = new OrderObject();

    public String getType() {
        return type;
    }

    public OrderObject getObj() {
        return obj;
    }
}
