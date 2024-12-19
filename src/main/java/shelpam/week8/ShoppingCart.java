package shelpam.week8;

import java.util.HashMap;

public class ShoppingCart {
  private HashMap<String, ItemSet> items;
  private int totalPrice;

  public ShoppingCart() {
    items = new HashMap<String, ItemSet>();
  }

  public void add(ItemSet item) {
    if (items.containsKey(item.name())) {
      throw new IllegalArgumentException("Item has already been in shoping cart");
    }

    totalPrice += item.price();
    items.put(item.name(), item);
  }

  public void remove(String itemName) {
    remove(items.get(itemName));
  }

  public void remove(ItemSet item) {
    totalPrice -= item.price();
    items.remove(item.name());
  }

  public int currentTotalPrice() {
    return totalPrice;
  }
}
