package co.melondev.cubedpay.data;

public class ShopPackageCondition {

    public enum Type {

        BROUGHT_ANY, BROUGHT

    }

    private String id;
    private Type type;
    private String data;

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public String getData() {
        return data;
    }

}