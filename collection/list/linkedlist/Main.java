package collection.list.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> ll = new LinkedList<>();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);

        for (int i=0; i<ll.size(); i++) {
            System.out.println("value: " + ll.get(i));
        }

        while(ll.size() > 1) {
            ll.removeFirst();
        }

        for (int i=0; i<ll.size(); i++) {
            System.out.println("i value: " + ll.get(i));
        }
    }
}
