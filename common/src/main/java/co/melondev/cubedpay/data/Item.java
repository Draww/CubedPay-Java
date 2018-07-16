package co.melondev.cubedpay.data;

public class Item {

    private String id = "";
    private Integer quantity = 0;

    public Item(String id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

}
