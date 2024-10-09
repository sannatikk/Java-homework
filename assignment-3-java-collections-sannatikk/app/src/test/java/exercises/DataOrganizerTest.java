package exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DataOrganizerTest {
    private static Constructor<?> dconst;

    @BeforeEach
    @DisplayName("Check class declaration")    
    public void setUp() throws Exception {
        try {
            Class<?> a = Class.forName("exercises.DataOrganizer");
            Class<?>[] fTypes = { };
            dconst = a.getConstructor(fTypes);
        } catch (NoSuchMethodException e) {
            assertTrue(false, "DataOrganizer class declaration or its constructor is wrong");    
        }
    }  

    @Test
    @DisplayName("Test 1 Group and Sort")
    public void testGroupAndSort1() throws Throwable {

        // HashMap<String, ArrayList<Integer>> groupAndSort(ArrayList<Integer> numbers)
        MethodType methodType = MethodType.methodType(HashMap.class, ArrayList.class);
        MethodHandle groupHandle = MethodHandles.lookup().findVirtual(DataOrganizer.class, "groupAndSort", methodType);        
        
        DataOrganizer dd = (DataOrganizer) dconst.newInstance();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        HashMap<String, ArrayList<Integer>> result = (HashMap<String, ArrayList<Integer>>) groupHandle.invoke(dd, numbers);
        List<Integer> expectedEvens = Arrays.asList(2, 4);
        List<Integer> expectedOdds = Arrays.asList(5, 3, 1);
        assertEquals(expectedEvens, result.get("Even"), "Even group sort failed");
        assertEquals(expectedOdds, result.get("Odd"), "Odd group sort failed");
    }

    @Test
    @DisplayName("Test 2 Group and Sort")
    public void testGroupAndSort2() throws Throwable {

        // HashMap<String, ArrayList<Integer>> groupAndSort(ArrayList<Integer> numbers)
        MethodType methodType = MethodType.methodType(HashMap.class, ArrayList.class);
        MethodHandle groupHandle = MethodHandles.lookup().findVirtual(DataOrganizer.class, "groupAndSort", methodType);        
        
        DataOrganizer dd = (DataOrganizer) dconst.newInstance();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(14);
        numbers.add(15);
        numbers.add(18);
        numbers.add(20);
        numbers.add(22);
        HashMap<String, ArrayList<Integer>> result = (HashMap<String, ArrayList<Integer>>) groupHandle.invoke(dd, numbers);
        List<Integer> expectedEvens = Arrays.asList(14, 18, 20, 22);
        List<Integer> expectedOdds = Arrays.asList(15);
        assertEquals(expectedEvens, result.get("Even"), "Even group sort failed");
        assertEquals(expectedOdds, result.get("Odd"), "Odd group sort failed");
    }

}
