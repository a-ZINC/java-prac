class Mythread extends Thread {
        private static int cnt = 0;
        @Override
        public void run() {
            for (int i=0; i< 10000; i++) {
                cnt++;
            }
        }

        public static int getCount() {
            return cnt;
        }
    }
class MyRunnable implements Runnable {
    private static int cnt = 0;
        @Override
        public void run() {
            for (int i=0; i< 10000; i++) {
                cnt++;
            }
            // try {
            // Thread.sleep(5000); 
            // } catch(Exception e) {
            //     e.printStackTrace();
            // }
        }

        public static int getCount() {
            return cnt;
        }
}

public class Main {
    public static void main(String[] args) {
        Mythread thread1 = new Mythread();
        Mythread thread2 = new Mythread();
        MyRunnable task1 = new MyRunnable();
        MyRunnable task2 = new MyRunnable();
        Thread thread3 = new Thread(task1, "worker-3");
        Thread thread4 = new Thread(task2, "worker-4");
        System.out.println("count: " + Mythread.getCount());
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("count: " + Mythread.getCount());

        System.out.println("count runnable: " + MyRunnable.getCount());
        System.out.println("before start state thread3: " + thread3.getState());
        thread3.start();
        thread4.start();
        System.out.println("after start state thread3: " + thread3.getState());
        try {
            Thread.sleep(1000);
            System.out.println("waiting state thread3: " + thread3.getState());
            thread3.interrupt();
            thread3.join();
            thread4.join();
        } catch(Exception e) {
            e.printStackTrace();
        }

         System.out.println("terminated state thread3: " + thread3.getState());

        System.out.println("count runnable: " + MyRunnable.getCount());

    }
}
