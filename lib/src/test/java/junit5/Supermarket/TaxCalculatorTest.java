/*
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("消費税計算test")
class TaxCalculatorTest {
    private TaxCalculator t;
    @BeforeEach
    void 準備(){
        t = new TaxCalculator();
    }

    @Nested
    class 番号と個数を渡すと合計消費税を返す{
        @Test
        void _みかん３個(){
            BigDecimal d = new BigDecimal("9.60");
            assertEquals(d, t.countTax(2,3));
        }

    }


}