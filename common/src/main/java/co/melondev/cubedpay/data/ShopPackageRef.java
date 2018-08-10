package co.melondev.cubedpay.data;

public class ShopPackageRef {

    public enum Type {
        ID
    }

    private String id;
    private Type type;
    private ShopPackage shopPackage;

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public ShopPackage getShopPackage() {
        return shopPackage;
    }
}
