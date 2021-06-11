package junit5.Supermarket.impl;

import junit5.Supermarket.EventDiscount;
import junit5.Supermarket.Item;

public class EventDiscountImpl implements EventDiscount {
  @Override
  public int appleEventDiscount(int id, int num) {
    int sumAppleDiscount = 0;
    int threeSetNum = (num / 3);

    if (id == Item.APPLE.getId()) {
      sumAppleDiscount = threeSetNum * 20;
    }
    return sumAppleDiscount;
  }

}


