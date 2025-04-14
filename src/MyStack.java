import java.util.EmptyStackException;

public class MyStack<E> {
    private MyArrayList<E> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(E element) {
        list.add(element);
    }

    public E pop() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1);
    }

    public E peek() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1);
    }
}