package shelpam.week8;

public class Circle extends Shape {
  private double r;

  public Circle(double r) {
    super("Circle");

    if (r < 0) {
      throw new IllegalArgumentException("'r' should be non-negative");
    }

    this.r = r;
  }

  @Override
  public String toString() {
    return "r = " + r;
  }

  @Override
  public double area() {
    return Math.PI * r * r;
  }

  @Override
  public double perimeter() {
    return 2 * Math.PI * r;
  }
}
