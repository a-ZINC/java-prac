package multithread.rentrant_5;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Hey !!");
        Resource res = new Resource();
        res.outerResource();
        System.out.println("Done !!");
    }
}
