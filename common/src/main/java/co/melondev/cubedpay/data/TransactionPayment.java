package co.melondev.cubedpay.data;

public class TransactionPayment {

    private String id;
    private String gateway;
    private double charged;
    private String created;
    private String compelted;

    public String getId() {
        return id;
    }

    public String getGateway() {
        return gateway;
    }

    public double getCharged() {
        return charged;
    }

    public String getCreated() {
        return created;
    }

    public String getCompelted() {
        return compelted;
    }
}
