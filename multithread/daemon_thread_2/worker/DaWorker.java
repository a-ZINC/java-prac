package worker;

public class DaWorker implements Runnable{
    private int cnt = 0;
    @Override
    public void run() {
        try {
            while(cnt < 10) {
                System.out.println("Hello bruh");
                cnt++;
                Thread.sleep(500);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
