package co.melondev.cubedpay.data;

public class Item {

    private String id = "";
    private String name = "";
    private UploadedImage icon = new UploadedImage();
    private String description = "";
    private Double price = 0.0;
    private Integer quantity = 0;
    private String is_public = "";
    private String is_test = "";

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

    public UploadedImage getIcon() {
        return icon;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String isPublic() {
        return is_public;
    }

    public String isTest() {
        return is_test;
    }

    @Override
    public String toString() {
        return "Item [" +
                "id=" + id +
                ", name=" + name +
                ", icon=" + icon +
                ", description=" + description +
                ", price=" + price +
                ", quantity=" + quantity +
                ", is_public=" + is_public +
                ", is_test=" + is_test +
                "]";
    }
}
