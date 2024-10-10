import java.util.Scanner;

public class LinkedList {
  public static LinkedList fromScanner(Scanner sc) {
    System.out.println("Input a list of number, ending with -1 (excluded).");

    LinkedList list = new LinkedList();
    LinkedList.Node p = list.head();
    do {
      int x = sc.nextInt();
      if (x == -1) {
        break;
      }
      p = list.insertAfter(p, x);
    } while (true);

    return list;
  }

  public class Node {
    public Node() {}

    public Node(int data) {
      this.data = data;
    }

    public int data() {
      return this.data;
    }

    public Node next() {
      return this.next;
    }

    public void setNext(Node next) {
      this.next = next;
    }

    private int data;
    private Node next;
  }

  public LinkedList() {
    this.head = new Node();
    this.tail = this.head;
  }

  public Node head() {
    return this.head;
  }

  public Node tail() {
    return this.tail;
  }

  public Node begin() {
    return head.next;
  }

  public Node insertAfter(Node position, int data) {
    Node node = new Node(data);

    if (position == this.tail) {
      this.tail = node;
    }

    node.next = position.next;
    position.next = node;
    return node;
  }

  public Node insertSorted(int data) {
    Node p = this.head;
    while (p.next != null && p.next.data < data) {
      p = p.next();
    }
    return insertAfter(p, data);
  }

  public void merge(LinkedList other) {
    this.tail.next = other.head.next;
    this.tail = other.tail;
  }

  public String toString() {
    String result = "";
    Node p = this.head.next();
    while (p != null) {
      result += p.data() + " ";
      p = p.next();
    }
    return result;
  }

  private Node head; // Head node, not intended for storing data.
  private Node tail;
}
