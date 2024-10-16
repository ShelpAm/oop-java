package shelpam.week7;

public class DoubleComparator {
  private double epsilon;

  public DoubleComparator(double epsilon) {
    this.epsilon = epsilon;
  }

  public boolean isEqual(double a, double b) {
    return Math.abs(a - b) < epsilon;
  }
}
