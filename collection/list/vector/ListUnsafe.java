package collection.list.vector;

import java.util.ArrayList;
import java.util.List;

public class ListUnsafe {
    List<Integer> list;

    public ListUnsafe() {
        this.list = new ArrayList<>();
    }

    public void run() throws Exception {
        Thread t1 = new Thread(() -> {
            for (int i=0; i < 1000; i++) {
                list.add(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i=0; i < 1000; i++) {
                list.add(i);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    public int getLength() {
        return list.size();
    }

    public void print() {
        for (int i=0; i<list.size(); i++) {
            System.out.println("LUS Value: " + list.get(i));
        }
    }
}
