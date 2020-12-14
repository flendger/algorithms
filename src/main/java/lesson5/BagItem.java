package lesson5;

public class BagItem {

    private final int id;
    private final int weight;
    private final int value;


    public BagItem(int id, int weight, int value) {
        this.id = id;
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BagItem{" +
                "id=" + id +
                ", weight=" + weight +
                ", value=" + value +
                '}';
    }

    public int getId() {
        return id;
    }
}
