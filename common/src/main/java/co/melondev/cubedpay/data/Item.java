package co.melondev.cubedpay.data;

public class Item {

    private String id;
    private String name;
    private Double price;
    private Integer quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(String id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Item [" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", quantity=" + quantity +
                "]";
    }
}
