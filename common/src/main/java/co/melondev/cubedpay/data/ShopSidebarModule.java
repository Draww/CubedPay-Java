package co.melondev.cubedpay.data;

import java.util.Map;

/**
 * @author theminecoder
 */
public class ShopSidebarModule {

    public enum Type {
        HTML,
        PROMOTED,
        CART,
        ACCOUNT
    }

    public enum Side {
        LEFT,
        RIGHT
    }

    private String id;
    private Side side;
    private Type type;
    private Map<String, Object> settings;
    private boolean isPublic; //todo fix
    private int order;

    public String getId() {
        return id;
    }

    public Side getSide() {
        return side;
    }

    public Type getType() {
        return type;
    }

    public Map<String, Object> getSettings() {
        return settings;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public int getOrder() {
        return order;
    }
}
