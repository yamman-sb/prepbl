package junit5.Supermarket;

import org.junit.jupiter.api.*;

import junit5.Supermarket.impl.TaxCalculatorImpl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("消費税計算test")
class TaxCalculatorTest {

    private TaxCalculator t;

    @BeforeEach
    void 準備() {
        t = new TaxCalculatorImpl();
    }

    @Nested
    class 番号と個数を渡すと合計消費税を返す {
        @Test
        void みかん３を渡すと割引金額9_60を返す() {
            BigDecimal d = new BigDecimal("9.60");
            assertEquals(d, t.countPriceWithTax(2, 3));
        }

        @Test
        void タバコ何個渡しても消費税0() {
            BigDecimal d = new BigDecimal("0.00");
            assertEquals(d, t.countPriceWithTax(7, 3));
        }

    }


}

