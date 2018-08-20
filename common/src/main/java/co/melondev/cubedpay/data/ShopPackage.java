package co.melondev.cubedpay.data;

import com.google.gson.annotations.SerializedName;

public class ShopPackage {

    public class Sale {
        private String name;
        private String old_price;
        private String new_price;

        public String getName() {
            return name;
        }

        public String getOldPrice() {
            return old_price;
        }

        public String getNewPrice() {
            return new_price;
        }
    }

    private String id;
    private String name;
    private UploadedImage icon;
    private String description;
    private String price;
    @SerializedName("is_public")
    private boolean isPublic;
    private Sale sale;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UploadedImage getIcon() {
        return icon;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public Sale getSale() {
        return sale;
    }
}
