package junit5.Supermarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import junit5.Supermarket.Item;
import junit5.Supermarket.impl.SumPriceImpl;

public class Main {
  public static void main(String[] args) {
    Scanner ans = new Scanner(System.in);
    String input = "";
    List<Item> itemList = List.of(Item.APPLE, Item.ORANGE, Item.GRAPE, Item.NORIBEN, Item.SYAKEBENN, Item.TOBACCO, Item.MENTHOLTOBACCO, Item.LIGHTER, Item.TEA, Item.COFFEE);
    List<ItemInfo> purchaseList = new ArrayList<>();
    List<Integer> itemNums = new ArrayList<Integer>(); // 選んだ商品の番号を保存
    int selectedItemId = 0;
    int selectedNumber = 0;
    int paymentTime = 0;

    System.out.println("メニューを表示します。");
    for (Item item : itemList) {
      System.out.println("ID " + item.getId() + " : " + item.getName() + ", " + item.getPrice() + "円");
    }

    while (true) {
      System.out.println("購入する商品番号を選択してください。(q : お会計をする)");
      input = ans.nextLine();
      if (input.equals("q")) {
        break;
      } else {
        try {
          if ((Integer.parseInt(input) > 10) || (Integer.parseInt(input) < 1)) {
            System.out.println("正しい商品番号を入力してください。");
            continue;
          } else {
            selectedItemId = Integer.parseInt(input);
          }
        } catch (Exception e) {
          System.out.println("正しい商品番号を入力してください。");
          continue;
        }
      }

      Item selectedItem = itemList.get(selectedItemId - 1);

      System.out.println(selectedItem.getName() + "を選択しました。購入する商品の数を入力してください。(q : 取り消し)");
      input = ans.nextLine();
      if (input.equals("q")) {
        continue;
      } else {
        try {
          selectedNumber = Integer.parseInt(input);
        } catch (Exception e) {
          System.out.println("正しい商品の数を入力してください。");
          continue;
        }
      }

      // purchaseListに同じ商品がない場合は新規作成、ある場合追加
      if (itemNums.contains(selectedItemId) ) {
        // 追加
        for (ItemInfo itemInfo : purchaseList) {
          if (itemInfo.getItem().getId()  == selectedItemId) {
            itemInfo.addQuantity(selectedNumber);
          }
        }
      } else {
        // 新規作成
        ItemInfo itemInfo = new ItemInfo(selectedItem, selectedNumber, 0);
        purchaseList.add(itemInfo);
      }
    }

    while (true) {
      System.out.println("こちらはデモ版です。買い物する時刻を設定してください。(ex : 17時なら17を入力)");
      input = ans.nextLine();
      try {
        if ((Integer.parseInt(input) > 23) || (Integer.parseInt(input) < 0)) {
          System.out.println("正しい時刻を入力してください。");
          continue;
        } else {
          paymentTime = Integer.parseInt(input);
          break;
        }
      } catch (Exception e) {
        System.out.println("正しい時刻を入力してください。");
        continue;
      }
    }

    System.out.println(paymentTime + "時");
    SumPrice sumPrice = new SumPriceImpl();

    System.out.println("合計金額（税込み）：" + sumPrice.getItemListPrice(purchaseList, paymentTime) + "円");
  }
}