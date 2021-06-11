package junit5.Supermarket.impl;

import junit5.Supermarket.Item;
import junit5.Supermarket.ItemInfo;
import junit5.Supermarket.ItemNum;
import junit5.Supermarket.EventDiscount;
import junit5.Supermarket.impl.EventDiscountImpl;

import java.util.List;


public class ItemNumImpl implements ItemNum {
  private final EventDiscount eventDiscount;

  public ItemNumImpl() {
    this.eventDiscount = new EventDiscountImpl();
  }

  @Override
  public int calEachDiscount(List<ItemInfo> itemInfos) {
    int discount = 0;
    for (ItemInfo itemInfo : itemInfos) {
      if (itemInfo.getItem().getId() == Item.APPLE.getId()) {
        discount = eventDiscount.appleEventDiscount(itemInfo.getItem().getId(), itemInfo.getSumQuantity());
      }
    }
    return discount;
  }
}
