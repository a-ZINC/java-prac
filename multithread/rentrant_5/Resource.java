package multithread.rentrant_5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
    private Lock lock;
    public Resource() {
        this.lock = new ReentrantLock(true);
    }

    public void outerResource() {
        lock.lock();
        try {
            System.out.println("Before outerResource");
            innerResource();
            Thread.sleep(3000);
            System.out.println("After outerResource");
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
         finally {
            lock.unlock();
        }
    }

    public void innerResource() {
        lock.lock();
        try {
            System.out.println("Before innerResource");
            Thread.sleep(1000);
            System.out.println("After innerResource");

        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
         finally {
            lock.unlock();
        }
    }
}
