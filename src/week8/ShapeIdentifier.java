package shelpam.week8;

public class ShapeIdentifier {
  public String getArea(Shape s) {
    try {
      return "" + s.area();
    } catch (Exception e) {
      return "Uncomputable";
    }
  }

  public String getPerimeter(Shape s) {
    try {
      return "" + s.perimeter();
    } catch (Exception e) {
      return "Uncomputable";
    }
  }

  public void identify(Shape s) {
    System.out.println("Name (type): " + s.name());
    System.out.println("Basic info: " + s);
    System.out.println("Area: " + getArea(s));
    System.out.println("Perimeter: " + getPerimeter(s));
  }
}
