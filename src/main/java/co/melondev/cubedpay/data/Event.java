package co.melondev.cubedpay.data;

import java.util.ArrayList;
import java.util.List;

public class Event {

    private int items = 0;
    private List<EventData> data = new ArrayList<>();

    public int getItems() {
        return items;
    }

    public List<EventData> getData() {
        return data;
    }
}
