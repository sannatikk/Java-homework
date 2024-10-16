package designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.invoke.MethodType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorBuilderTest {

    private static MethodHandle addHandle;
    private static MethodHandle subHandle;
    private static MethodHandle mulHandle;
    private static MethodHandle divHandle;
    private static MethodHandle getResultHandle;
    private static Constructor<?> bConst;

    @BeforeEach
    public void setUp() throws Throwable {

        try {
            // test calculator class
            Class<?> lazz = Class.forName("designpatterns.Calculator");
            bConst = lazz.getConstructor(Double.class);
            MethodType type = MethodType.methodType(Calculator.class, Double.class);
            addHandle = MethodHandles.lookup().findVirtual(lazz, "add", type);            
            subHandle = MethodHandles.lookup().findVirtual(lazz, "subtract", type);            
            mulHandle = MethodHandles.lookup().findVirtual(lazz, "multiply", type);            
            divHandle = MethodHandles.lookup().findVirtual(lazz, "divide", type);            
            type = MethodType.methodType(Double.class);
            getResultHandle = MethodHandles.lookup().findVirtual(lazz, "getResult", type);   
        } catch (Exception e) {
            assertTrue(false, "Class Calculator declaration is incorrect");
        }
    }

    @Test
    public void testOperations() throws Throwable {

        Object[] initargs = { 1.7 };
        Calculator c = (Calculator)bConst.newInstance(initargs);
        Calculator c1 = (Calculator) addHandle.invoke(c,4.3);
        Calculator c2 = (Calculator) addHandle.invoke(c1,5.9);
        Calculator c3 = (Calculator) divHandle.invoke(c2,1.23);
        Calculator c4 = (Calculator) subHandle.invoke(c3,3.2);
        Double actual = (Double) getResultHandle.invoke(c4);
        Double expected = 6.47479674796748;
        assertEquals(expected, actual, 0.01, "Testing arithmetic operatrions returned incorrect answer");

        Object[] initargs2 = { 103.45 };
        c = (Calculator)bConst.newInstance(initargs2);
        c1 = (Calculator) addHandle.invoke(c,4.3);
        c2 = (Calculator) mulHandle.invoke(c1,5.9);
        c3 = (Calculator) subHandle.invoke(c2,1.23);
        c4 = (Calculator) divHandle.invoke(c3,3.2);
        actual = (Double) getResultHandle.invoke(c4);
        expected = 198.2796875;
        assertEquals(expected, actual, 0.01, "Testing arithmetic operatrions returned incorrect answer");

    }
}
