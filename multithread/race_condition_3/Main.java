package multithread.race_condition_3;

import multithread.race_condition_3.utils.Counter;
import multithread.race_condition_3.worker.RaceWorker;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter(0);

        RaceWorker rw1 = new RaceWorker(counter);
        RaceWorker rw2 = new RaceWorker(counter);

        Thread t1 = new Thread(rw1, "racewroker_1");
        Thread t2 = new Thread(rw2, "racewroker_2");

        t1.start();
        t2.start();

      try {
        t1.join();
        t2.join();
      } catch(Exception e) {
        e.printStackTrace();
      }

      System.out.println("Count: " + counter.getCount());

    }
}
