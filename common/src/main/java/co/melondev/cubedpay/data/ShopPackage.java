package co.melondev.cubedpay.data;

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
    private boolean is_public;
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
        return is_public;
    }

    public Sale getSale() {
        return sale;
    }
}
