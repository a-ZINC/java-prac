package multithread.executor_7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FirstExecutor extends ExecutorBase {
    long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    void run() throws Exception {
        ExecutorService executorBase = this.getExecutorService();
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            final int num = i;
            futures.add(executorBase.submit(() -> {
                try {
                    Thread.sleep(2000);
                    long result = factorial(num);
                    System.out.println("Factorial of " + num + " = " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            })
        );
        }

        for (Future<?> f : futures) {
            try {
                f.get(500, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                System.out.println("Task didn't complete in 1 second " + f.state());
                f.cancel(false);
            }
        }
        executorBase.shutdown();
    }
}
