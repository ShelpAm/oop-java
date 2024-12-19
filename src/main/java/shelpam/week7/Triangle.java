package shelpam.week7;

public class Triangle {
  protected static final DoubleComparator dc = new DoubleComparator(1e-8);
  protected double a, b, c;

  @Override
  public String toString() {
    return "a: " + a + ", b: " + b + ", c: " + c;
  }

  private static boolean valid(double a, double b, double c) {
    return a + b > c && b + c > a && a + c > b;
  }

  public static Triangle fromEdges(double a, double b, double c) {
    if (!valid(a,b,c)) {
      return new Triangle(1, 1, 1);
    }
    return new Triangle(a, b, c);
  }
  // 要求不明："构造三角形对象时，可提供1/2/3条边", 1/2条边含义不明确

  protected Triangle(double a, double b, double c) {
    setEdges(a, b, c);
  }

  protected void setEdges(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public void trySetEdges(double a, double b, double c) {
    if (valid(a, b, c)) {
      setEdges(a, b, c);
    }
  }

  @Override
  public boolean equals(Object obj) {
    Triangle other = (Triangle)obj;

    double[] free = {other.a, other.b, other.c};

    for (int i = 0; i != free.length; ++i) {
      if (dc.isEqual(free[i], a)) {
        free[i] = 0;
        break;
      }
    }

    for (int i = 0; i != free.length; ++i) {
      if (dc.isEqual(free[i], b)) {
        free[i] = 0;
        break;
      }
    }

    for (int i = 0; i != free.length; ++i) {
      if (dc.isEqual(free[i], c)) {
        free[i] = 0;
        break;
      }
    }

    // All zeros (3 edges equal).
    for(int i = 0; i != free.length; ++i) {
      if (!dc.isEqual(free[i], 0)) {
        return false;
      }
    }
    return true;
  }
}
