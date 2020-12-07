package lesson5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppLesson5 {

    private final static Random rnd = new Random();


    public static void main(String[] args) {
        int maxWeight = 50;
        List<BagItem> bagItems = generateItems(10, maxWeight, 20);
        System.out.println(bagItems);

        Backpack pack = new Backpack(rnd.nextInt(maxWeight)+1);
        pack.getItems().add(bagItems.get(5));
        System.out.println(pack);
    }

    private static List<BagItem> generateItems(int count, int maxWeight, int maxValue) {
        List<BagItem> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new BagItem(i, rnd.nextInt(maxWeight)+1, rnd.nextInt(maxValue)+1));
        }
        return list;
    }
}
