package com.zhoulychn.singleton;

import java.util.HashSet;

public class Test {

    private static HashSet<Object> set = new HashSet<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                set.add(LazySingletonSafely.getInstance());
            }).start();
        }
        Thread.sleep(1000L);
        System.out.println(set.size());
    }
}
