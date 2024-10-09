package java_basics;

/*
 * Modify the code below to:
 * 
 * Print out to console string "pos" if the function parameter num is positive
 * Print out to console string "neg" if num is negative
 * Print out to console string "zero" if num equals zero
 */

public class Quest2 {
  public void checkNum(Integer num) {
    if (num == 0) {
      System.out.println("zero");
    }
    else if (num > 0) {
      System.out.println("pos");
    }
    else {
      System.out.println("neg");
    }
  }
}
