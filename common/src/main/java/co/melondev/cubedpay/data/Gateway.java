package co.melondev.cubedpay.data;

public class Gateway {

    private String id = "";
    private String type = "";
    private String public_key = "";
    private String stripe_id = "";

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getPublicKey() {
        return public_key;
    }

    public String getStripeId() {
        return stripe_id;
    }
}
