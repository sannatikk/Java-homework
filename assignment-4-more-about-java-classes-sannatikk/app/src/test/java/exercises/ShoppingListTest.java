package exercises;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class ShoppingListTest {
    
    private static MethodHandle addItemHandle;
    private static MethodHandle searchByNameHandle;
    private static MethodHandle searchSmallerHandle;
    private static MethodHandle searchGreaterOrEqualHandle;
    private static MethodHandle getTotalHandle;
    private static Constructor<?> shoppingListConstructor;
    private static Constructor<?> productConstructor;
    
    @BeforeEach
    public void setUp() throws Exception {
        try {
            // Test that Shape is abstract class
            Class<?> clazz = Searchable.class; 
            boolean isInterface = Modifier.isInterface(clazz.getModifiers());
            if (isInterface == false) {
                assertTrue(false, "Searchable class must be interface");
            }

            // Setup for Product class
            Class<?> productClass = Class.forName("exercises.Product");
            // Constructor
            productConstructor = productClass.getConstructor(Double.class, Integer.class, String.class);

            // Setup for ShoppingList class
            Class<?> ShoppingListClass = Class.forName("exercises.ShoppingList");
            // Check that interface is implemented in ShoppingList class
            boolean implementsInterface = Searchable.class.isAssignableFrom(ShoppingListClass);
            if (implementsInterface == false) {
                assertTrue(false, "ShoppingList class does not implement Searchable interface");
            }
            // Constructor
            shoppingListConstructor = ShoppingListClass.getConstructor(String.class, Double.class, Integer.class);
            // addItem
            MethodType type = MethodType.methodType(void.class, String.class, Double.class, Integer.class);
            addItemHandle = MethodHandles.lookup().findVirtual(ShoppingListClass, "addItem", type);
            // searchByName
            type = MethodType.methodType(LinkedList.class, String.class);
            searchByNameHandle = MethodHandles.lookup().findVirtual(ShoppingListClass, "searchByName", type);
            // searchSmaller
            type = MethodType.methodType(LinkedList.class, Double.class);
            searchSmallerHandle = MethodHandles.lookup().findVirtual(ShoppingListClass, "searchSmaller", type);
            // searchGreaterOrEqual
            type = MethodType.methodType(LinkedList.class, Double.class);
            searchGreaterOrEqualHandle = MethodHandles.lookup().findVirtual(ShoppingListClass, "searchGreaterOrEqual", type);
            // getTotalByname
            type = MethodType.methodType(Double.class, String.class);
            getTotalHandle = MethodHandles.lookup().findVirtual(ShoppingListClass, "getTotalByName", type);

        } catch (Exception e) {
            assertTrue(false, "Product or ShoppingList class has incorrect declaration");
        }
    }

    @Test
    @DisplayName("Test ShoppingList class")
    public void testShoppingListClass() throws Throwable {
        Object[] initargs1 = { "GoldFish", 12.15, 2 };
        Object sl = shoppingListConstructor.newInstance(initargs1);

        // use addItem
        addItemHandle.invoke((ShoppingList)sl, "GoldFish", 12.15, 5);
        addItemHandle.invoke((ShoppingList)sl, "CatFish", 52.99, 2);

        // use search by name
        LinkedList<Product> expected2 = new LinkedList<Product>();
        // expected2.add(new Product(12.15, 7, "GoldFish"));
        Object[] initargs2 = { 12.15, 7, "GoldFish" };        
        expected2.add((Product)productConstructor.newInstance(initargs2));
        LinkedList<Product> actual2 = (LinkedList<Product>) searchByNameHandle.invoke(sl, "GoldFish");
        if (actual2.size() != 2) {
            assertTrue(false, "Error in method searchByName");
        }

        // use getTotalByName
        Double expected3 = 85.05 + 105.98;
        Double actual3 = (Double) getTotalHandle.invoke(sl, "Fish");
        assertEquals(expected3, actual3, "Error in method getTotalByName");

        // use searchGreaterOrEqual
        LinkedList<Product> expected4 = new LinkedList<Product>();
        Object[] initargs4 = { 52.99, 7, "CatFish" };      
        // expected.add(new Product(52.99, 2, "CatFish"));
        expected4.add((Product)productConstructor.newInstance(initargs4));
        LinkedList<Product> actual4 = (LinkedList<Product>) searchGreaterOrEqualHandle.invoke(sl, 100.0);
        assertEquals(1, actual4.size(), "Error in method searchGreaterOrEqual");

        // use searchSmaller
        LinkedList<Product> actual5 = (LinkedList<Product>) searchSmallerHandle.invoke(sl, 90.0);
        assertEquals(2, actual5.size(), "Error in method searchSmaller");
    }    
}
