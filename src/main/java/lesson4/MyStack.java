package lesson4;


public class MyStack<T extends Comparable<T>> {

    private final MyLinkedList<T> list;

    public MyStack() {
        this.list = new MyLinkedList<>();
    }

    public T peek() {
        return list.getFirst();
    }

    public T pop() {
        return list.removeFirst();
    }

    public void push(T value) {
        list.insertFirst(value);
    }

    public int size() {
        return 0;
    }
}
