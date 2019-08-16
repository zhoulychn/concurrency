package com.zhoulychn.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {

    Lock lock = new CustomizedAqsLock();

    private int m = 0;

    public int next() {
        lock.lock();
        try {
            return m++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        for (int i = 0; i < 20000; i++) {
            new Thread(test::next).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(test.m);
    }
}
