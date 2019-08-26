package com.zhoulychn.sem;

import java.util.concurrent.Semaphore;

public class SemDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10);
        System.out.println(semaphore.availablePermits());
        int i = semaphore.drainPermits();
        System.out.println(semaphore.availablePermits());
    }
}
