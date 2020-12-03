package lesson3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String txt;
        while (true) {
            System.out.print("Enter words: ");
            txt = scanner.nextLine();
            if (txt.isEmpty()) break;

            System.out.println(txt);

            MyDeque<Character> deque = new MyDeque<>(txt.length());
            for (Character c:txt.toCharArray()
                 ) {
                deque.insertLeft(c);
            }

            for (int i = 0; i < deque.capacity(); i++) {
                System.out.print(deque.removeLeft());
            }
            System.out.println();
        }

        System.out.println("Bye...");
    }
}
