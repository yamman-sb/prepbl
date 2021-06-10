 package junit5.Supermarket.impl;

 import junit5.Supermarket.TaxCalculator;

 import java.math.BigDecimal;
 import java.math.RoundingMode;

 import junit5.Supermarket.Item;
 import junit5.Supermarket.TimeDiscount;

 public class TaxCalculatorImpl implements TaxCalculator{

   @Override
   public BigDecimal countPriceWithTax (int id, int num, int paymentTime){
       TimeDiscount timeDiscount = new TimeDiscountImpl();
       double taxRate = 0.08;
         if (id == Item.TOBACCO.getId() || id == Item.MENTHOLTOBACCO.getId() ){
             taxRate = 0;
         }
         int price = 0 ;
         for (Item i: Item.values()) {
             if (i.getId()==id){
                 price = i.getPrice();
                 break;
             }
         }
         int allPrice = price*num;
         allPrice = timeDiscount.obentouDiscount(id, allPrice, paymentTime);
         BigDecimal tmp  = new BigDecimal(taxRate*allPrice);
         BigDecimal  sum= tmp.setScale(2, RoundingMode.HALF_UP);
         return (sum);
         //return (taxRate*price*num);
     }
 }