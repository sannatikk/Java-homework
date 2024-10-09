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

public class ShapeTest {
    
    private static MethodHandle circleAreaHandle;
    private static MethodHandle rectangleAreaHandle;
    private static Constructor<?> circleConstructor;
    private static Constructor<?> rectangleConstructor;
    
    @BeforeEach
    public void setUp() throws Exception {
        try {
            // Test that Shape is abstract class
            Class<?> clazz = Shape.class; 
            boolean isAbstract = Modifier.isAbstract(clazz.getModifiers());
            if (isAbstract == false) {
                assertTrue(false, "Shape class must be abstract");
            }

            // Check inheritance
            Class<?> circle = Circle.class;
            Class<?> superc = circle.getSuperclass();
            if (superc.getName().equals("exercises.Shape") == false) {
                assertTrue(false, "Circle must inherit Shape");
            }
            Class<?> rect = Rectangle.class;
            Class<?> superr = rect.getSuperclass();
            if (superr.getName().equals("exercises.Shape") == false) {
                assertTrue(false, "Rectangle must inherit Shape");
            }

            // Setup for Circle class
            Class<?> circleClass = Class.forName("exercises.Circle");
            circleConstructor = circleClass.getConstructor(String.class, Double.class);
            MethodType circleAreaType = MethodType.methodType(Double.class);
            circleAreaHandle = MethodHandles.lookup().findVirtual(circleClass, "calculateArea", circleAreaType);
            
            // Setup for Rectangle class
            Class<?> rectangleClass = Class.forName("exercises.Rectangle");
            rectangleConstructor = rectangleClass.getConstructor(String.class, Double.class, Double.class);
            MethodType rectangleAreaType = MethodType.methodType(Double.class);
            rectangleAreaHandle = MethodHandles.lookup().findVirtual(rectangleClass, "calculateArea", rectangleAreaType);
            
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            assertTrue(false, "Either Circle or Rectangle class or their constructors are missing");
        }
    }
    
    @Test
    @DisplayName("Test Circle Area Calculation")
    public void testCircleArea() throws Throwable {
        try {
            // Create Circle instance with name "Circle" and radius 5.0
            Object[] initargs = { "Circle", 5.0 };
            Object circle = circleConstructor.newInstance(initargs);
            
            // Calculate area and assert the value
            Double expected = Math.PI * 5.0 * 5.0;
            Double actual = (Double) circleAreaHandle.invoke(circle);
            assertEquals(expected, actual, "Circle area calculation is incorrect");

            Object[] initargs2 = { "Circle", 7.0 };
            Object circle2 = circleConstructor.newInstance(initargs2);
            
            // Calculate area and assert the value
            expected = Math.PI * 7.0 * 7.0;
            actual = (Double) circleAreaHandle.invoke(circle2);
            assertEquals(expected, actual, "Circle area calculation is incorrect");

        } catch (Exception e) {
            assertTrue(false, "Circle area calculation could not be tested: " + e.getMessage());
        }
    }
    
    @Test
    @DisplayName("Test Rectangle Area Calculation")
    public void testRectangleArea() throws Throwable {
        try {
            // Create Rectangle instance with name "Rectangle", length 4.0, and width 6.0
            Object[] initargs = { "Rectangle", 4.0, 6.0 };
            Object rectangle = rectangleConstructor.newInstance(initargs);
            
            // Calculate area and assert the value
            Double expected = 4.0 * 6.0;
            Double actual = (double) rectangleAreaHandle.invoke(rectangle);
            assertEquals(expected, actual, "Rectangle area calculation is incorrect");

            // Create Rectangle instance with name "Rectangle", length 4.0, and width 6.0
            Object[] initargs2 = { "Rectangle", 4.7, 6.2 };
            Object rectangle2 = rectangleConstructor.newInstance(initargs2);
            
            // Calculate area and assert the value
            expected = 4.7 * 6.2;
            actual = (double) rectangleAreaHandle.invoke(rectangle2);
            assertEquals(expected, actual, "Rectangle area calculation is incorrect");

        } catch (Exception e) {
            assertTrue(false, "Rectangle area calculation could not be tested: " + e.getMessage());
        }
    }
    
    @Test
    @DisplayName("Test Circle Area with Zero Radius")
    public void testCircleAreaZeroRadius() throws Throwable {
        try {
            // Create Circle instance with name "Circle" and radius 0.0
            Object[] initargs = { "Circle", 0.0 };
            Object circle = circleConstructor.newInstance(initargs);
            
            // Calculate area and assert the value
            Double expected = 0.0;
            Double actual = (Double) circleAreaHandle.invoke(circle);
            assertEquals(expected, actual, "Circle area with zero radius is incorrect");
        } catch (Exception e) {
            assertTrue(false, "Circle area with zero radius could not be tested: " + e.getMessage());
        }
    }
}
