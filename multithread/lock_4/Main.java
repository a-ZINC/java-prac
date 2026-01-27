package multithread.lock_4;

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1000);
        Runnable task = () ->  acc.withdraw(500);

        Thread t1 = new Thread(task, "worker-1");
        Thread t2 = new Thread(task, "worker-2");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println("balance done: " + Thread.currentThread().getName());
    }
    
}
