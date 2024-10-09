package java_basics;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Quest 1")
public class Quest1Test {

  private static Quest1 quest1;
  private static ByteArrayOutputStream outContent;

  @BeforeEach
  public void init() {
    quest1 = new Quest1();
    outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
  }

  @AfterAll
  public static void cleanUp() {
    quest1 = null;
    outContent = null;
  }

	@Test
  @DisplayName("Test multiplying by zero")
	public void testMultiplyByZero() {
		quest1.multiply(5, 0);
		assertEquals("1" + System.lineSeparator(), outContent.toString(),
      "Incorrect output when multiplying by zero");
	}

  @Test
  @DisplayName("Test multiplying two numbers")
  public void testMultiply() {
    quest1.multiply(5, 3);
    assertEquals("31" + System.lineSeparator(), outContent.toString(),
      "Incorrect output when multiplying two numbers");
  }
}
