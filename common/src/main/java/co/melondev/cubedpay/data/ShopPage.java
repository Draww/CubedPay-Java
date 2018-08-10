package co.melondev.cubedpay.data;

public class ShopPage {

    public enum Type {
        BASIC
    }

    public enum Display {
        GRID
    }

    private String id;
    private String name;
    private String description;
    private boolean isPublic; //TODO Fix name from api (java keywords pls)
    private Type type;
    private Display display;
    private int order;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public Type getType() {
        return type;
    }

    public Display getDisplay() {
        return display;
    }

    public int getOrder() {
        return order;
    }
}
