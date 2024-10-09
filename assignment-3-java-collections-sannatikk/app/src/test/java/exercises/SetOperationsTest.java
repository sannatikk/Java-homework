package exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SetOperationsTest {

    private static Constructor<?> sconst;

    @BeforeEach
    @DisplayName("Check class declaration")    
    public void setUp() throws Exception {
        try {
            Class<?> a = Class.forName("exercises.SetOperations");
            Class<?>[] fTypes = { HashSet.class, HashSet.class};
            sconst = a.getConstructor(fTypes);
        } catch (NoSuchMethodException e) {
            assertTrue(false, "SetOperations class declaration or its constructor is wrong");    
        }
    }  

    @Test
    @DisplayName("Test union of sets")
    public void testUnion() throws Throwable {
        // HashSet<Integer> union()
        MethodType methodType = MethodType.methodType(HashSet.class);
        MethodHandle addNextHandle = MethodHandles.lookup().findVirtual(SetOperations.class, "union", methodType);        
    
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(2, 3, 4));

        Object[] initargs = { set1, set2 };
        SetOperations so = (SetOperations) sconst.newInstance(initargs);
        HashSet<Integer> result = (HashSet<Integer>) addNextHandle.invoke(so);
        HashSet<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        assertEquals(expected, result, "Union operation result is not correct");
    }

    @Test
    @DisplayName("Test intersection of sets")
    public void testIntersection() throws Throwable {
        // HashSet<Integer> intersection()
        MethodType methodType = MethodType.methodType(HashSet.class);
        MethodHandle addNextHandle = MethodHandles.lookup().findVirtual(SetOperations.class, "intersection", methodType);        
    
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(5, 6, 7, 8, 9));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(7, 9, 12, 15));

        Object[] initargs = { set1, set2 };
        SetOperations so = (SetOperations) sconst.newInstance(initargs);
        HashSet<Integer> result = (HashSet<Integer>) addNextHandle.invoke(so);
        HashSet<Integer> expected = new HashSet<>(Arrays.asList(7,9));
        assertEquals(expected, result, "Intersection operation result is not correct");
    }

    @Test
    @DisplayName("Test difference of sets")
    public void testDifference() throws Throwable {
        // HashSet<Integer> difference()
        MethodType methodType = MethodType.methodType(HashSet.class);
        MethodHandle addNextHandle = MethodHandles.lookup().findVirtual(SetOperations.class, "difference", methodType);        
    
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(5, 6, 7, 8, 9, 10, 11));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(7, 9, 11));

        Object[] initargs = { set1, set2 };
        SetOperations so = (SetOperations) sconst.newInstance(initargs);
        HashSet<Integer> result = (HashSet<Integer>) addNextHandle.invoke(so);
        HashSet<Integer> expected = new HashSet<>(Arrays.asList(5, 6, 8, 10 ));
        assertEquals(expected, result, "Difference operation result is not correct");
    }

    @Test
    @DisplayName("Test difference with empty set")
    public void testDifferenc2() throws Throwable {
        // HashSet<Integer> difference()
        MethodType methodType = MethodType.methodType(HashSet.class);
        MethodHandle addNextHandle = MethodHandles.lookup().findVirtual(SetOperations.class, "difference", methodType);        
    
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(5, 6, 7, 8, 9, 10, 11));
        HashSet<Integer> set2 = new HashSet<>();

        Object[] initargs = { set1, set2 };
        SetOperations so = (SetOperations) sconst.newInstance(initargs);
        HashSet<Integer> result = (HashSet<Integer>) addNextHandle.invoke(so);
        HashSet<Integer> expected = new HashSet<>(Arrays.asList(5, 6, 7, 8, 9, 10, 11 ));
        assertEquals(expected, result, "Difference operation with empty set is not correct");
    }
}
