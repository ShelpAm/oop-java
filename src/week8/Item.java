package shelpam.week8;

// Because behaviors of items in supermarket don't differ, we don't need to make
// diffrent classes.

public class Item {
  private int price;
  private String name;

  public Item(int price, String name) {
    this.price = price;
    this.name = name;
  }

  public int price() {
    return this.price;
  }

  public String name() {
    return this.name;
  }
}
