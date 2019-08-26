package com.zhoulychn.syn;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        synchronized (o){
            o.wait();
            o.notifyAll();
        }
    }
}
