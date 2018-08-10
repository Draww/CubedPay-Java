package co.melondev.cubedpay.data;

import java.util.Date;

public class TransactionPayment {

    private String id;
    private String gateway;
    private double charged;
    private Date created;
    private Date compelted;

    public String getId() {
        return id;
    }

    public String getGateway() {
        return gateway;
    }

    public double getCharged() {
        return charged;
    }

    public Date getCreated() {
        return created;
    }

    public Date getCompelted() {
        return compelted;
    }
}
