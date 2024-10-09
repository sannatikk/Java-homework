package java_basics;

/*
 * Modify the method below to greet all visitors by printing out to console
 * the string "Hello n!" for each of them, where n is the number of visitor,
 * starting from 1.
 */

public class Quest3 {
  public void greet(Integer visitors) {
    for (int i = 1; i <= visitors; i++) {
      System.out.println("Hello " + i + "!");
    }
  }
}
