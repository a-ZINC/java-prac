package multithread.lock_4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance;
    Lock lock = new ReentrantLock();
    public BankAccount(int balance) {
        this.balance = balance;
    }
    public int getBalance() {
        return balance;
    }
    public boolean withdraw(int balance) {
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    if (this.balance - balance > 0) {
                        this.balance -= balance;
                        System.out.println("balance withraw done: " + Thread.currentThread().getName());
                        Thread.sleep(10000);
                        return true;
                    } else {
                        System.out.println("balance withraw rejected: " + Thread.currentThread().getName());
                        return false;
                    }
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + 
                                  " - Could not acquire lock. Try again later.");
                return false;
            }
        } catch(Exception e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }
}
