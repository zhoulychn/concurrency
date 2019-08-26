package com.zhoulychn.list;

import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CowList {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(1);
        }
        ListIterator<Integer> iterator = list.listIterator();

        new Thread(() -> {
            while (iterator.hasNext()) {
                iterator.next();
                System.out.println(iterator);
            }

        }).start();
        new Thread(() -> {
            list.remove(0);
        }).start();

    }
}
