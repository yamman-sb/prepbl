package junit5.Supermarket.impl;

import junit5.Supermarket.*;

import java.math.BigDecimal;
import java.util.List;

public class SumPriceImpl implements SumPrice {
//@Override
//public ArrayList<ItemInfo> SumFromItemList(List<Item> items) {
//    return null;
//}
  private final TaxCalculator taxCalculator;

  public SumPriceImpl() {
    taxCalculator = new TaxCalculatorImpl();
  }

  @Override
  public int getItemPrice(int itemId) {
    for (Item item : Item.values()) {
      if (item.getId() == itemId) {
        return item.getPrice();
      }
    }
   return 0;
  }

  @Override
  public int getItemListPrice(List<ItemInfo> itemList, int paymentTime) {
    int sumPriceOutput = 0;
    double sumTax = 0.0;
    TimeDiscount timeDiscount = new TimeDiscountImpl();

    // ここを別のメソッドでItemInfoのSumPriceを使う
    for (ItemInfo itemInfo : itemList) {
      sumPriceOutput += itemInfo.getItem().getPrice() * itemInfo.getSumQuantity();
      sumPriceOutput = timeDiscount.obentouDiscount(itemInfo.getItem().getId(), sumPriceOutput, paymentTime);
      sumTax += taxCalculator.countPriceWithTax(itemInfo.getItem().getId(), itemInfo.getSumQuantity(), paymentTime).doubleValue();
    }

    return (int) (sumPriceOutput + Math.ceil(sumTax));
  }
}