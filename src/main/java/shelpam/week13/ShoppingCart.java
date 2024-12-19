package shelpam.week13;

import java.util.Random;

public class ShoppingCart {
    private String name;
    private Goods goods;
    private int consumption;

    public ShoppingCart(String name, Goods goods) {
        this.name = name;
        this.goods = goods;
        Random r = new Random();
        this.consumption = r.nextInt(3) + 1;
    }

    public void settle() {
        int left = goods.getNumber() - consumption;
        if (left < 0) {
            System.out.println(name + "'s settlement failed. " + consumption +
                " wanted. But only " + goods.getNumber() + " left.");
            return;
        }
        goods.setNumber(left);
        System.out.println(name + "'s settlement successful. " + consumption +
            " bought.");
    }
}
