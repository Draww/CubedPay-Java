package co.melondev.cubedpay.data;

public class UploadedImage {

    private String id = "";
    private String url = "";

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "UploadedImage{" +
                "url='" + url + '\'' +
                '}';
    }
}
