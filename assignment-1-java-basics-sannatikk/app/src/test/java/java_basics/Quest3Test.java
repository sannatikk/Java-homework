package java_basics;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Quest 3")
public class Quest3Test {

  private static Quest3 quest3;
  private static ByteArrayOutputStream outContent;

  @BeforeEach
  public void init() {
    quest3 = new Quest3();
    outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
  }

  @AfterAll
  public static void cleanUp() {
    quest3 = null;
    outContent = null;
  }

  @Test
  @DisplayName("Test greeting two visitors")
  public void testGreet() {
    quest3.greet(2);
    assertEquals("Hello 1!" + System.lineSeparator() +
      "Hello 2!" + System.lineSeparator(), outContent.toString(),
      "Incorrect result when greeting visitors");
  }

  @Test
  @DisplayName("Test greeting five visitors")
  public void testGreetFive() {
    quest3.greet(5);
    assertEquals("Hello 1!" + System.lineSeparator() +
      "Hello 2!" + System.lineSeparator() +
      "Hello 3!" + System.lineSeparator() +
      "Hello 4!" + System.lineSeparator() +
      "Hello 5!" + System.lineSeparator(), outContent.toString(),
      "Incorrect result when greeting five visitors");
  }
}
