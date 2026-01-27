import worker.DaWorker;

public class Main {
    

    public static void main(String[] args) {
        System.out.println("bruh !!");
        DaWorker worker = new DaWorker();
        Thread t1 = new Thread(worker);
        t1.setDaemon(true);
        t1.start();
        System.out.println("Done bro");
    }
}
