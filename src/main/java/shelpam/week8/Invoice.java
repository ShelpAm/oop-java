package shelpam.week8;

// Actually, this can be implemented as template method :) .

public class Invoice {
  private String header;
  private String orderNumber;
  private String goodsName;
  private String specificationModel;
  private int quantity;
  private double unitPrice;
  private double amount;
  private double totalAmount;

  // 暂时先不管别的成员

  protected Invoice(String goodsName, String specificationModel) {
    this.goodsName = goodsName;
    this.specificationModel = specificationModel;
  }

  @Override
  public String toString() {
    return "Invoice {" +
                "header='" + header + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", specificationModel='" + specificationModel + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", amount=" + amount +
                ", totalAmount=" + totalAmount +
                '}';
  }
}
