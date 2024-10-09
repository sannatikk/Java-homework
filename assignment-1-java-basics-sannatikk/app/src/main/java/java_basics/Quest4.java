package java_basics;

/*
 * Modify the method below to print out all even numbers above zero until the
 * function parameter limit. The numbers are separated by comma and printed
 * without new line.
 * 
 * Example output when limit is 9:
 * 2,4,6,8
 */

public class Quest4 {
  public void oddOut(Short limit) {
    if (limit < 2) {
      System.out.println("No even numbers to print.");
    }
    else {
      for (short i = 2; i <= limit; i+=2) {
        if (i + 2 > limit) {
          System.out.print(i);
        } else {
        System.out.print(i + ",");
      }
    }
  }
}
}