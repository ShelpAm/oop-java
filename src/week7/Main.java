package shelpam.week7;

public class Main {
  public static void main(String[] args) {
    Triangle sj = Triangle.fromEdges(2, 3, 4);
    assert sj.equals(sj) : "Self not equal";

    Triangle t2 = Triangle.fromEdges(3, 2, 4);
    assert sj.equals(t2) : "Congruent triangles not congruent";

    Triangle t3 = Triangle.fromEdges(3, 4, 5);
    RightTriangle rt1 = RightTriangle.fromCatheti(3, 4);
    assert rt1.equals(t3) : "Hypotenuse deduction error";

    rt1.trySetEdges(6, 8);
    // System.out.println(rt1);
    var rt2 = RightTriangle.fromEdges(8, 6, 10);
    // System.out.println(rt2);
    assert rt1.equals(rt2) : "Switching of catheti breaks congruence";

    rt2.trySetEdges(3, 5, 4);
    assert rt1.equals(rt2) : "Ill-formed triangle";

    for (int i = 1; i != 3; ++i) {
      Rectangle.makeSquared(i);
      Rectangle.makeRectangular(i, i + 1);
    }
    Rectangle nullPointer = Rectangle.makeRectangular(1, 0);
    assert nullPointer == null : "0 length rectangle";

    Rectangle nonNull = Rectangle.makeSquared(1);
    assert nonNull != null : "A non-null is resolved to null";

    nullPointer = Rectangle.makeSquared(2);
    // System.out.println(nullPointer);
    assert nullPointer == null : "Total count of `Rectangle`s exceeds the maximum";

    System.out.println("All tests passed!");
  }
}
