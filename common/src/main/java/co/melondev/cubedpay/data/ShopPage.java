package co.melondev.cubedpay.data;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class ShopPage {

    public enum Type {
        BASIC;

        public static Type findById(String id) {
            return Arrays.stream(values()).filter(status -> status.name().equalsIgnoreCase(id))
                    .findFirst().orElse(null);
        }
    }

    public enum Display {
        GRID;

        public static Display findById(String id) {
            return Arrays.stream(values()).filter(status -> status.name().equalsIgnoreCase(id))
                    .findFirst().orElse(null);
        }
    }

    private String id;
    private String name;
    private String description;
    @SerializedName("public")
    private boolean isPublic;
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
