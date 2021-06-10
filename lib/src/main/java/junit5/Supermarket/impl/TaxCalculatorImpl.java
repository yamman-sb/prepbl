 package junit5.Supermarket.impl;

 import junit5.Supermarket.TaxCalculator;

 import java.math.BigDecimal;
 import java.math.RoundingMode;

 import junit5.Supermarket.Item;
 public class TaxCalculatorImpl implements TaxCalculator{

   @Override
   public BigDecimal countPriceWithTax (int id, int num){
         double taxRate = 0.08;
         if (id == 7 || id ==8){
             taxRate = 0;
         }
         int price = 0 ;
         for (Item i: Item.values()) {
             if (i.getId()==id){
                 price = i.getPrice();
                 break;
             }

         }
         BigDecimal tmp  = new BigDecimal(taxRate*price*num);
         BigDecimal  sum= tmp.setScale(2, RoundingMode.HALF_UP);
         return (sum);
         //return (taxRate*price*num);
     }


 }