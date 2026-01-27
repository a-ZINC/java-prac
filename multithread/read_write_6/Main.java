package multithread.read_write_6;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Runnable readTask = () -> {
            for (int i=0; i<10; i++) {
                counter.getCounter();
            }
        };

        Runnable writeTask = () -> {
            for (int i=0; i<10; i++) {
                counter.writeCounter();
            }
        };

        Thread r1 = new Thread(readTask, "readworker1");
        Thread r2 = new Thread(readTask, "readworker2");
        Thread t2 = new Thread(writeTask, "writeworker");

        r1.start();
        r2.start();
        t2.start();

        try {
            r2.join();
            r1.join();
            t2.join();
        } catch (Exception e) {

        }

    }
}
