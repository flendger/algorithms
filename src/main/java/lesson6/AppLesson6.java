package lesson6;

public class AppLesson6 {
    public static void main(String[] args) {
        MyTreeMap<Integer, Integer> tree = new MyTreeMap<>();
        tree.put(0, 0);
        System.out.println(tree.height());
        tree.put(5, 5);
        System.out.println(tree.height());
        tree.put(3, 3);
        System.out.println(tree.height());
        tree.put(4, 4);
        System.out.println(tree.height());
        tree.put(6, 6);
        System.out.println(tree.height());
        tree.put(1, 1);
        System.out.println(tree.height());
        tree.put(7, 7);
        System.out.println(tree.height());
        tree.put(8, 8);
        System.out.println(tree.height());

        System.out.println(tree);
    }
}
