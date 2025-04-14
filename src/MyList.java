import java.util.Comparator;
import java.util.Iterator;

public interface MyList<E> {
    void add(E element);
    void add(int index, E element);
    E get(int index);
    E set(int index, E element);
    E remove(int index);
    int size();
    boolean isEmpty();
    void sort(Comparator<E> cmp);
    void clear(); // Добавлен метод clear()
    Iterator<E> iterator();
}
