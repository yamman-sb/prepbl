 package junit5.Supermarket.impl;

 import junit5.Supermarket.Item;
 import junit5.Supermarket.SumPrice;


 public class SumPriceImpl implements SumPrice {
     //@Override
     //public ArrayList<ItemInfo> SumFromItemList(List<Item> items) {
     //    return null;
     //}

  @Override
  public int getItemPrice(int itemId) {
   for (Item item : Item.values()) {
     if (item.getId() == itemId ) {
      return item.getPrice();
     }
   }
   return 0;
  }
 }