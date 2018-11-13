package co.melondev.cubedpay.data;

public class ShopTemplateMeta {

    public class Data {

        private String header;

        public String getHeaderAssetId() {
            return header;
        }

    }

    private String id;
    private Data data;
    private String template;

    public String getId() {
        return id;
    }

    public Data getData() {
        return data;
    }

    public String getTemplate() {
        return template;
    }

}