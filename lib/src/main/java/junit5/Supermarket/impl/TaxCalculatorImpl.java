package junit5.Supermarket.impl;

import junit5.Supermarket.TaxCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import junit5.Supermarket.Item;

public class TaxCalculatorImpl implements TaxCalculator {

    @Override
    public BigDecimal countPriceWithTax(int id, int itemNum) {
        double taxRate = 0.08;
        if (id == Item.TOBACCO.getId() || id == Item.MENTHOLTOBACCO.getId()) {
            taxRate = 0;//タバコなら税率0にする
        }
        int itemPrice = 0;
        for (Item item : Item.values()) {
            if (item.getId() == id) {
                itemPrice = item.getPrice();
                break;
            }
        }
        BigDecimal discountAmount_decimal = new BigDecimal(taxRate * itemPrice * itemNum);//割引金額計算
        BigDecimal discountAmount = discountAmount_decimal.setScale(2, RoundingMode.HALF_UP);//割引金額小数二位まで保留
        return (discountAmount);
    }
}