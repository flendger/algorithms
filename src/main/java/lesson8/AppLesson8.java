package lesson8;

import java.util.Random;
import java.util.Scanner;

public class AppLesson8 {
    public static void main(String[] args) {
        ChainingHashMap<Integer, String> chm = new ChainingHashMap<>();
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int key = random.nextInt(100);
            chm.put(key, String.valueOf(key));
        }

        System.out.println(chm);

        Scanner scanner = new Scanner(System.in);
        int iKey = scanner.nextInt();
        System.out.println(chm.remove(iKey));
        System.out.println(chm);
    }
}
