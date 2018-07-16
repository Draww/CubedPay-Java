package co.melondev.cubedpay.data.common;

import java.util.List;

public class Cursor<T> {

    public class CursorInfo {
        private String current_page = "";
        private int total_pages = 0;
        private int total_items = 0;
        private String per_page = "";

        public String getCurrentPage() {
            return current_page;
        }

        public int getTotalPages() {
            return total_pages;
        }

        public int getTotalItems() {
            return total_items;
        }

        public String getPerPage() {
            return per_page;
        }
    }

    private CursorInfo cursor;

    private List<T> data;

    public CursorInfo getCursor() {
        return cursor;
    }

    public List<T> getData() {
        return data;
    }
}
