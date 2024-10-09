package java_basics;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Quest 5")
public class Quest5Test {

  private static Quest5 quest5;
  private static ByteArrayOutputStream outContent;
  private static MethodHandle factorialHandle;

  @BeforeEach
  public void init() throws Exception {
    quest5 = new Quest5();
    outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    MethodType methodType = MethodType.methodType(void.class, Integer.class);
    factorialHandle = MethodHandles.lookup().findVirtual(Quest5.class, "factorial", methodType);
  }

  @AfterAll
  public static void cleanUp() {
    quest5 = null;
    outContent = null;
  }

  @Test
  @DisplayName("Test calculating factorial of 5")
  public void testFactorial() throws Throwable {
    factorialHandle.invoke(quest5, 5);
    assertEquals("120" + System.lineSeparator(), outContent.toString(),
      "Incorrect result when calculating factorial of 5");
  }

  @Test
  @DisplayName("Test calculating factorial of 0")
  public void testFactorialZero() throws Throwable {
    factorialHandle.invoke(quest5, 0);
    assertEquals("not allowed" + System.lineSeparator(), outContent.toString(),
      "Incorrect result when calculating factorial of 0");
  }

  @Test
  @DisplayName("Test calculating factorial of 21")
  public void testFactorialTwentyOne() throws Throwable {
    factorialHandle.invoke(quest5, 21);
    assertEquals("not allowed" + System.lineSeparator(), outContent.toString(),
      "Incorrect result when calculating factorial of 21");
  }

  @Test
  @DisplayName("Test calculating factorial of -1")
  public void testFactorialNegativeOne() throws Throwable {
    factorialHandle.invoke(quest5, -1);
    assertEquals("not allowed" + System.lineSeparator(), outContent.toString(),
      "Incorrect result when calculating factorial of -1");
  }

  @Test
  @DisplayName("Test calculating factorial of 12")
  public void testFactorialTwelve() throws Throwable {
    factorialHandle.invoke(quest5, 12);
    assertEquals("479001600" + System.lineSeparator(), outContent.toString(),
      "Incorrect result when calculating factorial of 12");
  }
}
