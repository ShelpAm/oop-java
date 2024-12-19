package shelpam.week8;

public class Trapezoid extends Shape {
  private double a, b, h;

  public Trapezoid(double a, double b, double h) {
    super("Trapezoid");

    if (a <= 0 || b <= 0 || h <= 0) {
      throw new IllegalArgumentException("'a', 'b', and 'h' should be positive");
    }

    this.a = a;
    this.b = b;
    this.h = h;
  }

  @Override
  public String toString() {
    return "a = " + a + ", b = " + b + ", h = " + h;
  }

  @Override
  public double area() {
    return (a + b) * h / 2;
  }
}
