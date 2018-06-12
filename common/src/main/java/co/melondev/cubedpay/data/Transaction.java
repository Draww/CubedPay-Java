package co.melondev.cubedpay.data;

import co.melondev.cubedpay.data.common.Date;

public class Transaction {

    private String id = "";
    private Gateway gateway = new Gateway();
    private Payment payment = new Payment();
    private User user = new User();
    private Boolean refund = false;
    private Boolean dispute = false;
    private boolean is_complete = false;
    private Date created = new Date();

    public String getId() {
        return id;
    }

    public Gateway getGateway() {
        return gateway;
    }

    public Payment getPayment() {
        return payment;
    }

    public User getUser() {
        return user;
    }

    public Boolean getRefund() {
        return refund;
    }

    public Boolean getDispute() {
        return dispute;
    }

    public boolean isComplete() {
        return is_complete;
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Transaction [" +
                "id=" + id +
                ", gateway=" + gateway +
                ", payment=" + payment +
                ", user=" + user +
                ", refund=" + refund +
                ", dispute=" + dispute +
                ", is_complete=" + is_complete +
                ", created=" + created +
                "]";
    }
}
