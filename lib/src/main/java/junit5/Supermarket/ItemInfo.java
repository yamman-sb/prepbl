package junit5.Supermarket;

public class ItemInfo {
  private final Item item;
  private int sumQuantity;
  private int sumPrice;

  public ItemInfo(Item item, int sumQuantity, int sumPrice) {
    this.item = item;
    this.sumQuantity = sumQuantity;
    this.sumPrice = this.calSumPrice();
  }

  public Item getItem() {
    return item;
  }

  public int getSumQuantity() {
    return sumQuantity;
  }

  public int getSumPrice() {
    return sumPrice;
  }

  public void addQuantity(int itemQuantity) {
    this.sumQuantity += itemQuantity;
    this.sumPrice = this.calSumPrice();
  }

  public int calSumPrice() {
    return item.getPrice() * this.getSumQuantity();
  }
}
