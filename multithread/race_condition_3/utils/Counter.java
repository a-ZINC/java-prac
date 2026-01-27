package multithread.race_condition_3.utils;

public class Counter {
    private int count;

    public int getCount() {
        return count;
    }

    public Counter(int count) {
        this.count = count;
    }

    public synchronized int increment() {
        this.count++;
        return this.count;
    }
}
