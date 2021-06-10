package junit5.Supermarket.impl;

import junit5.Supermarket.Item;
import junit5.Supermarket.SumPrice;
import junit5.Supermarket.TaxCalculator;

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
  public int getItemListPrice(List<Item> itemList) {
    int sumPriceOutput = 0;
    double sumTax = 0.0;

    for (Item item : itemList) {
      sumPriceOutput += item.getPrice();
      sumTax += taxCalculator.countPriceWithTax(item.getId(), 1).doubleValue();
    }

    return (int) (sumPriceOutput + Math.ceil(sumTax));
  }
}