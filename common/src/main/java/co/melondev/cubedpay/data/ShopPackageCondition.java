package co.melondev.cubedpay.data;

import java.util.Arrays;

public class ShopPackageCondition {

    public enum Type {
        BROUGHT_ANY,
        BROUGHT;

        public static Type findById(String id) {
            return Arrays.stream(values()).filter(type -> type.name().equalsIgnoreCase(id))
                    .findFirst().orElse(null);
        }
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