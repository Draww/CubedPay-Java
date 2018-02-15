package co.melondev.cubedpay.data;

import co.melondev.cubedpay.data.common.Cursor;

import java.util.ArrayList;

/**
 * @author Clutch
 * @since 2/15/2018
 */
public class Permissions {

    private Cursor cursor = new Cursor();
    private ArrayList<Permission> data = new ArrayList<>();

    public Cursor getCursor() {
        return cursor;
    }

    public ArrayList<Permission> getData() {
        return data;
    }
}
