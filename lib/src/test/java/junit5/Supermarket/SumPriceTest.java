package junit5.Supermarket;

import junit5.Supermarket.impl.SumPriceImpl;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumPriceTest {
  @Nested
  class 商品番号を渡すと1個あたりの金額を取得する {
    @Test
    void りんごのidを渡すと100円を取得する() {
      int itemId = Item.APPLE.getId();
      SumPrice sumPrice = new SumPriceImpl();
      assertEquals(sumPrice.getItemPrice(itemId),100);
    }

    @Test
    void みかんのidを渡すと40円を取得する() {
      int itemId = Item.ORANGE.getId();
      SumPrice sumPrice = new SumPriceImpl();
      assertEquals(sumPrice.getItemPrice(itemId),40);
    }
  }


}