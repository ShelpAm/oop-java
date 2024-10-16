package shelpam.week7;

public class RightTriangle extends Triangle {
  // a and b are catheti.
  public static RightTriangle makeFromCatheti(double a, double b) {
    if (a <= 0 || b <= 0) {
      return new RightTriangle(3, 4);
    }
    return new RightTriangle(a, b);
  }

  // a and b are catheti.
  public static RightTriangle makeFromEdges(double a, double b, double hypotenuse) {
    if (!Triangle.valid(a, b, hypotenuse) || a * a + b * b != hypotenuse * hypotenuse) {
      return new RightTriangle(3, 4);
    }
    return new RightTriangle(a, b);
  }

  private RightTriangle(double a, double b) {
    super(a, b, Math.sqrt(a * a + b * b));
  }
}
