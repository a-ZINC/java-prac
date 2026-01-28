package multithread.latch_8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Service {
    private static ExecutorService executorService = null;

    private Service() {
        executorService = Executors.newFixedThreadPool(5);
    }

    public static ExecutorService getExecutorService() {
        if (executorService == null) {
            new Service();
        }
        return executorService;
    }
    
}
