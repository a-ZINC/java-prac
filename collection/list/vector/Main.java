package collection.list.vector;

import java.util.Vector;

public class Main {

    public static void main (String[] args) {
        ListUnsafe lus = new ListUnsafe();
        VectorSafe vs = new VectorSafe();

        try {
            lus.run();
            vs.run();
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        System.out.println("LUS Length: " + lus.getLength());
        System.out.println("Vs Length: " + vs.getLength());

        // lus.print();
        // vs.print();
    }
}
