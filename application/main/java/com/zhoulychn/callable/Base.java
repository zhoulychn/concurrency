package com.zhoulychn.callable;

import java.util.concurrent.*;

public class Base {

    static class CallableImpl implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "lewis";
        }
    }

    static class RunableImpl implements Runnable {

        @Override
        public void run() {
            System.out.println("run");
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new CallableImpl());

        FutureTask<Boolean> task2 = new FutureTask<>(new RunableImpl(), true);
        new Thread(task).start();
        String s = task.get();
        System.out.println(s);
        Future<?> submit = Executors.newSingleThreadExecutor().submit(new RunableImpl());
    }
}
