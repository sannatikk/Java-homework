package exercises;
import java.util.Vector;

public class Fibonacci {

    private Vector<Integer> fibonacciNumbers = new Vector<Integer>();

    public Fibonacci(Integer n){

        int value = 0;

        if (n <=0 ){
            return;
        }
        else if (n == 1) {
            fibonacciNumbers.add(0); // ensimmäinen numero on aina 0
            return;
        }
        else if (n == 2) {
            fibonacciNumbers.add(0); // ensimmäinen numero on aina 0
            fibonacciNumbers.add(1); // toinen numero on aina 1
            return;
        }
        else {
            fibonacciNumbers.add(0); // lisätään manuaalisesti ensimmäinen ja toinen numero
            fibonacciNumbers.add(1);

            int a = 0; // kaksi sijaa sitten
            int b = 1; // edellinen sija

            for (int i = 2; i < n; i++) {
                value = a + b; // n:nnännen sijan arvo, alkaa indeksistä 2 eli kolmannesta sijasta
                fibonacciNumbers.add(value); // lisätään arvo vektoriin
                a = b; // shiftataan kaksi sijaa sitten olevaa muuttujaa yksi eteenpäin, jotta seuraavalla loopilla voidaan laskea seuraava arvo
                b = value; // shiftataan edellistä sijaa yksi eteenpäin nykyiseen resultiin, jotta seuraavalla loopilla voidaan laskea seuraava arvo
            }
        }
    }

    public Vector<Integer> getNumbers() {
        return fibonacciNumbers;
    }

    // method which will calculate and add the next Fibonacci number into the collection and return it
    public Integer addNext() {

        if (fibonacciNumbers.size() < 2) {
            throw new IllegalStateException("Not enough elements to calculate the next Fibonacci number");
        }

        int a = fibonacciNumbers.get(fibonacciNumbers.size() - 2); // kaksi sijaa sitten
        int b = fibonacciNumbers.get(fibonacciNumbers.size() - 1); // edellinen sija
        int value = a + b;                                         // laske seuraavan sijan arvo
        fibonacciNumbers.add(value);                               // lisätään arvo vektoriin
        return value;                                              // palautetaan arvo
    }


    // Method compareSequence(Vector<Integer> seq) that will check (true / false) if the given sequence is included in a Fibonacci sequence. 
    // Again, similarly this method will add the missing sequence between to the collection. 
    // Last number in the updated sequence is the largest Fibonacci number equal or smaller than the largest number in seq.
    // If the current sequence is {0, 1, 1, 2, 3, 5, 8, 13} and the sequence to be checked is {5, 8, 13, 21, 34, 55, 999}, the collection will be updated to 987 as the last number.
    public Boolean isFibonacci(Integer num) {
        if (num < 0) return false;

        if (fibonacciNumbers.contains(num)) {
            return true; // Number already exists in the sequence
        }

        // Start from the last known Fibonacci numbers
        int a = fibonacciNumbers.get(fibonacciNumbers.size() - 2);
        int b = fibonacciNumbers.get(fibonacciNumbers.size() - 1);
        int nextValue = a + b;

        while (nextValue <= num) {
            fibonacciNumbers.add(nextValue);
            if (nextValue == num) {
                return true; // Found the number
            }
            a = b;
            b = nextValue;
            nextValue = a + b;
        }
        return false; // The number is not a Fibonacci number
    }

    // vertaa annettua sekvenssiä fibonaccijonoon ja laajentaa fibonaccijonoa kunnes se sisältää annetun sekvenssin
    public Boolean compareSequence(Vector<Integer> seq) {
        if (seq.size() == 0) {
            return false;
        }

        int largest = seq.get(seq.size() - 1); // Get the largest number in the sequence

        // Expand the Fibonacci sequence if needed
        int a = fibonacciNumbers.get(fibonacciNumbers.size() - 2);
        int b = fibonacciNumbers.get(fibonacciNumbers.size() - 1);
        int nextValue = a + b;

        while (nextValue <= largest) {
            fibonacciNumbers.add(nextValue);
            a = b;
            b = nextValue;
            nextValue = a + b;
        }

        // Check if `fibonacciNumbers` contains the entire `seq` in the correct order
        int seqIndex = 0;
        for (int fibNumber : fibonacciNumbers) {
            if (fibNumber == seq.get(seqIndex)) {
                seqIndex++;
            }
            if (seqIndex == seq.size()) {
                return true; // All elements in `seq` were found in `fibonacciNumbers` in order
            }
        }

        return false; // `seq` is not a Fibonacci sequence
    }
}