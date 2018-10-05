package co.melondev.cubedpay.data;

import java.util.Arrays;

public class Transaction {

    public enum Status {
        PENDING,
        ABANDONED,
        COMPLETED;

        public static Status findById(String id) {
            return Arrays.stream(values()).filter(status -> status.name().equalsIgnoreCase(id))
                    .findFirst().orElse(null);
        }
    }

    private String id;
    private Status status;
    private PublicUser user;
    private UserProfile profile;
    private PublicShop shop;
    private ShopDiscount discount;
    private String amount;
    private String created;
    private String completed;

    public String getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public PublicUser getUser() {
        return user;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public PublicShop getShop() {
        return shop;
    }

    public ShopDiscount getDiscount() {
        return discount;
    }

    public String getAmount() {
        return amount;
    }

    public String getCreated() {
        return created;
    }

    public String getCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", status=" + status +
                ", user=" + user +
                ", shop=" + shop +
                ", discount=" + discount +
                ", amount='" + amount + '\'' +
                ", profile='" + profile + '\'' +
                ", created='" + created + '\'' +
                ", completed='" + completed + '\'' +
                '}';
    }
}
