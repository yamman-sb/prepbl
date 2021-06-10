package junit5.Supermarket;

import java.util.List;

public interface SumPrice{
   int getItemPrice(int itemId);

   int getItemListPrice(List<Item> itemList);
   //List<ItemInfo> SumFromItemList(List<Item>);

 }
