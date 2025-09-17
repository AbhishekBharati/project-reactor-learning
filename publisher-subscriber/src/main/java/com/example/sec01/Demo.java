package com.example.sec01;

import com.example.sec01.publisher.PublisherImpl;
import com.example.sec01.publisher.SubscriptionImpl;
import com.example.sec01.subscriber.SubscriberImpl;

import java.time.Duration;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        demo1();
//        demo2();
        demo3();
    }

    private static void demo1(){
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(13);
    }

    private static void demo2() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
    }

    private static void demo3() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
    }
}
