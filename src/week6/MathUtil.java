package shelpam.week6;

import java.util.Arrays;
import java.util.Random;

public class MathUtil {
  private int[][] a;
  private int sum = -1;
  private int num = -1;

  public MathUtil() {
    Random rand = new Random();

    final int n = rand.nextInt(9) + 1;
    a = new int[n][];

    System.out.println("The first dimension of a is " + n + ".");

    for (int i = 0; i != n; ++i) {
      int m;
      boolean any;
      do {
        any = false;
        m = rand.nextInt(9) + 1;
        for (int j = 0; j != i; ++j) {
          any |= m == a[j].length;
        }
      } while (any);
      a[i] = new int[m];
      for (int j = 0; j != a[i].length; ++j) {
        a[i][j] = rand.nextInt(9) + 1;
      }
    }
  }

  public int sum() {
    if (this.sum == -1) { // Cache
      sum = 0;
      num = 0;
      for (var b : a) {
        num += b.length;
        for (var e : b) {
          sum += e;
        }
      }
    }
    return sum;
  }

  public void showMe() {
    sum(); // Pre-calculate the number of elements and the accumulative sum.

    for (final var b : a) {
      for (var e : b) {
        System.out.print(e + " ");
      }
      System.out.println();
    }
    System.out.println("\nTotally " + num + " elements. And their accumulative sum is " + sum + ".\n");
  }
}
