package lesson3;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyDeque<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private T[] list;
    private int size;
    private int right;
    private int left;

         // 0 1 2 3 4
    //<--//
         //         b
         //       e

    //-->//     8 5 7

    public MyDeque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
        left = capacity-1;
    }

    public MyDeque() {
        this(DEFAULT_CAPACITY);
    }

    public T peekRight() {
        if (isEmpty()) throw new NoSuchElementException();

        return list[right];
    }

    public T peekLeft() {
        if (isEmpty()) throw new NoSuchElementException();

        return list[left];
    }

    public void insertLeft(T item) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        size++;
        left = nextIndex(left);
        list[left] = item;
    }

    public void insertRight(T item) {
        if (isFull()) throw new IllegalStateException();

        size++;
        right = prevIndex(right);
        list[right] = item;
    }

    public T removeRight() {
        T temp = peekRight();
        size--;
        list[right] = null;
        right = nextIndex(right);
        return temp;
    }

    public T removeLeft() {
        T temp = peekLeft();
        size--;
        list[left] = null;
        left = prevIndex(left);
        return temp;
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int prevIndex(int index) {
        if (index == 0) return list.length-1;

        return (index - 1) % list.length;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    public int capacity() {
        return list.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(list) + " right: " + right + " left: " + left;
    }
}
