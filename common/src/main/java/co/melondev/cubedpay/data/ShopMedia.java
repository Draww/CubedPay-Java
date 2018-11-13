package co.melondev.cubedpay.data;

import com.google.gson.annotations.SerializedName;

public class ShopMedia {

    public class Meta {

        private String name;
        private String type;
        private long size;
        private long created;

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public long getSize() {
            return size;
        }

        public long getCreated() {
            return created;
        }

    }

    private String id;
    private String url;
    private Meta meta;
    @SerializedName("private")
    private boolean isPrivate;

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Meta getMeta() {
        return meta;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}