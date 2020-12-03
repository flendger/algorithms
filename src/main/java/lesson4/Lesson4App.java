package lesson4;

import java.util.Iterator;

public class Lesson4App {

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.insertLast("val0");
        list.removeLast();
        list.insertFirst("val1");
        System.out.println(list.remove(0));
        list.insertFirst("val2");
        list.insertFirst("val3");
        list.insertFirst("val4");
        list.insert("val7", 1);
        System.out.println(list);


        System.out.println(list.removeFirst());
        System.out.println(list.getFirst());
        System.out.println(list.size());
        System.out.println(list);

        list.insertLast("val5");
        System.out.println("index " + list.indexOf("val5"));
        list.remove("val5");
        System.out.println(list.size());
        System.out.println(list);
        System.out.println(list.getLast());
        System.out.println(list.removeLast());
        System.out.println(list.size());
        System.out.println(list);
        System.out.println(list.contain("val33"));

        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }
}
