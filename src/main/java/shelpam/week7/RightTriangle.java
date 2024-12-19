package shelpam.week7;

public class RightTriangle extends Triangle {
  private static boolean valid(double a, double b) {
    return a > 0 && b > 0;
  }

  private static boolean valid(double a, double b, double hypotenuse) {
    return valid(a, b) && dc.isEqual(a * a + b * b, hypotenuse * hypotenuse);
  }

  // a and b are catheti.
  public static RightTriangle fromCatheti(double a, double b) {
    if (a <= 0 || b <= 0) {
      return new RightTriangle(3, 4);
    }
    return new RightTriangle(a, b);
  }

  // a and b are catheti.
  public static RightTriangle fromEdges(double a, double b, double hypotenuse) {
    if (!valid(a, b, hypotenuse)) {
      return new RightTriangle(3, 4);
    }
    return new RightTriangle(a, b);
  }

  private RightTriangle(double a, double b) {
    super(a, b, Math.sqrt(a * a + b * b));
  }

  public void trySetEdges(double a, double b) {
    if (valid(a, b)) {
      setEdges(a, b, Math.sqrt(a * a + b * b));
    }
  }

  @Override
  public void trySetEdges(double a, double b, double c) {
    if (valid(a, b, c)) {
      setEdges(a, b, c);
    }
  }

  public boolean equals(RightTriangle other) {
    return (dc.isEqual(a, other.a) && dc.isEqual(b, other.b) ||
           dc.isEqual(a, other.b) && dc.isEqual(b, other.a)) &&
           dc.isEqual(c, other.c);
  }
}
