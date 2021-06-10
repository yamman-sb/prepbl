package junit5.Supermarket;

import java.math.BigDecimal;

public interface TaxCalculator {

 BigDecimal countPriceWithTax(int id, int num);
}