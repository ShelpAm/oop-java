class Week1 {
  public static void main(String[] args) {
    Week1 w1 = new Week1();

    System.out.println("Sum of 1-10: " + w1.sum(10));
    System.out.println();

    w1.show_9x9_multiplication_table();
    System.out.println();

    w1.print_letters();
    System.out.println();
  }

  private int sum(int n) {
    int s = 0;
    for (int i = 1; i != n + 1; ++i) {
      s += i;
    }
    return s;
  }

  private void show_9x9_multiplication_table() {
    System.out.println("9x9 multiplication table:");
    for (int i = 1; i != 10; ++i) {
      for (int j = 1; j != i + 1; ++j) {
        System.out.print(j + " * " + i + " = " + i * j + " | ");
      }
      System.out.println();
    }
  }

  private void print_letters() {
    System.out.println("English letters:");
    for (char c = 'a'; c != 'z' + 1; ++c) {
      System.out.print(c);
    }
    for (char c = 'A'; c != 'Z' + 1; ++c) {
      System.out.print(c);
    }
    System.out.println();

    System.out.println("Greek alphabet:");
    for (char c='α'; c != 'ω' + 1; ++c) {
      System.out.print(c);
    }
    System.out.println();
  }
}

