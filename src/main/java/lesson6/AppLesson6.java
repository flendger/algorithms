package lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppLesson6 {

    private final static Random RND = new Random();
    private final static int TREE_COUNT = 1000;
    private final static int MAX_HEIGHT = 3;

    public static void main(String[] args) {
//        MyTreeMap<Integer, Integer> tree = new MyTreeMap<>();
//        tree.put(0, 0);
//        System.out.println(tree.height());
//        tree.put(5, 5);
//        System.out.println(tree.height());
//        tree.put(3, 3);
//        System.out.println(tree.height());
//        tree.put(4, 4);
//        System.out.println(tree.height());
//        tree.put(6, 6);
//        System.out.println(tree.height());
//        tree.put(1, 1);
//        System.out.println(tree.height());
//        tree.put(7, 7);
//        System.out.println(tree.height());
//        tree.put(8, 8);
//        System.out.println(tree.height());
//        System.out.println(tree.isBalanced());
//        System.out.println(tree);

        List<MyTreeMap<Integer, Integer>> trees = new ArrayList<>();
        for (int i = 0; i < TREE_COUNT; i++) {
            trees.add(createTree());
        }

        int balanced = (int) trees.stream()
                .filter(MyTreeMap::isBalanced)
                .count();

        System.out.printf("Balanced trees: %.2f %% \n", ((float) balanced)/TREE_COUNT*100);
    }

    private static MyTreeMap<Integer, Integer> createTree() {
        MyTreeMap<Integer, Integer> tree = new MyTreeMap<>();

        while (tree.height() < MAX_HEIGHT) {
            Integer kv = RND.nextInt(201) - 100;
            tree.put(kv, kv);
        }

        return tree;
    }
}
