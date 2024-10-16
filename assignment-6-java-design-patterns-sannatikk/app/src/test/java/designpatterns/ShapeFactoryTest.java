package designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShapeFactoryTest {

    private static MethodHandle getAreaHandle;
    private static MethodHandle getParamsHandle;
    private static Method createMethod;
    private static Constructor<?> cConst;
    private static Constructor<?> rConst;        
    private static Constructor<?> fConst;        

    @BeforeEach
    public void setUp() throws Throwable {
        
        // test shape interface
        try {
            Class<?> lazz = Class.forName("designpatterns.Shape");
            boolean isInterface = Modifier.isInterface(lazz.getModifiers());
            if (isInterface == false) {
                assertTrue(false, "Shape class must be an interface");
            }
            // Double getArea();
            MethodType type = MethodType.methodType(Double.class);
            getAreaHandle = MethodHandles.lookup().findVirtual(lazz, "getArea", type);            
            // Double[] getParams();
            type = MethodType.methodType(Double[].class);
            getParamsHandle = MethodHandles.lookup().findVirtual(lazz, "getParams", type);            
        } catch (Exception e) {
            assertTrue(false, "Interface Shape declaration is incorrect");
        }
    }

    @Test
    public void TestCircleClass() throws Throwable {
        try {
            Class<?> lazz = Class.forName("designpatterns.Circle");
            cConst = lazz.getConstructor(Double[].class);
            if (Shape.class.isAssignableFrom(lazz) == false) {
                assertTrue(false, "Circle class does not implement interface Shape");
            }
        } catch (Exception e) {
            assertTrue(false, "Class Circle declaration is incorrect");
        }
        Double[] r = { 5.0 };
        Object[] cargs = { r };
        Object c = (Circle)cConst.newInstance(cargs);
        // test getparams
        Double[] actualParams = (Double[]) getParamsHandle.invoke((Circle)c);
        assertEquals(r[0], actualParams[0], 0.01, "getParams method for Circle is not correctly implemented");
        // test getarea
        Double expected = 78.53981633974483; // failaa
        Double actual = (Double) getAreaHandle.invoke((Circle)c);
        assertEquals(expected, actual, 0.01, "getArea method for Circle is not correctly implemented");

        Boolean fails = false;
        try {
            Double[] initargs = { 6.7, 3.4 };
            Object[] ccargs = { initargs };
            Object cc = cConst.newInstance(ccargs);
        } catch (InvocationTargetException e) {
            Throwable target = e.getTargetException();
            if (target.getClass().equals(new IllegalArgumentException().getClass())) {
                fails = true;
            }
        } finally {
            if (fails == false) {
                assertTrue(false, "Testing number of params for Circle constructor failed");
            }
        }

        fails = false;
        try {
            Double[] initargs = { };
            Object[] ccargs = { initargs };
            Object cc = cConst.newInstance(ccargs);
        } catch (InvocationTargetException e) {
            Throwable target = e.getTargetException();
            if (target.getClass().equals(new IllegalArgumentException().getClass())) {
                fails = true;
            }
        } finally {
            if (fails == false) {
                assertTrue(false, "Testing number of params for Circle constructor failed");
            }
        }
    }    

    @Test
    public void TestRectangleClass() throws Throwable {
        try {
            Class<?> lazz = Class.forName("designpatterns.Rectangle");
            rConst = lazz.getConstructor(Double[].class);
            if (Shape.class.isAssignableFrom(lazz) == false) {
                assertTrue(false, "Rectangle class does not implement interface Shape");
            }
        } catch (Exception e) {
            assertTrue(false, "Class Rectangle declaration is incorrect");
        }
        Double[] ras = { 5.0, 7.0 };
        Object[] rargs = { ras };
        Object r = (Rectangle)rConst.newInstance(rargs);
        // test getparams
        Double[] actualParams = (Double[]) getParamsHandle.invoke((Rectangle)r);
        assertEquals(ras[0], actualParams[0], 0.01, "getParams method for Rectangle is not correctly implemented");
        assertEquals(ras[1], actualParams[1], 0.01, "getParams method for Rectangle is not correctly implemented");        // test getarea
        Double expected = 35.0; // failaa
        Double actual = (Double) getAreaHandle.invoke((Rectangle)r);
        assertEquals(expected, actual, "getArea method for Rectangle is not correctly implemented");

        Boolean fails = false;
        try {
            Double[] initargs = { 4.4, 6.7, 3.4 };
            Object[] rrargs = { initargs };
            Object rr = rConst.newInstance(rrargs);
        } catch (InvocationTargetException e) {
            Throwable target = e.getTargetException();
            if (target.getClass().equals(new IllegalArgumentException().getClass())) {
                fails = true;
            }
        } finally {
            if (fails == false) {
                assertTrue(false, "Testing number of params for Rectangle constructor failed");
            }
        }

        fails = false;
        try {
            Double[] initargs = { };
            Object[] rrargs = { initargs };
            Object rr = rConst.newInstance(rrargs); // vaihdettu cConst -> rConst ohjeiden mukaisesti
        } catch (InvocationTargetException e) {
            Throwable target = e.getTargetException();
            if (target.getClass().equals(new IllegalArgumentException().getClass())) {
                fails = true;
            }
        } finally {
            if (fails == false) {
                assertTrue(false, "Testing number of params for Rectangle constructor failed");
            }
        }
    }    

    @Test
    public void TestShapeFactory() throws Throwable {
        try {
            // Test Logger class
            Class<?> lazz = Class.forName("designpatterns.ShapeFactory");
            // create method
            createMethod = lazz.getMethod("create", String.class, Double[].class);            
            if (Modifier.isStatic(createMethod.getModifiers()) == false) {
                assertTrue(false, "Method create must be static");
            }            
        } catch (Exception e) {
            assertTrue(false, "Error in ShapeFactory class declaration");
        }

        Double[] params = { 2.5};
        Shape s = (Shape)createMethod.invoke(null, "circle", params);
        Double expected = 19.634;
        Double actual = (Double) getAreaHandle.invoke(s);
        assertEquals(expected,actual,0.01, "ShapeFactory created instance of Circle, but getArea has wrong output");

        Double[] params2 = { 9.14, 8.76 };
        s = (Shape)createMethod.invoke(null, "rectangle", params2);
        expected = 80.0664;
        actual = (Double) getAreaHandle.invoke(s);
        assertEquals(expected,actual,0.01, "ShapeFactory created instance of Rectangle, but getArea has wrong output");

    }
}
