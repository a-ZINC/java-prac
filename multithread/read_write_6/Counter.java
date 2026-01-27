package multithread.read_write_6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Counter {
    private int count = 0;
    private ReadWriteLock rwlock;
    private Lock writeLock;
    private Lock readLock;

    public Counter() {
        rwlock = new ReentrantReadWriteLock();
        writeLock = rwlock.writeLock();
        readLock = rwlock.readLock();
    }

    public int getCounter() {
        try {
            if (readLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                     System.out.println(Thread.currentThread().getName() + 
                              " reading: " + count);
                return count;
                } finally {
                    readLock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + 
                              " reading blocked: " + count);
                return count;
            }
        } catch(Exception e) {
            Thread.currentThread().interrupt();
            return count;
        }
    }

    public int writeCounter() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + 
                              " writing: " + count);
            Thread.sleep(500);
            return count++;
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            return count;
        }
         finally {
            writeLock.unlock();
        }
    }

}
