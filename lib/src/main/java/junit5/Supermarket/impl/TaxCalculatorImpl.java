package junit5.Supermarket.impl;

import junit5.Supermarket.TaxCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import junit5.Supermarket.Item;

public class TaxCalculatorImpl implements TaxCalculator {

  @Override
  public BigDecimal countPriceWithTax(int id, int itemSumPrice) {
    double taxRate = 0.08;
    if (id == Item.TOBACCO.getId() || id == Item.MENTHOLTOBACCO.getId()) {
      taxRate = 0;//タバコなら税率0にする
    }

    BigDecimal taxAmount_decimal = new BigDecimal(taxRate * itemSumPrice);//割引金額計算
    BigDecimal taxAmount = taxAmount_decimal.setScale(2, RoundingMode.HALF_UP);//割引金額小数二位まで保留
    return taxAmount;
  }
}