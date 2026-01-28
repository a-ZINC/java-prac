package multithread.executor_7;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class CallableExecutor extends ExecutorBase {
    public void run() throws Exception {
        ExecutorService executorService = this.getExecutorService();

        Callable<Integer> task1 = () -> {
            System.out.println("Task 1");
            Thread.sleep(1000);
            return 1;
        };

        Callable<Integer> task2 = () -> {
            System.out.println("Task 2");
            Thread.sleep(1000);
            return 2;
        };

        List<Callable<Integer>> tasks = Arrays.asList(task1, task2);
        List<Future<Integer>> futures = executorService.invokeAll(tasks);

        for (Future<Integer> f : futures) {
            System.out.println("Result: " + f.get());
        }

        executorService.shutdown();
    }
}
