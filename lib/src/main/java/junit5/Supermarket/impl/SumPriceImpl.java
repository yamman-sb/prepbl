 package junit5.Supermarket.impl;

 import junit5.Supermarket.Item;
 import junit5.Supermarket.ItemInfo;
 import junit5.Supermarket.SumPrice;

 import java.util.List;

 public class SumPriceImpl implements SumPrice {
  //@Override
  //public ArrayList<ItemInfo> SumFromItemList(List<Item> items) {
  //    return null;
  //}

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
   for (Item item : itemList) {
    sumPriceOutput += item.getPrice();
   }
   return sumPriceOutput;
  }
 }