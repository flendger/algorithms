package lesson5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppLesson5 {

    private final static Random rnd = new Random();


    public static void main(String[] args) {
        int maxWeight = 50;
        Backpack bag = new Backpack(rnd.nextInt(maxWeight) + 1);
        List<BagItem> bagItems = generateItems(7, bag.getMaxWeight()/2, 100);
        System.out.println(bagItems);

        pack(bag, bagItems);

        System.out.println(bag);
    }

    private static List<BagItem> generateItems(int count, int maxWeight, int maxValue) {
        List<BagItem> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new BagItem(i, rnd.nextInt(maxWeight) + 1, rnd.nextInt(maxValue) + 1));
        }
        return list;
    }

    public static void pack(Backpack bag, List<BagItem> items) {
        pack(bag, items, items.size());
    }

    private static void pack(Backpack bag, List<BagItem> items, int newSize) {
        if (newSize == 1) return;

        for (int i = 0; i < newSize; i++) {
            pack(bag, items, newSize - 1);
            if (newSize == 2) {
                List<BagItem> pack = getPackage(bag, items);
                if (getSumValue(bag.getItems()) < getSumValue(pack)) {
                    bag.setItems(pack);
                }
            }
            rotate(items, newSize);
        }
    }

    private static void rotate(List<BagItem> items, int newSize) {
        if (newSize == 1) return;

        int bg = items.size() - newSize;
        BagItem tmp = items.get(bg);
        for (int i = bg + 1; i < items.size(); i++) {
            items.set(i - 1, items.get(i));
        }
        items.set(items.size() - 1, tmp);
    }

    private static int getSumValue(List<BagItem> items) {
        return items.stream().mapToInt(BagItem::getValue).sum();
    }

    private static List<BagItem> getPackage(Backpack bag, List<BagItem> items) {
        List<BagItem> list = new ArrayList<>();
        int remain = bag.getMaxWeight();
        for (BagItem item : items
        ) {
            if (item.getWeight() <= remain) {
                list.add(item);
                remain -= item.getWeight();

                if (remain <= 0) break;
            }
        }

        return list;
    }
}
