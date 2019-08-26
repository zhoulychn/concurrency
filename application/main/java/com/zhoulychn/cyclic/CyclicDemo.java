package com.zhoulychn.cyclic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        new Thread(() -> {
            try {
                cyclicBarrier.await();
                System.out.println(1);
            } catch (InterruptedException e) {

            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                cyclicBarrier.await();
                System.out.println(1);
            } catch (InterruptedException e) {

            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                cyclicBarrier.await();
                System.out.println(1);
            } catch (InterruptedException e) {

            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                cyclicBarrier.await();
                System.out.println(1);
            } catch (InterruptedException e) {

            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                cyclicBarrier.await();
                System.out.println(1);
            } catch (InterruptedException e) {

            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
