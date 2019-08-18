package com.zhoulychn.executor;



import java.util.concurrent.*;

public class Application {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(() -> {
            Thread.sleep(5000);
            return "true";
        });
        String o = future.get();
        System.out.println(0);
    }
}
