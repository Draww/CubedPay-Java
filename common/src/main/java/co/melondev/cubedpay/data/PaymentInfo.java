package co.melondev.cubedpay.data;

public class PaymentInfo {

    private double price = 0;

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "PaymentInfo{" +
                "price=" + price +
                '}';
    }
}
