package co.melondev.cubedpay.data;

public class ShopPackage {

    public class Sale {
        private String name;
        private String oldPrice;
        private String newPrice;

        public String getName() {
            return name;
        }

        public String getOldPrice() {
            return oldPrice;
        }

        public String getNewPrice() {
            return newPrice;
        }
    }

    private String id;
    private String name;
    private UploadedImage icon;
    private String descrption;
    private String price;
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

    public String getDescrption() {
        return descrption;
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
