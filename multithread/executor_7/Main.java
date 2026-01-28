package multithread.executor_7;

public class Main {
    public static void main(String[] args) throws Exception {
        // FirstExecutor fe = new FirstExecutor();

        // long startTime = System.currentTimeMillis();
        // fe.run();
        // long Total = System.currentTimeMillis() - startTime;
        // System.out.println("Time: " + Total + "ms");

        CallableExecutor fe = new CallableExecutor();

        long startTime = System.currentTimeMillis();
        fe.run();
        long Total = System.currentTimeMillis() - startTime;
        System.out.println("Time: " + Total + "ms");
    }
}
