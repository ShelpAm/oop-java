package shelpam.week8;

public class Rectangle extends Shape {
  private double a, b;

  public Rectangle(double a, double b) {
    super("Rectangle");

    if (a <= 0 || b <= 0) {
      throw new IllegalArgumentException("'a' and 'b' should be positive");
    }

    this.a = a;
    this.b = b;
  }

  @Override
  public String toString() {
    return "a = " + a + ", b = " + b;
  }

  @Override
  public double area() {
    return a * b;
  }

  @Override
  public double perimeter() {
    return 2 * (a + b);
  }
}
