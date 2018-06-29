package co.melondev.cubedpay.data;

import co.melondev.cubedpay.data.common.Cursor;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private Cursor cursor = new Cursor();
    private List<Order> data = new ArrayList<>();

    public Cursor getCursor() {
        return cursor;
    }

    public List<Order> getData() {
        return data;
    }
}
