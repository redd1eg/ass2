import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 10; // Начальная ёмкость массива
    private Object[] elements; // Массив для хранения элементов
    private int size; // Кол-во элементов в списке

    // Конструктор: создаёт массив с начальной ёмкостью
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(E element) {
        ensureCapacity(); // Увеличиваем массив при необходимости
        elements[size++] = element; // Добавляем элемент и увеличиваем размер
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity(); // Проверка на необходимость расширения массива
        System.arraycopy(elements, index, elements, index + 1, size - index); // Сдвигаем элементы вправо
        elements[index] = element;
        size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E old = (E) elements[index];
        elements[index] = element;
        return old;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E removedElement = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved); // Сдвигаем элементы влево
        }
        elements[--size] = null; // Удаляем ссылку на последний элемент (GC)
        return removedElement;
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
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY]; // Новый массив
        size = 0;
    }

    @Override
    public void sort(Comparator<E> cmp) {
        Arrays.sort((E[]) elements, 0, size, cmp); // Сортируем только значимую часть массива
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) elements[currentIndex++];
            }
        };
    }

    // Увеличиваем ёмкость массива в 2 раза, если он заполнен
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }
}
