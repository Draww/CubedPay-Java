package co.melondev.cubedpay.data;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Map;

public class ShopSidebarModule {

    public enum Type {
        HTML,
        PROMOTED,
        CART,
        ACCOUNT,
        TEXT;

        public static Type findById(String id) {
            return Arrays.stream(values()).filter(status -> status.name().equalsIgnoreCase(id))
                    .findFirst().orElse(null);
        }
    }

    public enum Side {
        LEFT,
        RIGHT;

        public static Side findById(String id) {
            return Arrays.stream(values()).filter(status -> status.name().equalsIgnoreCase(id))
                    .findFirst().orElse(null);
        }
    }

    private String id;
    private Side side;
    private Type type;
    private Map<String, Object> settings;
    @SerializedName("public")
    private boolean isPublic;
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
