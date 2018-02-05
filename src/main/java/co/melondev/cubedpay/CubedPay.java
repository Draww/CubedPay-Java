package co.melondev.cubedpay;

import co.melondev.cubedpay.api.UrlRequests;
import co.melondev.cubedpay.event.AnnotationProcessor;
import co.melondev.cubedpay.event.CubedEvent;

public class CubedPay {

    private UrlRequests requests = new UrlRequests();
    private JacksonUtils jacksonUtils = new JacksonUtils();

    protected UrlRequests getRequests() {
        return requests;
    }

    protected JacksonUtils getJackson() {
        return jacksonUtils;
    }

    public static void addEventHandler(Object eventClass) {
        AnnotationProcessor.processAnnotation(eventClass);
    }

    public static void callEvent(CubedEvent event) {
        AnnotationProcessor.emitEvent(event);
    }
}
