package com.zhoulychn.rw;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWdemo {

    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        readLock.lock();
        readLock.lock();
        readLock.unlock();
        readLock.unlock();
        writeLock.lock();
        writeLock.unlock();
    }
}
