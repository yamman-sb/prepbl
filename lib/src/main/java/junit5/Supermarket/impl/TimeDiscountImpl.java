 package junit5.Supermarket.impl;

 import junit5.Supermarket.TimeDiscount;
 import junit5.Supermarket.Item;

 public class TimeDiscountImpl implements TimeDiscount{
      @Override
      public int obentouDiscount(int id, int totalPrice, int paymentTime) {
          if (paymentTime >= 20 && ((id == Item.NORIBEN.getId()) || (id == Item.SYAKEBENN.getId()))) {
            return totalPrice/2;
          }else {
            return totalPrice;
          }
      }
 }