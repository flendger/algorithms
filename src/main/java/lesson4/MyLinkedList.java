package lesson4;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class MyLinkedList<T extends Comparable<T>> {

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
        Node<T> tmp = new Node<>(value, first, null);
        if (first != null) {
            first.setPrevious(tmp);
        }
        first = tmp;
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
        } else {
            first.setPrevious(null);
        }
        size--;
        return tmp;
    }

    public void insertLast(T value) {
        if (isEmpty()) {
            insertFirst(value);
            return;
        }

        Node<T> tmp = new Node<>(value, null, last);
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

        T tmp = last.getValue();
        last = last.getPrevious();
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

        Node<T> current = first;
        do {
            if (current.getValue().equals(value)) {
                break;
            }
            current = current.getNext();
        } while (current != null);

        if (current == null) {
            throw new NoSuchElementException(value.toString());
        }

        if (current.equals(first)) {
            removeFirst();
            return;
        }

        Node<T> prev = current.getPrevious();
        prev.setNext(current.getNext());
        if (current.getNext() == null) {
            last = prev;
        } else {
            current.getNext().setPrevious(prev);
        }
        size--;
    }

    public T remove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException(String.valueOf(idx));
        }

        Node<T> current = first;

        for (int i = 0; i < idx; i++) {
            current = current.getNext();
        }

        if (current == null) {
            throw new NoSuchElementException();
        }

        if (current.equals(first)) {
            return removeFirst();
        }

        Node<T> prev = current.getPrevious();

        T tmp = current.getValue();
        prev.setNext(current.getNext());
        if (current.getNext() == null) {
            last = prev;
        } else {
            current.getNext().setPrevious(prev);
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

        Node<T> current = first.getNext();
        for (int i = 1; i < idx; i++) {
            current = current.getNext();
        }

        Node<T> prev = current.getPrevious();
        Node<T> tmp = new Node<>(value, current, prev);
        prev.setNext(tmp);
        current.setPrevious(tmp);
        size++;
    }

    private Node<T> remove(Node<T> item) {
        Node<T> current = first;

        while (!current.equals(item)) {
            current = current.getNext();
        }

        if (current.equals(first)) {
            removeFirst();
            return null;
        }
        Node<T> prev = current.getPrevious();
        prev.setNext(current.getNext());
        if (current.getNext() != null) {
            current.getNext().setPrevious(prev);
        }
        size--;

        return prev;
    }

    private Node<T> insert(Node<T> current, T value) {
        if (current.equals(first)) {
            insertFirst(value);
            return first;
        }

        if (current.equals(last)) {
            insertLast(value);
            return last;
        }

        Node<T> tmp = new Node<>(value, current.getNext(), current.getPrevious());
        current.getPrevious().setNext(tmp);
        current.getNext().setPrevious(tmp);
        size++;
        return tmp;
    }

    public Iterator<T> iterator() {
        return new Iter();
    }

    public ListIterator<T> listIterator() {
        return new ListIter();
    }

    private static class Node<T> {

        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    private class Iter implements Iterator<T> {

        private Node<T> head;
        private Node<T> current;

        public Iter() {
            this.head = first;
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

        /**
        После удаления указатель смещается не предыдущий элемент
         **/
        @Override
        public void remove() {
            if (current == null) {
                throw new NoSuchElementException();
            }

            if (current.equals(head)) {
                head = current.getNext();
            }

            current = MyLinkedList.this.remove(current);
            if (current == null) {
                current = head;
            }
        }
    }

    private class ListIter implements ListIterator<T> {

        private Node<T> current;


        @Override
        public boolean hasNext() {
            if (current == null) {
                return first != null;
            }
            return current.getNext() != null;
        }

        @Override
        public T next() {
            if (current == null) {
                current = first;
            } else {
                current = current.getNext();
            }

            if (current == null) {
                throw new NoSuchElementException();
            }

            return current.getValue();
        }

        @Override
        public boolean hasPrevious() {
            if (current == null) {
                return false;
            }

            return current.getPrevious() != null;
        }

        @Override
        public T previous() {
            if (current == null || current.getPrevious() == null) {
                throw new NoSuchElementException();
            }
            current = current.getPrevious();
            return current.getPrevious().getValue();
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {
            if (current == null) {
                throw new NoSuchElementException();
            }

            current = MyLinkedList.this.remove(current);
        }

        @Override
        public void set(T t) {
            if (current == null) {
                throw new IllegalStateException();
            }

            current.setValue(t);
        }

        @Override
        public void add(T t) {
            if (current == null) {
                throw new IllegalStateException();
            }

            current = insert(current, t);
        }
    }
}
