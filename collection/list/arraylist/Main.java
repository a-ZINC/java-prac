package collection.list.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // List<Integer> list = new ArrayList<>();
        // list.add(1);

        // for (int i=0; i<list.size(); i++) {
        //     System.out.println("ith index: " + i + " value: " + list.get(i));
        // }

        // list.add(0, 2);

        // for (int i=0; i<list.size(); i++) {
        //     System.out.println("added ith index: " + i + " value: " + list.get(i));
        // }
        // System.out.println("contain: " + list.contains(1));
        // list.remove(Integer.valueOf(1));
        // for (int i=0; i<list.size(); i++) {
        //     System.out.println("added ith index: " + i + " value: " + list.get(i));
        // }
        // list.set(0, 3);
        // for (int i=0; i<list.size(); i++) {
        //     System.out.println("added ith index: " + i + " value: " + list.get(i));
        // }

        // List<String> strs = Arrays.asList("hello", "aj");
        // for (int i=0; i<strs.size(); i++) {
        //     System.out.println("added ith index: " + i + " value: " + strs.get(i));
        // }

        // String[] arr = strs.toArray(new String[0]);
        // for (int i=0; i<arr.length; i++) {
        //     System.out.println("added ith index: " + i + " value: " + arr[i]);
        // }

        // List<Integer> num = Arrays.asList(2, 1, 3);
        // num.sort(null);
        // for (int i=0; i<num.size(); i++) {
        //     System.out.println("added ith index: " + i + " value: " + num.get(i));
        // }

        // List<Integer> num2 = Arrays.asList(10, 12, 8, 3);
        // num2.sort((a, b) -> b-a);
        // for (int i=0; i<num2.size(); i++) {
        //     System.out.println("added ith index: " + i + " value: " + num2.get(i));
        // }

        // List<String> words = Arrays.asList("date", "apple", "banana");
        // words.sort((a, b) -> a.length() - b.length());
        // for (int i=0; i<words.size(); i++) {
        //     System.out.println("added ith index: " + i + " value: " + words.get(i));
        // }

        List<Student> students = new ArrayList<>();
        students.add(new Student("Charlie", 3.5));
        students.add(new Student("Alice", 3.5));
        students.add(new Student("Bob", 3.7));

        students.sort(Comparator.comparing((Student s) -> s.grade).thenComparing(Student::getName));

        for (int i=0; i<students.size(); i++) {
            System.out.println("added ith index: " + i + " value: " + students.get(i).grade + 
        " : " + students.get(i).name);
        }

    }



}
