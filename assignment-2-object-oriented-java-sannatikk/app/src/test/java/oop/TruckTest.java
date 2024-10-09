package oop;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Test class Truck")
public class TruckTest {
    private static Constructor<?> tconst;

    @BeforeEach
    public void setUp() {
        try {
            Class<?> t = Class.forName("oop.Truck");
            Class<?>[] tTypes = { String.class, String.class, Integer.class, Double.class };    
            tconst = t.getConstructor(tTypes);
        } catch (Exception e) {
            assertTrue(false, "Truck class or constructor is incorrect");    
        }
    }

    @Test
    @DisplayName("Test Vehicle Inheritance")
    public void testInheritance() {
        Class<?> truck = Truck.class;
        Class<?> vehicle = truck.getSuperclass();
        assertNotNull(vehicle, "Parent class is null");
        assertEquals(Vehicle.class, vehicle, "Incorrect inheritance in Truck class");
    }

    @Test
    @DisplayName("Test truck details")
    public void testTruckDetails() throws Throwable {
        // Truck truck = new Truck("Ford", "F-150", 2021, 12005.5);
        Object[] targs = { "Ford", "F-150", 2021, 12005.5 };
        Truck t = (Truck) tconst.newInstance(targs);    
        // String res = truck.getDetails();
        MethodType methodType = MethodType.methodType(String.class);
        MethodHandle getDetailsHandle = MethodHandles.lookup().findVirtual(Truck.class, "getDetails", methodType);
        String res = (String) getDetailsHandle.invoke(t);
        assertEquals("2021 Ford F-150", res, "Incorrect truck details");
    }

    @Test
    @DisplayName("Test Truck fuel consumed")
    public void testVehicleStartStop() throws Throwable {
        // Truck truck = new Truck("Ford", "F-150", 2021, 12005.5);
        Object[] targs = { "Ford", "F-150", 2021, 12005.5 };
        Truck t = (Truck) tconst.newInstance(targs);    
        // truck.setFuelUsed(1756.0);
        MethodType methodType = MethodType.methodType(void.class, Double.class);
        MethodHandle setFuelUsedHandle = MethodHandles.lookup().findVirtual(Truck.class, "setFuelUsed", methodType);
        setFuelUsedHandle.invoke(t, 1656.0);
        // Double actual = truck.getFuelConsumption();
        methodType = MethodType.methodType(Double.class);
        MethodHandle getFuelConsumptionHandle = MethodHandles.lookup().findVirtual(Truck.class, "getFuelConsumption", methodType);
        Double actual = (Double) getFuelConsumptionHandle.invoke(t);    
        assertEquals(13.8, actual, 0.1, "Fuel consumption test failed");
    }
}
