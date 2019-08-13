package com.zhoulychn.singleton;

// 调用时，加载内部类进行初始化
public class InnerClassSingleton {

    private InnerClassSingleton() {
    }

    private static class Holder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return Holder.instance;
    }
}
