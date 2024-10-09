package oop;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShapeTest {
    private static Constructor<?> sconst;
    private static Constructor<?> cconst;
    private static Constructor<?> rconst;

    @BeforeEach
    public void setUp() {
        try {
            Class<?> s = Class.forName("oop.Shape");
            Class<?>[] stypes = { String.class };
            sconst = s.getConstructor(stypes);
        } catch (Exception e) {
            assertTrue(false, "Shape class or its constructor is wrong");    
        }

        try {
            Class<?> c = Class.forName("oop.Circle");
            Class<?>[] ctypes = { String.class, Double.class };
            cconst = c.getConstructor(ctypes);
        } catch (Exception e) {
            assertTrue(false, "Circle class or its constructor is wrong");    
        }

        try {
            Class<?> r = Class.forName("oop.Rectangle");
            Class<?>[] rtypes = { String.class, Double.class, Double.class };
            rconst = r.getConstructor(rtypes);
        } catch (Exception e) {
            assertTrue(false, "Rectangle class or its constructor is wrong");    
        }
    }

    @Test
    @DisplayName("Test Shape Inheritance")
    public void testInheritance() {

        Class<?> s = Shape.class;
        Class<?> ssuper = s.getSuperclass();
        assertEquals(ssuper, Object.class, "Shape parent class should be Object");

        Class<?> c = Circle.class;
        Class<?> csuper = c.getSuperclass();
        assertNotNull(csuper, "Circle parent class is null");
        assertEquals(Shape.class, csuper, "Incorrect inheritance for Circle");

        Class<?> r = Rectangle.class;
        Class<?> rsuper = r.getSuperclass();
        assertNotNull(rsuper, "Rectangle parent class is null");
        assertEquals(Shape.class, rsuper, "Incorrect inheritance for Rectangle");
    }

    @Test
    @DisplayName("Test class name printing")
    public void testName() {
        Shape s=null;
        try {
            // Shape s = new Shape("shape");
            Object[] sargs = { "shape" };
            s = (Shape) sconst.newInstance(sargs);    
            assertEquals("shape", s.toString(), "Shape name wrong");
        } catch (Exception e) {
            assertTrue(false, "Name printing failed for Shape");    
        }

        Rectangle r=null;
        try {
            // Rectangle r = new Rectangle("rectangle", 5.0,5.0 );
            Object[] rargs = { "rectangle", 5.0, 5.0  };
            r = (Rectangle) rconst.newInstance(rargs);    
            assertEquals("rectangle", r.toString(), "Rectangle name wrong");
        } catch (Exception e) {
            assertTrue(false, "Name printing failed forb Rectangle");    
        }

        Circle c=null;
        try {
            // Circle c = new Circle("circle", 5.0);
            Object[] cargs = { "circle", 5.0  };
            c = (Circle) cconst.newInstance(cargs);    
            assertEquals("circle", c.toString(), "Circle name wrong");    
        } catch (Exception e) {
            assertTrue(false, "Name printing failed for Circle");    
        }
    }

    @Test
    @DisplayName("Test Rectangle area calculation")
    public void testRectangleArea() throws Throwable {
        try {
            // Rectangle r = new Rectangle("rectangle", 3.0, 4.0);
            Object[] rargs = { "rectangle", 3.0, 4.0  };
            Rectangle r = (Rectangle) rconst.newInstance(rargs);    
            MethodType methodType = MethodType.methodType(Double.class);
            MethodHandle getAreaHandle = MethodHandles.lookup().findVirtual(Rectangle.class, "getArea", methodType);
            Double actual = (Double) getAreaHandle.invoke(r);
            assertEquals(12.0, actual, 0.05, "Incorrect area calculation for Rectangle");
        } catch (Exception e) {
            assertTrue(false, "Could not calculate area for Rectangle");        
        }
    }

    @Test
    @DisplayName("Test Circle area calculation")
    public void testCircleArea() throws Throwable {
        try {
            // Circle c = new Circle("circle", 2.0);
            Object[] cargs = { "circle", 2.0  };
            Circle c = (Circle) cconst.newInstance(cargs);    
            MethodType methodType = MethodType.methodType(Double.class);
            MethodHandle getAreaHandle = MethodHandles.lookup().findVirtual(Circle.class, "getArea", methodType);
            Double expected = Math.PI * 4.0;            
            Double actual = (Double) getAreaHandle.invoke(c);
            assertEquals(expected, actual, 0.05, "Incorrect area calculation for Rectangle");
        } catch (Exception e) {
            assertTrue(false, "Could not calculate area for Circle");    
        }
    }
}
