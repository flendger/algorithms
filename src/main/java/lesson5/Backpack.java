package lesson5;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private final int maxWeight;
    private final List<BagItem> items;

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new ArrayList<>();
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public List<BagItem> getItems() {
        return items;
    }

    public void setItems(List<BagItem> items) {
        this.items.clear();
        this.items.addAll(items);
    }

    @Override
    public String toString() {
        return "Backpack{" +
                "maxWeight=" + maxWeight +
                ", items=" + items +
                '}';
    }
}
