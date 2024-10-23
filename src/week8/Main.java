// 第八周课后习题（10月23日）
// 2. 发票打印：假设需要打印发票，发票中包含如下内容：抬头、订单号、货物名称、规格型号、数量、
// 单价、金额、总金额等。其中，货物名称由商家自定义，如音箱，货物名称：创新小音箱，
// 规格型号：Inspire T12。请模拟打印上述发票信息。
// 提示：基于商品中约定发票格式；具体商品的toString()中填入个性化信息。

package shelpam.week8;

import shelpam.week7.DoubleComparator;

public class Main {
  private static void SuperHeroDemoA() {
    PlanA.SuperHero superHero = PlanA.SuperHero.makeTanya();
    assert superHero.name().equals("Tanya") : "Name should be 'Tanya'";
    assert PlanA.SuperHero.makeTanya() == null : "Number of Tanya exceeds the maximum";

    superHero = PlanA.SuperHero.makeIvan();
    assert superHero.name().equals("Ivan") : "Name should be 'Ivan'";
    assert PlanA.SuperHero.makeIvan() == null : "Number of Tanya exceeds the maximum";
  }

  private static void SuperHeroDemoB() {
    PlanB.SuperHero superHero = PlanB.SuperHero.makeTanya();
    assert superHero.name().equals("Tanya") : "Name should be 'Tanya'";
    assert PlanB.SuperHero.makeTanya() == null : "Number of super hero(es) exceeds the maximum";
    assert PlanB.SuperHero.makeIvan() == null : "Number of super hero(es) exceeds the maximum";
    assert PlanB.SuperHero.makeTanya() == null : "Number of super hero(es) exceeds the maximum";
  }

  private static void ShapeDemo() {
    final DoubleComparator dc = new DoubleComparator(1e-8);

    Shape s = new Trapezoid(1, 2, 3);
    assert dc.isEqual(s.area(), 4.5);

    boolean throwed = false;
    try {
      double p = s.perimeter();
    } catch (Exception e) {
      throwed = true;
    }
    assert throwed;

    s = new Triangle(3, 4, 5);
    assert dc.isEqual(s.area(), 6);
    assert dc.isEqual(s.perimeter(), 12);

    s = new Circle(1);
    s.area();
    s.perimeter();

    s = new Rectangle(3, 5);
    assert dc.isEqual(s.area(), 15);
    assert dc.isEqual(s.perimeter(), 16);

    Shape[] shapes = { new Trapezoid(1, 2, 3), new Triangle(3, 4, 5),
      new Circle(1), new Rectangle(3, 5) };

    ShapeIdentifier si = new ShapeIdentifier();

    for (Shape shape : shapes) {
      si.identify(shape);
      System.out.println();
    }
  }

  private static void ShoppingCartDemo() {
    ItemSet[] items = {
      new ItemSet(2, new Item(100, "U-disk")),
      new ItemSet(1, new Item(2000, "Display")),
      new ItemSet(2, new Item(300, "Speaker"))
    };

    ShoppingCart sc = new ShoppingCart();

    System.out.println("Initial total price: " + sc.currentTotalPrice());
    for (ItemSet it : items) {
      sc.add(it);
      System.out.println("Current total price: " + sc.currentTotalPrice());
    }

    for (ItemSet it : items) {
      sc.remove(it);
      System.out.println("Current total price: " + sc.currentTotalPrice());
    }
    System.out.println();
  }

  private static void InvoiceDemo() {
    Invoice invoice = new Goods("Inspire Speaker", "Inspire T12");
    System.out.println(invoice);
  }

  public static void main(String[] args) {
    SuperHeroDemoA();
    SuperHeroDemoB();

    ShapeDemo();

    ShoppingCartDemo();

    InvoiceDemo();

    System.out.println("All tests passed.");
  }
}
