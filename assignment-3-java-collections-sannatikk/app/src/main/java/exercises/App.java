package exercises;
import java.util.Vector;

public class App {
    public static void main(String[] args) {
        System.out.println("Main does nothing");

        Fibonacci fibonacci = new Fibonacci(5);
        System.out.println(fibonacci.getNumbers());
        System.out.println(fibonacci.addNext());
        System.out.println(fibonacci.getNumbers());

        System.out.println(fibonacci.isFibonacci(22));
        System.out.println(fibonacci.getNumbers());

        System.out.println(fibonacci.isFibonacci(21));
        System.out.println(fibonacci.getNumbers());

        Vector<Integer> vec = new Vector<>();
        vec.add(5);
        vec.add(8);
        vec.add(13);
        vec.add(22);
        System.out.println(fibonacci.compareSequence(vec));
    }
}
