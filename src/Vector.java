import java.util.Arrays;
import java.util.Scanner;

// 顺序表
public class Vector {
  public static Vector fromScanner(Scanner scanner) {
    System.out.println("Enter the size of list:");
    int size = scanner.nextInt();
    int[] list = new int[size];

    System.out.println("Enter elements in the list:");
    for (int i = 0; i != size; ++i) {
      list[i] = scanner.nextInt();
    }

    Vector result = new Vector();
    result.append(list);
    return result;
  }

  public Vector(int maxSize) {
    this.size = 0;
    this.data = new int[maxSize];
  }

  public Vector() {
    int defaultMaxSize = 10;
    this.size = 0;
    this.data = new int[defaultMaxSize];
  }

  public void append(int[] range) {
    this.reserve(size + range.length);

    for (int i = 0; i != range.length; ++i) {
      this.data[this.size] = range[i];
      ++this.size;
    }
  }

  public void show() {
    System.out.println("Vector size: " + size);
    System.out.println(this);
  }

  public String toString() {
    String result = "";
    for (int i = 0; i != size; ++i) {
      result += data[i] + " ";
    }
    return result;
  }

  // Prepends y to this
  public void merge(Vector y) {
    Vector neo = merge(y, this);
    this.size = neo.size;
    this.data = neo.data;
  }

  private void reserve(int capacity) {
    if (capacity <= data.length) {
      return;
    }

    int newCapacity = data.length;
    while (newCapacity < capacity) {
      newCapacity = (newCapacity * 3 + 1) / 2;
    }

    int[] newData = new int[newCapacity];
    for (int i = 0; i != this.size; ++i) {
      newData[i] = this.data[i];
    }
    this.data = newData;
  }

  private static Vector merge(Vector x, Vector y) {
    Vector result = new Vector();
    result.append(Arrays.copyOfRange(x.data, 0, x.size));
    result.append(Arrays.copyOfRange(y.data, 0, y.size));
    return result;
  }

  private int size;
  private int[] data;
}
