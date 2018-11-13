package co.melondev.cubedpay.data;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class ShopPage {

    public class Meta {

        private String parent; // returns "false" if it does not have a parent page and the page id if it does
        private boolean label;
        private boolean external;
        private String url;

        public Meta(String parent, boolean label, boolean external, String url) {
            this.parent = parent == null || parent.isEmpty() ? "false" : parent;
            this.label = label;
            this.external = external;
            this.url = url;
        }

        public String getParent() {
            return parent;
        }

        public boolean hasLabel() {
            return label;
        }

        public boolean isExternal() {
            return external;
        }

        public String getUrl() {
            return url;
        }

    }

    public enum Type {
        BASIC;

        public static Type findById(String id) {
            return Arrays.stream(values()).filter(status -> status.name().equalsIgnoreCase(id))
                    .findFirst().orElse(null);
        }
    }

    public enum Display {
        GRID,
        LIST;

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
    private String icon;
    private Meta meta;

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

    public String getIcon() {
        return icon;
    }

    public Meta getMeta() {
        return meta;
    }

}
