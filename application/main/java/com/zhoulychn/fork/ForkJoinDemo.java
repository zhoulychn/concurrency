package com.zhoulychn.fork;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinDemo {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();


        pool.submit(() -> {
            System.out.println(1);
        });
    }
}
