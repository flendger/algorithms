package lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class MyLinkedList <T extends Comparable<T>> {

    private Node<T> first;
    private Node<T> last;
    private int size;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Node<T> current = first;
        while (current != null) {
            sb.append(current.getValue());
            current = current.getNext();
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void insertFirst(T value) {
        first = new Node<>(value, first);
        if (last == null) {
            last = first;
        }
        size++;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return first.getValue();
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T tmp = first.getValue();
        first = first.getNext();
        if (first == null) {
            last = null;
        }
        size--;
        return tmp;
    }

    public void insertLast(T value) {
        if (isEmpty()) {
            insertFirst(value);
            return;
        }

        Node<T> tmp = new Node<>(value, null);
        last.setNext(tmp);
        last = tmp;
        size++;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return last.getValue();
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (first.equals(last)) {
            return removeFirst();
        }

        Node<T> current = first;
        //плохой алгоритм: чтобы получить предпоследний элемент, приходится всегда перебирать все элементы
        //решить можно было бы через двусвязанный список, где каждый элемент еще имеет ссылку на предыдущий
        while (!current.getNext().equals(last)) {
            current = current.getNext();
        }
        T tmp = last.getValue();
        last = current;
        last.setNext(null);
        size--;

        return tmp;
    }

    public int indexOf(T value) {
        if (isEmpty()) {
            return -1;
        }

        int idx = -1;
        int i = 0;
        Node<T> current = first;
        do {
            if (current.getValue().equals(value)) {
                idx = i;
                break;
            }
            current = current.getNext();
            i++;
        } while (current != null);

        return idx;
    }

    public void remove(T value) {
        if (isEmpty()) {
            throw new NoSuchElementException(value.toString());
        }

        Node<T> prev = null;
        Node<T> current = first;
        do {
            if (current.getValue().equals(value)) {
                break;
            }
            prev = current;
            current = current.getNext();
        } while (current != null);

        if (current == null) {
            throw new NoSuchElementException(value.toString());
        }

        if (prev == null) {
            removeFirst();
            return;
        }

        prev.setNext(current.getNext());
        if (current.getNext() == null) {
            last = prev;
        }
        size--;
    }

    public T remove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException(String.valueOf(idx));
        }

        Node<T> prev = null;
        Node<T> current = first;

        for (int i = 0; i < idx; i++) {
            prev = current;
            current = current.getNext();
        }

        if (current == null) {
            throw new NoSuchElementException();
        }

        if (prev == null) {
            return removeFirst();
        }

        T tmp = current.getValue();
        prev.setNext(current.getNext());
        if (current.getNext() == null) {
            last = prev;
        }
        size--;
        return tmp;
    }

    public boolean contain(T value) {
        if (isEmpty()) {
            return false;
        }

        Node<T> current = first;
        do {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        } while (current != null);

        return false;
    }

    public void insert(T value, int idx) {
        if (idx < 0 || idx > size) {
            throw new IllegalArgumentException(String.valueOf(idx));
        }

        if (idx == 0) {
            insertFirst(value);
            return;
        }
        if (idx == size) {
            insertLast(value);
            return;
        }

        Node<T> prev = first;
        Node<T> current = prev.getNext();
        for (int i = 1; i < idx; i++) {
            prev = current;
            current = current.getNext();
        }

        Node<T> tmp = new Node<>(value, current);
        prev.setNext(tmp);
        size++;
    }

    public Iterator<T> iterator() {
        return new Iter();
    }

    private static class Node<T>{

        private final T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private class Iter implements Iterator<T> {

        private final Node<T> head;
        private Node<T> current;

        public Iter() {
            this.head = first;
        }

        public Iter(Node<T> head) {
            this.head = head;
        }

        @Override
        public boolean hasNext() {
            if (current == null) {
                return head != null;
            }
            return current.getNext() != null;
        }

        @Override
        public T next() {
            if (current == null) {
                current = head;
            } else {
                current = current.getNext();
            }

            if (current == null) {
                throw new NoSuchElementException();
            }

            return current.getValue();
        }
    }
}
