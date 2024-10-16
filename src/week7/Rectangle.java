package shelpam.week7;

public class Rectangle {
  static int totalCount = 0;
  static final int maxCount = 5;
  private double a, b;

  @Override
  public String toString() {
    System.out.println(totalCount);
    return "a: " + a + ", b: " + b;
  }

  private static boolean valid(double a) {
    return a > 0;
  }

  private static boolean valid(double a, double b) {
    return a > 0 && b > 0;
  }

  public static Rectangle makeSquared(double a) {
    if (totalCount == maxCount || !valid(a)) {
      return null;
    }
    ++totalCount;
    return new Rectangle(a);
  }

  public static Rectangle makeRectangular(double a, double b) {
    if (totalCount == maxCount || !valid(a, b)) {
      return null;
    }
    ++totalCount;
    return new Rectangle(a, b);
  }


  private Rectangle(double a) {
    this.a = this.b = a;
  } 

  private Rectangle(double a, double b) {
    this.a = a;
    this.b = b;
  } 
}
