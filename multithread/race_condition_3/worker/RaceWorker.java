package multithread.race_condition_3.worker;

import multithread.race_condition_3.utils.*;;

public class RaceWorker implements Runnable {
    private Counter counter;

    public RaceWorker(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        for(int i=0; i< 10000; i++) {
            counter.increment();
        }
    }
}
