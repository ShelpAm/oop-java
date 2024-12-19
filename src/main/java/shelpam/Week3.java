import java.util.Scanner;

public class Week3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Input number ascendingly to conform to following tests.");

    LinkedList list1 = LinkedList.fromScanner(sc);
    System.out.println("list1: " + list1);

    LinkedList list2 = LinkedList.fromScanner(sc);
    System.out.println("list2: " + list2);

    list1.merge(list2);
    System.out.println("After merging (list1.merge(list2)) list1: " + list1);

    System.out.println("Input a number, which will be inserted ascendingly:");
    int x = sc.nextInt();
    list1.insertSorted(x);
    System.out.println("Result: " + list1);
  }
}
