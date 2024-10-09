package java_basics;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Quest 2")
public class Quest2Test {

  private static Quest2 quest2;
  private static ByteArrayOutputStream outContent;

  @BeforeEach
  public void init() {
    quest2 = new Quest2();
    outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
  }

  @AfterAll
  public static void cleanUp() {
    quest2 = null;
    outContent = null;
  }

  @Test
  @DisplayName("Test positive number")
  public void testPositiveNumber() {
    quest2.checkNum(5);
    assertEquals("pos" + System.lineSeparator(), outContent.toString(),
      "Incorrect output when the number is positive");
  }

  @Test
  @DisplayName("Test negative number")
  public void testNegativeNumber() {
    quest2.checkNum(-5);
    assertEquals("neg" + System.lineSeparator(), outContent.toString(),
      "Incorrect output when the number is negative");
  }

  @Test
  @DisplayName("Test zero")
  public void testZero() {
    quest2.checkNum(0);
    assertEquals("zero" + System.lineSeparator(), outContent.toString(),
      "Incorrect output when the number is zero");
  }
}
