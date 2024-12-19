package shelpam.week8;

public class ItemSet {
  private int numberOfItems;
  private Item item;

  public ItemSet(int numberOfItems, Item item) {
    if (item == null || numberOfItems < 0) {
      throw new IllegalArgumentException();
    }

    this.item = item;
    this.numberOfItems = numberOfItems;
  }

  public int price() {
    return item.price() * numberOfItems;
  }

  public String name() {
    return item.name();
  }
}
