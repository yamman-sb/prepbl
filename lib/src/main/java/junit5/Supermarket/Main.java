package junit5.Supermarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import junit5.Supermarket.Item;
import junit5.Supermarket.impl.SumPriceImpl;

public class Main {
    public static void main(String[] args) {
        SumPrice sumPrice = new SumPriceImpl();
        List<Item> menuList = List.of(Item.APPLE, Item.ORANGE, Item.GRAPE, Item.NORIBEN, Item.SYAKEBENN, Item.TOBACCO, Item.MENTHOLTOBACCO, Item.LIGHTER, Item.TEA, Item.COFFEE);
        SystemIO systemIO = new SystemIO(menuList);

        systemIO.menuDisplay();
        systemIO.shopService();
        systemIO.setPaymentTime();

        int paymentTime = systemIO.getPaymentTime();
        List<Item> itemList = systemIO.getItemList();
        System.out.println("合計金額（税込み）：" + sumPrice.getItemListPrice(itemList) + "円");
    }
}