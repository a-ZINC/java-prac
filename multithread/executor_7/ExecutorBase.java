package multithread.executor_7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorBase {
    private ExecutorService executorService;

    public ExecutorBase() {
        executorService = Executors.newFixedThreadPool(3);
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }
    
}
