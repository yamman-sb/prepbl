package junit5.Supermarket.impl;

import junit5.Supermarket.Item;
import junit5.Supermarket.ItemInfo;
import junit5.Supermarket.ItemNum;
import junit5.Supermarket.EventDiscount;
import junit5.Supermarket.impl.EventDiscountImpl;

import java.util.List;


public class ItemNumImpl implements ItemNum {
  private final EventDiscount eventDiscount;

  public ItemNumImpl(){
    this.eventDiscount = new EventDiscountImpl();
  }

  @Override
  public int calEachDiscount(List<ItemInfo> itemInfos){
    int discount = 0;
    // りンゴ
    for (ItemInfo itemInfo : itemInfos) {
      if (itemInfo.getItem().getId() == Item.APPLE.getId()) {
        discount = eventDiscount.appleEventDiscount(itemInfo.getItem().getId(), itemInfo.getSumQuantity());
      }
    }
    return discount;
  }
}

//   // @Override
//   // public static List<ItemInfo> calEachDiscount(List<ItemInfo> items){
//   //   // 課題4のセールを行う
//   //   appleEventDiscountSum = EventDiscount.appleEventDiscount();
//   //   // 課題5のセールを行う
//   //   tenItemNumDiscoutSum = EventDiscount.tenItemNum();
//   //   // 課題6のセールを行う
//   //   EventDiscount.tabaccoEventDiscount();
//   //   // 課題7のセールを行う

//   //   // それぞれのセールを比較する
//   // };


// }


// //
//   // private int appleNum;
//   // private int three_Set_Num;

//   // public ItemNum(int appleNum,int three_Set_Num)
//   // {
//   //   this.appleNum = appleNum;
//   //   this.three_Set_Num = three_Set_Num;
//   // }
  
//   // public int get_apple_Num(){
//   //   int unit_apple_Price = 0;
//   //   unit_apple_Price = Item.APPLE.price();
//   //   int applePrice = 0;
//   //   if(appleNum == 3){
//   //     applePrice = 280;
//   //   }
//   //   else
//   //   {
//   //     applePrice = unit_apple_Price * appleNum;
//   //   }
//   //   return applePrice;
//   // }
//   // three_Set_Num =Math.ceil(appleNum/3);
//   // return three_Set_Num;