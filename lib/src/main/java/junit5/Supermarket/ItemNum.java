 package junit5.Supermarket;

 import junit5.Supermarket.Item;

 import java.util.List;


 public interface ItemNum {

    // それぞれの減算方法を試し、最も減算されるセールを返す
    int  calEachDiscount(List<ItemInfo> items);
 }