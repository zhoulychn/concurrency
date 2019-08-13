package com.zhoulychn.singleton;

// 类加载的过程中创建对象，线程安全
public class HungerSingleton {

    private HungerSingleton() {
    }

    private static HungerSingleton instance = new HungerSingleton();

    public static HungerSingleton getInstance() {
        return instance;
    }
}
