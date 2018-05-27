package co.melondev.cubedpay.data;

import co.melondev.cubedpay.data.common.Cursor;

import java.util.List;

public class Shops {

    private Cursor cursor;

    private List<Shop> data;

    public Cursor getCursor() {
        return cursor;
    }

    public List<Shop> getData() {
        return data;
    }
}
