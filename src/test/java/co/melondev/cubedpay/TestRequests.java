package co.melondev.cubedpay;

import co.melondev.cubedpay.api.UrlRequests;

public class TestRequests {

    private static UrlRequests requests = new UrlRequests();
    private static final String TEST_URL = "https://jsonplaceholder.typicode.com/posts/1/";

    public static void main(String[] args) {
        System.out.println("Before 1");
        requests.get(TEST_URL, response -> {
            System.out.println("Response (" + response.getResponseCode() + "): ");
            if (!response.getResponseMessage().isEmpty()) System.out.println(response.getResponseMessage());
            if (!response.getExceptionMessage().isEmpty()) System.out.println("Error: " + response.getExceptionMessage());
        });
        System.out.println("Before 2");
    }
}
