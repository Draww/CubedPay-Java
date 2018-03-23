package co.melondev.cubedpay.data;

import co.melondev.cubedpay.data.common.Cursor;

import java.util.ArrayList;

public class Games {

    private Cursor cursor = new Cursor();
    private ArrayList<Game> data = new ArrayList<>();

    public Cursor getCursor() {
        return cursor;
    }

    public ArrayList<Game> getData() {
        return data;
    }
}
