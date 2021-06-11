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

    discountSum = itemNum.calEachDiscount(itemList);

    // ここを別のメソッドでItemInfoのSumPriceを使う
    for (ItemInfo itemInfo : itemList) {
      sumPriceOutput += itemInfo.getSumPrice();
      if (itemInfo.getItem().equals(Item.APPLE)){
        sumTax += taxCalculator.countPriceWithTax(itemInfo.getItem().getId(), (itemInfo.getSumPrice() - discountSum)).doubleValue();
      } else {
        sumTax += taxCalculator.countPriceWithTax(itemInfo.getItem().getId(), itemInfo.getSumPrice()).doubleValue();
      }
    }

    return (int) (sumPriceOutput + Math.ceil(sumTax) - discountSum);
  }
}