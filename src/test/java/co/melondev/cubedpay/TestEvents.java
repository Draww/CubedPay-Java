package co.melondev.cubedpay;

import co.melondev.cubedpay.event.PaymentHandler;
import co.melondev.cubedpay.event.PurchasedEvent;

import java.util.UUID;

public class TestEvents {

    public static class EventTester {

        @PaymentHandler
        public void testEvents(PurchasedEvent event) {
            System.out.println("1: " + event.uuid());
        }

        @PaymentHandler
        public void testEvents2(PurchasedEvent event) {
            System.out.println("2: " + event.name());
        }
    }

    public static void main(String[] args) {
        CubedPay.addEventHandler(new EventTester());
        CubedPay.callEvent(new PurchasedEvent(UUID.randomUUID(), 0));
    }
}
