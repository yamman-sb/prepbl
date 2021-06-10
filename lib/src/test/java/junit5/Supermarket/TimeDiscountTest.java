 package junit5.Supermarket;

 import junit5.Supermarket.impl.TimeDiscountImpl;
 import org.junit.jupiter.api.*;
 import static org.junit.jupiter.api.Assertions.*;

 class TimeDiscountTestMock{
     private TimeDiscount timeDiscount;

     @BeforeEach
     void setup() {
         timeDiscount = new TimeDiscountImpl();
     }

     @Test
     void _20時を過ぎたら金額が半額になる (){
         int result = timeDiscount.obentouDiscount(Item.SYAKEBENN, 2000, 21);
         assertEquals(1000,result);
     }

     @Test
     void _20時を過ぎないと金額が半額にならない (){
         int result = timeDiscount.obentouDiscount(Item.SYAKEBENN, 2000, 19);
         assertEquals(2000,result);
     }
 }
    
    