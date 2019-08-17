package com.zhoulychn.singleton;

// double-check模式，保证线程安全
public class LazySingletonSafely {

    private LazySingletonSafely() {
    }

    private static volatile LazySingletonSafely instance;

    // 多线程调用有同步问题，instance可能被创建多次
    public static LazySingletonSafely getInstance() {

        // 判断实例为null时，使用同步代码创建对象，
        if (instance == null) {
            synchronized (LazySingletonSafely.class) {

                //为什么还要判断呢，因为可能多个线程同时进入了if条件内，等其他的同步代码执行完成就可以再创建了
                if (instance == null) instance = new LazySingletonSafely();
            }
        }
        return instance;
    }
}
