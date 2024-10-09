package java_basics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class Quest6Test {
    @Test
    @DisplayName("Test first element in Fibonacci series")
    public void test1() {
        Quest6 q6 = new Quest6();
        assertEquals(0, q6.fibonacci(0));
    }

    @Test
    @DisplayName("Test second element in Fibonacci series")
    public void test2() {
        Quest6 q6 = new Quest6();
        assertEquals(1, q6.fibonacci(1));
    }

    @Test
    @DisplayName("Test 32st element in Fibonacci series")
    public void test32() {
        Quest6 q6 = new Quest6();
        assertEquals(1346269, q6.fibonacci(31));
    }

    @Test
    @DisplayName("Test 36th element in Fibonacci series")
    public void test35() {
        Quest6 q6 = new Quest6();
        assertEquals(9227465, q6.fibonacci(35));
    }

}
