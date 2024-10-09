package oop;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class ApartmentTest {
  private static MethodHandle heatingCostHandle; 
  private static Constructor<?> aconst;

  @BeforeEach
  public void setUp() throws Exception {
    try {
      Class<?> a = Class.forName("oop.Apartment");
      Class<?>[] aTypes = { Integer.class, Integer.class };
      aconst = a.getConstructor(aTypes);
      MethodType methodType = MethodType.methodType(Float.class, Float.class);
      heatingCostHandle = MethodHandles.lookup().findVirtual(Apartment.class, "heatingCost", methodType);  
    } catch (NoSuchMethodException e) {
      assertTrue(false, "Apartment class or its constructor is wrong");    
    }
  }

  @Test
  @DisplayName("Test if the heating cost is calculated correctly")
  public void testHeatingCost() throws Throwable {
    // Apartment apartment = new Apartment(3, 100);
    Object[] initargs = { 3, 100 };
    Apartment apartment = (Apartment) aconst.newInstance(initargs);
    Float price = 0.1f;
    Float expected = 30.0f;
    Float actual = (Float) heatingCostHandle.invoke(apartment, price);
    assertEquals(expected, actual, "Unexpected heating cost when the price is " + price);
  }

  @Test
  @DisplayName("Test if the heating cost is calculated correctly when number of tenants is 0")
  public void testHeatingCostWithZeroTenants() throws Throwable {
    // Apartment apartment = new Apartment(0, 100);
    Object[] initargs = { 0, 100 };
    Apartment apartment = (Apartment) aconst.newInstance(initargs);
    Float price = 0.1f;
    Float expected = 0.0f;
    Float actual = (Float) heatingCostHandle.invoke(apartment, price);
    assertEquals(expected, actual, "Unexpected heating cost when the number of tenants is 0");
  }

  @Test
  @DisplayName("Test if the heating cost is calculated correctly when area is 44")
  public void testHeatingCostWithArea44() throws Throwable {
    // Apartment apartment = new Apartment(3, 44);
    Object[] initargs = { 3, 44 };
    Apartment apartment = (Apartment) aconst.newInstance(initargs);
    Float price = 0.1f;
    Float expected = 13.2f;
    Float actual = (Float) heatingCostHandle.invoke(apartment, price);
    assertEquals(expected, actual, "Unexpected heating cost when the area is 44");
  }

}

