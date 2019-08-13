package com.zhoulychn.singleton;

// 多线程调用有同步问题，instance可能被创建多次
public class LazySingleton {

    private LazySingleton() {
    }

    private static LazySingleton instance;

    public static LazySingleton getInstance() {
        if (instance == null) instance = new LazySingleton();
        return instance;
    }
}
