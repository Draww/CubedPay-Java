package co.melondev.cubedpay.data.common;

import java.util.List;

public class Cursor<T> {

    public class CursorInfo {
        private int current_page = 0;
        private int total_pages = 0;
        private int total_items = 0;
        private int per_page = 0;

        public int getCurrentPage() {
            return current_page;
        }

        public int getTotalPages() {
            return total_pages;
        }

        public int getTotalItems() {
            return total_items;
        }

        public int getPerPage() {
            return per_page;
        }

        @Override
        public String toString() {
            return "CursorInfo{" +
                    "current_page=" + current_page +
                    ", total_pages=" + total_pages +
                    ", total_items=" + total_items +
                    ", per_page=" + per_page +
                    '}';
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

    @Override
    public String toString() {
        return "Cursor{" +
                "cursor=" + cursor +
                ", data=" + data +
                '}';
    }
}
