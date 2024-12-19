package shelpam.week8;

public class Triangle extends Shape {
  private double a, b, c;

  private static boolean valid(double a, double b, double c) {
    return a + b > c && b + c > a && a + c > b;
  }

  public Triangle(double a, double b, double c) {
    super("Triangle");

    if (!valid(a, b, c)) {
      throw new IllegalArgumentException("Given edges can't form a valid triangle");
    }

    this.a = a;
    this.b = b;
    this.c = c;
  }

  @Override
  public String toString() {
    return "a = " + a + ", b = " + b + ", c = " + c;
  }

  @Override
  public double area() {
    final double p = (a + b + c) / 2;
    return Math.sqrt(p * (p - a) * (p - b) * (p - c));
  }

  @Override
  public double perimeter() {
    return a + b + c;
  }
}

