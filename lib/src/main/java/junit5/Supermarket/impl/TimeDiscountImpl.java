 package junit5.Supermarket.impl;

 import junit5.Supermarket.TimeDiscount;
 import junit5.Supermarket.Item;

 public class TimeDiscountImpl implements TimeDiscount{
      @Override
      public int obentouDiscount(Item item, int totalPrice, int paymentTime) {
          if (paymentTime >= 20 && (item.getName().equals("のり弁") || item.getName().equals("しゃけ弁"))) {
            return totalPrice/2;
          }else {
            return totalPrice;
          }
      }
 }