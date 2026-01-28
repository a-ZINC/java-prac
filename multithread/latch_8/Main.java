package multithread.latch_8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(args[0]);
        ExecutorService executorService = Service.getExecutorService();
        List<Future<String>> futures = new ArrayList<>(n);
        CountDownLatch cdl = new CountDownLatch(n);
        Worker task = new Worker(cdl);
        for (int i=0; i<n; i++) {
            futures.add(executorService.submit(task));
        }
        System.out.println("Waiting...");
        cdl.await();
        System.out.println("All done...");
        
        for (Future<String> f : futures) {
            System.out.println("done: " + f.get());
        }

        executorService.shutdown();
        
    }
}
