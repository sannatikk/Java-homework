package oop;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class VehicleTest {
  private static Constructor<?> vconst;

  @BeforeEach
  public void setUp() throws Exception {
    Class<?> v = Class.forName("oop.Vehicle");
    Class<?>[] vTypes = { Double.class };
    try {
      vconst = v.getConstructor(vTypes);
    } catch (NoSuchMethodException e) {
      assertTrue(false, "Vehicle class or constructor is wrong");    
    }
  }

  @Test
  @DisplayName("Test fuel consumption with constructor")
  public void testConstructor() throws Throwable {
    // Vehicle v = new Vehicle(150.0);
    Object[] vargs = { 150.0 };
    Vehicle v = (Vehicle) vconst.newInstance(vargs);    
    // v.setFuelUsed(7.6);
    MethodType methodType = MethodType.methodType(void.class, Double.class);
    MethodHandle setFuelUsedHandle = MethodHandles.lookup().findVirtual(Vehicle.class, "setFuelUsed", methodType);
    setFuelUsedHandle.invoke(v, 7.6);
    // Double actual = v.getFuelConsumption();
    methodType = MethodType.methodType(Double.class);
    MethodHandle getFuelConsumptionHandle = MethodHandles.lookup().findVirtual(Vehicle.class, "getFuelConsumption", methodType);
    Double actual = (Double) getFuelConsumptionHandle.invoke(v);
    assertEquals(5.1, actual, 0.1, "Fuel consumption is wrong");
  }

  @Test
  @DisplayName("Test fuel consumption with setters")
  public void testDoubleFuelConsumption() throws Throwable {
    // Vehicle v = new Vehicle(114.0);
    Object[] vargs = { 114.0 };
    Vehicle v = (Vehicle) vconst.newInstance(vargs);    
    // v.setFuelUsed(6.4);
    MethodType methodType = MethodType.methodType(void.class, Double.class);
    MethodHandle setFuelUsedHandle = MethodHandles.lookup().findVirtual(Vehicle.class, "setFuelUsed", methodType);
    setFuelUsedHandle.invoke(v, 6.4);
    // Double actual = v.getFuelConsumption();
    methodType = MethodType.methodType(Double.class);
    MethodHandle getFuelConsumptionHandle = MethodHandles.lookup().findVirtual(Vehicle.class, "getFuelConsumption", methodType);
    Double actual = (Double) getFuelConsumptionHandle.invoke(v);
    assertEquals(5.61, actual, 0.1, "Fuel consumption is calculated wrong");
  }
}

