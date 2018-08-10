package co.melondev.cubedpay.data;

public class TransactionPackage {

    private String id;
    private String packageId;
    private String name;
    private UploadedImage icon;
    private int quantity;
    private double price;
    private double salePrice;
    private double saleName;

    public String getId() {
        return id;
    }

    public String getPackageId() {
        return packageId;
    }

    public String getName() {
        return name;
    }

    public UploadedImage getIcon() {
        return icon;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public double getSaleName() {
        return saleName;
    }
}
