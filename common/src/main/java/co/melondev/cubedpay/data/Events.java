package co.melondev.cubedpay.data;

import java.util.ArrayList;
import java.util.List;

public class Events {

    private int items = 0;
    private List<Event> data = new ArrayList<>();

    public int getItems() {
        return items;
    }

    public List<Event> getData() {
        return data;
    }
}
