package designpatterns;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SingletonPatternTest {

    private static MethodHandle logHandle;
    private static Method getInstanceMethod;

    @BeforeEach
    public void setUp() throws Throwable {

        try {
            // Test Logger class
            Class<?> lazz = Class.forName("designpatterns.Logger");
            // getInstance method
            // MethodType type = MethodType.methodType(Logger.class);
            // getInstanceHandle = MethodHandles.lookup().findVirtual(lazz, "getInstance", type);        
            getInstanceMethod = lazz.getMethod("getInstance");            
            if (Modifier.isStatic(getInstanceMethod.getModifiers()) == false) {
                assertTrue(false, "Method getInstance must be static");
            }
            // log method
            MethodType type = MethodType.methodType(String.class, String.class);
            logHandle = MethodHandles.lookup().findVirtual(lazz, "log", type);        
        } catch (Exception e) {
            assertTrue(false, "Class Logger declaration is incorrect");
        }
    }

    @Test
    public void testSingletonPattern() throws Throwable {

        Logger l1 = (Logger)getInstanceMethod.invoke(null);
        Logger l2 = (Logger)getInstanceMethod.invoke(null);
        assertSame(l1, l2, "Logger singleton instances are not the same");
    }

    @Test
    public void testLogging() throws Throwable {
        Logger logger = (Logger)getInstanceMethod.invoke(null);
        String expected = "Logger: Testing";
        String actual = (String)logHandle.invoke(logger, "Testing");
        assertEquals(expected, actual, "Log message not the expected");
    }
}
