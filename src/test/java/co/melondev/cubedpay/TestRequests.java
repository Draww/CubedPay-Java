package co.melondev.cubedpay;

import co.melondev.cubedpay.api.objects.BaseBadRequest;
import co.melondev.cubedpay.api.objects.BaseReturn;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestRequests {

    private static CubedPay cubedPay = new CubedPay();

    private static final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SSS");

    public static void main(String[] args) {
        print("Before 1");
        cubedPay.getRequests().get("http://api.test.cubedpay.com/", response -> {
            String message = response.getResponseMessage();
            if (!message.isEmpty()) {
                BaseReturn baseReturn = cubedPay.getJackson().getReturn(message);
                if (!baseReturn.isSuccess()) {
                    BaseBadRequest baseBadRequest = cubedPay.getJackson().getBadRequest(message);
                    print(baseBadRequest.getReturn().getMessage());
                }
            }
            if (!response.getExceptionMessage().isEmpty()) print("Error: " + response.getExceptionMessage());
        });
        print("Before 2");
    }

    private static void print(String message) {
        System.out.println(getCurrentTime() + " > " + message);
    }

    private static String getCurrentTime() {
        Date date = new Date();
        return dateFormat.format(date);
    }
}
