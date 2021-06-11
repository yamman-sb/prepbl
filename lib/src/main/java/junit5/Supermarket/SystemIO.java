package junit5.Supermarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemIO {
    private final Scanner ans = new Scanner(System.in);
    private String input = "";
    private List<Item> menuList = new ArrayList<>();
    private final List<Item> itemList = new ArrayList<>();
    private int paymentTime = 0;

    public SystemIO(List<Item> menuList) {
        this.menuList = menuList;
    }

    public void menuDisplay() {
        System.out.println("メニューを表示します。");
        for (Item item : menuList) {
            System.out.println("ID " + item.getId() + " : " + item.getName() + ", " + item.getPrice() + "円");
        }
    }

    public void shopService() {
        int selectedItemId = 0;
        int selectedNumber = 0;

        while (true) {
            System.out.println("購入する商品番号を選択してください。(q : お会計をする)");
            input = ans.nextLine();
            if (input.equals("q")) {
                break;
            } else {
                try {
                    if ((Integer.parseInt(input) > 10) || (Integer.parseInt(input) < 1)) {
                        System.out.println("正しい商品番号を入力してください。");
                        continue;
                    } else {
                        selectedItemId = Integer.parseInt(input);
                    }
                } catch (Exception e) {
                    System.out.println("正しい商品番号を入力してください。");
                    continue;
                }
            }

            Item selectedItem = menuList.get(selectedItemId - 1);

            System.out.println(selectedItem.getName() + "を選択しました。購入する商品の数を入力してください。(q : 取り消し)");
            input = ans.nextLine();
            if (input.equals("q")) {
                continue;
            } else {
                try {
                    selectedNumber = Integer.parseInt(input);
                } catch (Exception e) {
                    System.out.println("正しい商品の数を入力してください。");
                    continue;
                }
            }

            for (int number = 0; number < selectedNumber; number++) {
                itemList.add(selectedItem);
            }

            System.out.println("買い物バスケットに入れました。");
        }
    }

    public void setPaymentTime() {
        while (true) {
            System.out.println("こちらはデモ版です。買い物する時刻を設定してください。(ex : 17時なら17を入力)");
            input = ans.nextLine();
            try {
                if ((Integer.parseInt(input) > 23) || (Integer.parseInt(input) < 0)) {
                    System.out.println("正しい時刻を入力してください。");
                    continue;
                } else {
                    paymentTime = Integer.parseInt(input);
                    break;
                }
            } catch (Exception e) {
                System.out.println("正しい時刻を入力してください。");
                continue;
            }
        }
    }

    public int getPaymentTime() {
        System.out.println(paymentTime + "時");
        return paymentTime;
    }

    public List<Item> getItemList() {
        return itemList;
    }
}
