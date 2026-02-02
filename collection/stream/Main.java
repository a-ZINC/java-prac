import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import example.Lamda;
import example.predicate.Predicates;

public class Main {
    public static void main(String[] args) {
        System.out.println("bruh !!");

        Lamda l1 = (a, b) -> a + b;
        int ans = l1.operate(3, 5);
        System.out.println("sum: " + ans);

        Predicates p = new Predicates();
        p.run(6);

        Function<Integer, Integer> f1 = (a) -> a*2;
        int x1 = f1.apply(5);
        System.out.println("x1: "+ x1);

        Consumer<String> c1 = (String a) -> System.out.println("string: " + a);
        Consumer <List<Integer>> c2 = (List<Integer> l) -> {
            for (int i=0; i<l.size(); i++) {
                l.set(i, 2*l.get(i));
            }
        };
        List<Integer> lll = Arrays.asList(1, 2, 3);

        c1.accept("ajinkya");
        c2.accept(lll);
        for (int i=0; i<lll.size(); i++) {
            System.out.println("elememt: " + i + ": " + lll.get(i));
        }

        Supplier<String> s1 = () -> "Bruh fuck off!!";
        System.out.println("supplier: " +s1.get());
    }
}