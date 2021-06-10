package junit5.Supermarket;

import junit5.Supermarket.impl.SumPriceImpl;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SumPriceTest {
  private SumPrice sumPrice;
  @BeforeEach
  void 前処理(){
    sumPrice = new SumPriceImpl();
  }

  @Nested
  class 商品番号を渡すと1個あたりの金額を取得する {
    @Test
    void りんごのidを渡すと100円を取得する() {
      int itemId = Item.APPLE.getId();
      assertEquals(sumPrice.getItemPrice(itemId),100);
    }

    @Test
    void みかんのidを渡すと40円を取得する() {
      int itemId = Item.ORANGE.getId();
      assertEquals(sumPrice.getItemPrice(itemId),40);
    }
  }

  @Nested
  class 商品番号を複数渡すと個数1個として金額を合計する {
    //940円になるはず
    @Test
    void りんご11個のリストを渡すと1100円を取得する() {
      List<Item> itemList = new ArrayList<Item>();
      for (int i = 0; i < 11; i++) {
        itemList.add(Item.APPLE);
      }

      assertEquals(sumPrice.getItemListPrice(itemList),1100);
    }
    //560円になるはず
    @Test
    void 弁当類一個とコーヒー一個とお茶一個のリストを渡すと580円を取得する() {
      List<Item> itemList = List.of(Item.SYAKEBENN, Item.COFFEE, Item.TEA);
      assertEquals(sumPrice.getItemListPrice(itemList),580);
    }
  }
}