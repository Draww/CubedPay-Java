package co.melondev.cubedpay;

import co.melondev.cubedpay.api.UrlRequests;

public class CubedPay {

    private UrlRequests requests = new UrlRequests();
    private JacksonUtils jacksonUtils = new JacksonUtils();

    protected UrlRequests getRequests() {
        return requests;
    }

    protected JacksonUtils getJackson() {
        return jacksonUtils;
    }
}
