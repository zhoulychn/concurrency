package com.zhoulychn.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class CustomizedAqsLock implements Lock {

    private Synchronizer synchronizer = new Synchronizer();

    private class Synchronizer extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            int state = getState();

            if (state == 0) {
                // cas操作修改state，保证原子性
                if (compareAndSetState(0, arg)) {
                    // 设置当前线程占有资源
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            }
            // 可重入，当前线程再加锁可以直接加，值变大而已
            else if (getExclusiveOwnerThread() == Thread.currentThread()) {
                setState(getState() + arg);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            int state = getState() - arg;
            // 判断锁释放后状态是否为0
            if (state == 0) {
                setExclusiveOwnerThread(null);
                return true;
            }
            setState(state);
            return false;
        }

        public Condition newConditionObject() {
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        synchronizer.tryAcquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        synchronizer.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return synchronizer.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        synchronizer.tryAcquireNanos(1, unit.toNanos(time));
        return false;
    }

    @Override
    public void unlock() {
        synchronizer.release(1);
    }

    @Override
    public Condition newCondition() {
        return synchronizer.newConditionObject();
    }
}
