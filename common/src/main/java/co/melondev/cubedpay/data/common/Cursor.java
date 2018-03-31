package co.melondev.cubedpay.data.common;

public class Cursor {

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
}
