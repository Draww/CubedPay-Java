package co.melondev.cubedpay;

import co.melondev.cubedpay.api.objects.BaseReturnObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestRequests {

    private static CubedPay cubedPay = new CubedPay();

    private static final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SSS");

    public static void main(String[] args) {
        print("Before 1");
        cubedPay.getRequests().get("http://api.test.cubedpay.com/", response -> {
            print("Response2: " + response.getResponseCode());
            if (!response.getResponseMessage().isEmpty()) {
                BaseReturnObject test = cubedPay.getJackson().getBaseReturn(response.getResponseMessage());
                print("Success: " + test. didSucceed());
                print("Return code: " + test. getReturn().getCode());
                print("Return message: " + test. getReturn().getMessage());
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
