import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E>, Iterable<E> {
    private class Node {
        E data;
        Node next;
        Node prev;

        Node(E data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    @Override
    public void add(E element) {
        Node newNode = new Node(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        checkIndexForAdd(index);
        if (index == size) {
            add(element);
            return;
        }
        Node current = getNode(index);
        Node newNode = new Node(element);
        newNode.next = current;
        newNode.prev = current.prev;
        if (current.prev != null) {
            current.prev.next = newNode;
        } else {
            head = newNode;
        }
        current.prev = newNode;
        size++;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        Node node = getNode(index);
        E old = node.data;
        node.data = element;
        return old;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        Node node = getNode(index);
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        size--;
        return node.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void sort(Comparator<E> cmp) {
        Object[] array = toArray();
        @SuppressWarnings("unchecked")
        E[] typed = (E[]) Arrays.copyOf(array, array.length);
        Arrays.sort(typed, cmp);
        clear();
        for (E e : typed) {
            add(e);
        }
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private Node getNode(int index) {
        checkIndex(index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private Object[] toArray() {
        Object[] result = new Object[size];
        Node current = head;
        int i = 0;
        while (current != null) {
            result[i++] = current.data;
            current = current.next;
        }
        return result;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
}
