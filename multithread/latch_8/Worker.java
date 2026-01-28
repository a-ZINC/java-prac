package multithread.latch_8;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class Worker implements Callable<String>  {

    private CountDownLatch latch;
    int i = 0;

    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }
    
    @Override
    public String call() throws Exception {
        try {
            System.out.println("Thread: " + Thread.currentThread().getName());
            Thread.sleep(2000);
            return Thread.currentThread().getName() + ": " + Integer.toString(i);
        } finally {
            latch.countDown();
        }
    }

    public void setI(int i) {
        this.i = i;
    }

    
}
