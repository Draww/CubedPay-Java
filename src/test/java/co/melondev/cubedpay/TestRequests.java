package co.melondev.cubedpay;

import co.melondev.cubedpay.api.UrlRequests;
import co.melondev.cubedpay.api.objects.BaseObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestRequests {

    private static UrlRequests requests = new UrlRequests();
    private static DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SSS");

    private static final String TEST_URL = "http://api.test.cubedpay.com/";

    public static void main(String[] args) {
        print("Before 1");
        requests.get(TEST_URL, response -> {
            print("Response: " + response.getResponseCode());
            if (!response.getResponseMessage().isEmpty()) {
                // NOTE: With some tests I don't think object mapper will be the fastest long term.
                // Storing a ObjectReader is probably better. Will need more tests.
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    BaseObject test = objectMapper.readValue(response.getResponseMessage(), BaseObject.class);
                    print("Success: " + test. didSucceed());
                    print("Return code: " + test. getReturn().getCode());
                    print("Return message: " + test. getReturn().getMessage());
                } catch (IOException e) {
                    print("Test broke send help!");
                    e.printStackTrace();
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
