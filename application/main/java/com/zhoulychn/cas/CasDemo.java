package com.zhoulychn.cas;

import java.util.concurrent.locks.ReentrantLock;

public class CasDemo {

    private ReentrantLock lock = new ReentrantLock();

    private Thread t1 = new Thread(() -> {
        lock.lock();
        System.out.println("t1");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        lock.unlock();
    });

    private Thread t2 = new Thread(() -> {
        lock.lock();
        System.out.println("t2");
        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    });

    private Thread t3 = new Thread(() -> {
        lock.lock();
        System.out.println("t3");
        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    });

    private Thread t4 = new Thread(() -> {
        lock.lock();
        System.out.println("t4");
        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    });

    private Thread t5 = new Thread(() -> {
        lock.lock();
        System.out.println("t5");
        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    });

    public static void main(String[] args) throws InterruptedException {
        CasDemo casDemo = new CasDemo();

        long id = Thread.currentThread().getId();
        System.out.println(id);

        System.out.println(casDemo.t1.getId());
        System.out.println(casDemo.t2.getId());

        casDemo.t1.start();
//        casDemo.t2.start();
//        casDemo.t3.start();
//        casDemo.t4.start();
        casDemo.t5.start();
    }
}
