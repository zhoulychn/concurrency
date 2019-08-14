package com.zhoulychn.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasDemo {

    private static volatile int m = 0;

    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                m++;
                count.incrementAndGet();
            }).start();
        }
        while (Thread.activeCount() > 2) Thread.yield();
        System.out.println(m);
        System.out.println(count);
    }
}
