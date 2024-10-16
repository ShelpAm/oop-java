package shelpam.week7;

public class Main {
  public static void main(String[] args) {
    Triangle sj = Triangle.makeFromEdges(2, 3, 4);
    assert sj.equals(sj) : "Self not equal";

    Triangle t2 = Triangle.makeFromEdges(3, 2, 4);
    assert sj.equals(t2) : "Congruent triangles not congruent";

    Triangle t3 = Triangle.makeFromEdges(3, 4, 5);
    RightTriangle rt1 = RightTriangle.makeFromCatheti(3, 4);
    assert rt1.equals(t3) : "Hypotenuse deduction error";

    System.out.println("All tests passed!");
  }
}
