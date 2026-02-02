package example.predicate;

import java.util.function.Predicate;

public class Predicates {
    public void run(int a) {
        Predicate<Integer> l1 = (x) -> x%2==0;
        boolean ans1 = l1.test(a);
        System.out.println("predicate ans: " + ans1);
    }
}
