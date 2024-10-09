package exercises;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.util.Vector;

import org.junit.jupiter.api.*;

@DisplayName("Fibonacci")
public class FibonacciTest {
    private static Constructor<?> fconst;

    @BeforeEach
    @DisplayName("Check class declaration")    
    public void setUp() throws Exception {
        try {
            Class<?> a = Class.forName("exercises.Fibonacci");
            Class<?>[] fTypes = { Integer.class};
            fconst = a.getConstructor(fTypes);
        } catch (NoSuchMethodException e) {
            assertTrue(false, "Fibonacci class declaration or its constructor is wrong");    
        }
    }  

    @Test
    @DisplayName("Test if constructor works with method getNumbers()")
    public void testConstructorWithGetNumbers() throws Throwable {

        MethodType methodType = MethodType.methodType(Vector.class);
        MethodHandle getNumbersHandle = MethodHandles.lookup().findVirtual(Fibonacci.class, "getNumbers", methodType);        
    
        Object[] initargs = { 8 };
        Fibonacci fb = (Fibonacci) fconst.newInstance(initargs);
        Vector<Integer> result = (Vector<Integer>) getNumbersHandle.invoke(fb);
        // Expected result: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
        assertEquals(13, result.get(7));
        assertEquals(8, result.get(6));
        assertEquals(5, result.get(5));
        assertEquals(3, result.get(4));
        assertEquals(2, result.get(3));
        assertEquals(1, result.get(2));
        assertEquals(1, result.get(1));
        assertEquals(0, result.get(0));

        Object[] initargs2 = { 2 };
        fb = (Fibonacci) fconst.newInstance(initargs2);
        result = (Vector<Integer>) getNumbersHandle.invoke(fb);
        assertEquals(1, result.get(1));
        assertEquals(0, result.get(0));
    }

    @Test
    @DisplayName("Test if method addNext() works properly")
    public void testAddNext() throws Throwable {
        MethodType methodType = MethodType.methodType(Integer.class);
        MethodHandle addNextHandle = MethodHandles.lookup().findVirtual(Fibonacci.class, "addNext", methodType);        

        methodType = MethodType.methodType(Vector.class);
        MethodHandle getNumbersHandle = MethodHandles.lookup().findVirtual(Fibonacci.class, "getNumbers", methodType);        
        
        Object[] initargs = { 17 }; // muokattu Jukan ohjeen mukaisesti
        Fibonacci fb = (Fibonacci) fconst.newInstance(initargs);
        Integer iresult = (Integer) addNextHandle.invoke(fb);
        assertEquals(1597, iresult, "18th Fibonacci number is not correct");
    
        Vector<Integer> result = (Vector<Integer>) getNumbersHandle.invoke(fb);
        // Expected result: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377,
        // 610, 987, 1597
        assertEquals(1597, result.get(17));
        assertEquals(987, result.get(16));
        assertEquals(610, result.get(15));
        assertEquals(377, result.get(14));
        assertEquals(233, result.get(13));
        assertEquals(144, result.get(12));
        assertEquals(89, result.get(11));
        assertEquals(55, result.get(10));
        assertEquals(34, result.get(9));
        assertEquals(21, result.get(8));
        assertEquals(13, result.get(7));
        assertEquals(8, result.get(6));
        assertEquals(5, result.get(5));
        assertEquals(3, result.get(4));
        assertEquals(2, result.get(3));
        assertEquals(1, result.get(2));
        assertEquals(1, result.get(1));
        assertEquals(0, result.get(0));

        Object[] initargs2 = { 26 }; // muokattu Jukan ohjeen mukaisesti
        fb = (Fibonacci) fconst.newInstance(initargs2);
        iresult = (Integer) addNextHandle.invoke(fb);
        assertEquals(121393, iresult, "27th Fibonacci number is not correct");
    }

    @Test
    @DisplayName("Test if method compareSequence() works properly")
    public void testCompareSequence() throws Throwable {
        MethodType methodType = MethodType.methodType(Boolean.class, Vector.class);
        MethodHandle compareHandle = MethodHandles.lookup().findVirtual(Fibonacci.class, "compareSequence", methodType);        
    
        Object[] initargs = { 18 };
        Fibonacci fb = (Fibonacci) fconst.newInstance(initargs);
        Vector<Integer> vec = new Vector<Integer>();
        vec.add(233);
        vec.add(377);
        vec.add(610);
        vec.add(987);
        Boolean result = (Boolean) compareHandle.invoke(fb, vec);
        assertEquals(true, result, "Sequence { 233, 377, 610, 987 } is a Fibonacci sequence");

        vec.clear();
        vec.add(55);
        vec.add(90);
        vec.add(144);
        result = (Boolean) compareHandle.invoke(fb, vec);
        assertEquals(false, result, "Sequence { 55, 90, 144 } is not a Fibonacci sequence");
    }

    @Test
    @DisplayName("Test if method isFibonacci() works properly")
    public void testIsFibonacci() throws Throwable {
        MethodType methodType = MethodType.methodType(Boolean.class, Integer.class);
        MethodHandle compareHandle = MethodHandles.lookup().findVirtual(Fibonacci.class, "isFibonacci", methodType);        
    
        Object[] initargs = { 10 };
        Fibonacci fb = (Fibonacci) fconst.newInstance(initargs);
        Boolean result = (Boolean) compareHandle.invoke(fb, 267914296);
        assertEquals(true, result, "Number 267914296 is aFibonacci number");

        result = (Boolean) compareHandle.invoke(fb, 14930252);
        assertEquals(false, result, "Number 14930352 is not a Fibonacci number");
    }
}
