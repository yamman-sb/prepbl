package junit5.Supermarket.impl;

import junit5.Supermarket.*;

import java.util.List;

public class SumPriceImpl implements SumPrice {

  private final TaxCalculator taxCalculator;
  private final ItemNum itemNum;

  public SumPriceImpl() {
    taxCalculator = new TaxCalculatorImpl();
    itemNum = new ItemNumImpl();
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
  public int getItemListPrice(List<ItemInfo> itemList) {
    int sumPriceOutput = 0;
    double sumTax = 0.0;
    int discountSum;

    // ここを別のメソッドでItemInfoのSumPriceを使う
    for (ItemInfo itemInfo : itemList) {
      sumPriceOutput += itemInfo.getSumPrice();
      sumTax += taxCalculator.countPriceWithTax(itemInfo.getItem().getId(), itemInfo.getSumQuantity()).doubleValue();
    }

    discountSum = itemNum.calEachDiscount(itemList);
    return (int) (sumPriceOutput + Math.ceil(sumTax) - discountSum);
  }
}