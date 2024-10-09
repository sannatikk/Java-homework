package exercises;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileTest {
    
    private static MethodHandle playHandle;
    private static MethodHandle pauseHandle;
    private static MethodHandle stopHandle;
    private static Constructor<?> vConstructor;

    @BeforeEach
    public void setUp() throws Exception {
        try {
            // Test that Shape is abstract class
            Class<?> clazz = Playable.class; 
            boolean isInterface = Modifier.isInterface(clazz.getModifiers());
            if (isInterface == false) {
                assertTrue(false, "Playable class must be interface");
            }

            // Setup for VideoFile class
            Class<?> vClass = Class.forName("exercises.VideoFile");
            vConstructor = vClass.getConstructor();
            MethodType type = MethodType.methodType(String.class);
            playHandle = MethodHandles.lookup().findVirtual(vClass, "play", type);
            type = MethodType.methodType(String.class, Integer.class);
            pauseHandle = MethodHandles.lookup().findVirtual(vClass, "pause", type);
            type = MethodType.methodType(String.class);            
            stopHandle = MethodHandles.lookup().findVirtual(vClass, "stop", type);
                        
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            assertTrue(false, "Class VideoFile declaration is incorrect");
        }
    }
 
    @Test
    @DisplayName("Test VideoFile with interface Playable")
    public void testPlayableInterface() throws Throwable {
        try {
            // Create Circle instance with name "Circle" and radius 5.0
            Object v = vConstructor.newInstance();
            Field field = VideoFile.class.getDeclaredField("fileName");
            field.setAccessible(true);
            field.set(null, "Ludwig van Beethoven - Ode an die Freude.mp4");
            field.setAccessible(false);

            // Play method
            String expected = "Playing videofile: Ludwig van Beethoven - Ode an die Freude.mp4";
            assertEquals(expected, (String) playHandle.invoke(v), "Play method is not correctly implemented");

            // Pause method
            expected = "Videofile Ludwig van Beethoven - Ode an die Freude.mp4 paused for 20 seconds";
            assertEquals(expected, (String) pauseHandle.invoke(v,20), "Pause method is not correctly implemented");
            expected = "Videofile Ludwig van Beethoven - Ode an die Freude.mp4 paused for 60 seconds";
            assertEquals(expected, (String) pauseHandle.invoke(v,60), "Pause method is not correctly implemented");

            // Stop method
            expected = "Videofile Ludwig van Beethoven - Ode an die Freude.mp4 stopped";
            assertEquals(expected, (String) stopHandle.invoke(v), "Stop method is not correctly implemented");

            field.setAccessible(true);
            field.set(null, "Sash! - La Primavera.mp4");
            field.setAccessible(false);

            // Stop method
            expected = "Videofile Sash! - La Primavera.mp4 stopped";
            assertEquals(expected, (String) stopHandle.invoke(v), "Stop method is not correctly implemented");

        } catch (Exception e) {
            assertTrue(false, "Errors in VideoFile class implementation" + e.getMessage());
        }
    }
}
