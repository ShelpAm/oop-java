package shelpam.week8;

public abstract class Shape {
  private String name;

  protected Shape(String name) {
    this.name = name;
  }

  public String name() {
    return this.name;
  }

  public double area() {
    throw new UnsupportedOperationException("no enough information to " +
      "calculate area");
  }

  public double perimeter() {
    throw new UnsupportedOperationException("no enough information to " +
      "calculate perimeter");
  }
}
