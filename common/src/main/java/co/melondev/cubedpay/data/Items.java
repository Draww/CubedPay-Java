package co.melondev.cubedpay.data;

public class Items {

    private final Item[] items;

    public Items(Item... items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }
}
