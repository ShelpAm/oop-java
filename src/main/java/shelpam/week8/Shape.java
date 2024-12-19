package shelpam.week8;

// 本例中未使用“返回-1”的方法来标识“属性不可被获取”，而是通过使用异常，
// 使得类使用者不会误用此类。

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
