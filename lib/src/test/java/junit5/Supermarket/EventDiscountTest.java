package junit5.Supermarket;

import junit5.Supermarket.impl.EventDiscountImpl;
import junit5.Supermarket.impl.SumPriceImpl;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventDiscountTest {
  private EventDiscount eventDiscount;

  @BeforeEach
  void 前処理() {
    eventDiscount = new EventDiscountImpl();
  }

  @Nested
  class 割引のテスト {
    @Nested
    class りんごの割引 {

      @Test
      void りんご3個の場合20を返す() {
        assertEquals(20, eventDiscount.appleEventDiscount(1, 3));
      }

      @Test
      void ミカン3個の場合0を返す() {
        assertEquals(0, eventDiscount.appleEventDiscount(2, 3));
      }

      @Test
      void りんご11個の場合60を返す() {
        assertEquals(60, eventDiscount.appleEventDiscount(1, 11));
      }
    }
  }
}


